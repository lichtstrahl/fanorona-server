package root.iv.fanorona.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import root.iv.fanorona.data.visit.Visit;
import root.iv.fanorona.data.visit.VisitRepository;

import javax.inject.Inject;
import java.util.*;

@Controller
public class HomeController {
    private static final String GMT_MOSCOW = "GMT+3:00";
    private final VisitRepository visitRepository;

    @Inject
    public HomeController(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @GetMapping
    public ModelAndView home(@RequestParam(name = "name", defaultValue = "Игорь", required = false) String name) {
        Map<String, Object> model = new HashMap<>();
        model.put("name", name);


        Date now = Calendar.getInstance().getTime();
        Visit visit = Visit.builder()
                        .date(now)
                        .name(name)
                        .build();
        visitRepository.save(visit);


        return new ModelAndView("home", model, HttpStatus.OK);
    }

    @GetMapping("/api/stats")
    public ResponseEntity stats() {
        List<Visit> list = visitRepository.findAll();
        Date date = list.get(list.size()-1).getDate();

        return ResponseEntity.ok(list);
    }
}
