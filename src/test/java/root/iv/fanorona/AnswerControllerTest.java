package root.iv.fanorona;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import root.iv.fanorona.controller.AnswerController;
import root.iv.fanorona.data.answer.Answer;

import javax.inject.Inject;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnswerControllerTest {
    @Inject
    private AnswerController answerController;

    @Test
    public void testAnswer() {
        Answer testAnswer = Answer.create("TEST-ANSWER");
        int oldCount = answerController.getAnswers().getBody().size();

        Answer added = answerController.create(testAnswer).getBody();

        // Добавленный ответ является ожидаемым
        Assert.assertEquals(added.getContent(), testAnswer.getContent());
        // Добавилась ровно 1 запись
        Assert.assertEquals(answerController.getAnswers().getBody().size() - 1, oldCount);

        answerController.delete(added.getId());
        // Численность записей пришла в норму
        Assert.assertEquals(answerController.getAnswers().getBody().size(), oldCount);
    }
}
