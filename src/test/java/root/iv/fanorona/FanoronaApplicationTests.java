package root.iv.fanorona;

import org.awaitility.Awaitility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import root.iv.fanorona.controller.HomeController;
import root.iv.fanorona.data.visit.Visit;
import root.iv.fanorona.data.visit.VisitRepository;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FanoronaApplicationTests {
	private static final String[] VISIT_NAMES = new String[] {
			"igor", "egor", "sveta"
	};

	@Inject
	private VisitRepository visitRepository;
	@Inject
	private HomeController homeController;

	@Test
	public void contextLoads() {
		int oldVisits = visitRepository.findAll().size();

		for (String name : VISIT_NAMES) {
			homeController.home(name);
			Awaitility.await().atMost(2, TimeUnit.SECONDS);
			System.out.println(String.format("%s visit", name));
		}

		List<Visit> newVisits = visitRepository.findAll();
		int actualCount = newVisits.size();
		Assert.assertEquals(actualCount, VISIT_NAMES.length+oldVisits);

		newVisits.sort((v1, v2) -> (int)(v1.getTs()-v2.getTs()));

		// Последний посетитель
		Visit lastVisit = newVisits.get(actualCount-1);
		Assert.assertEquals(lastVisit.getName(), VISIT_NAMES[VISIT_NAMES.length-1]);

		for (int i = 0; i < VISIT_NAMES.length; i++) {
			String currentName = VISIT_NAMES[VISIT_NAMES.length -1 - i];
			Visit visit = newVisits.get(actualCount - 1 - i);
			Assert.assertEquals(visit.getName(), currentName);
		}

	}


}
