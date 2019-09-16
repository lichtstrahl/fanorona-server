package root.iv.fanorona.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import root.iv.fanorona.data.answer.Answer;
import root.iv.fanorona.data.answer.AnswerRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Locale;

@Controller
public class AnswerController {
    private Logger logger = LoggerFactory.getLogger(AnswerController.class);

    @Inject
    private AnswerRepository answerRepository;

    @PostMapping(value = "/api/answers")
    public ResponseEntity<Answer> create(@RequestBody Answer answer) {

        logger.info(String.format("Создание Answer с текстом \"%s\"", answer.getContent()));
        answer.setId(null);
        Answer newAnswer = answerRepository.save(answer);
        return ResponseEntity.ok(newAnswer);
    }

    @PutMapping(value = "/api/answers")
    public ResponseEntity<Answer> update(@RequestBody Answer answer) {
        Long id = answer.getId();
        Answer old = answerRepository.getOne(id);
        old.setContent(answer.getContent());
        answerRepository.flush();
        return ResponseEntity.ok(old);
    }

    @GetMapping(value = "/api/answers")
    public ResponseEntity<Answer> getAnswer(@RequestParam(name = "id") Long id) {
        Answer answer = answerRepository.getOne(id);
        Assert.notNull(answer, String.format(Locale.ENGLISH, "Not found answer with id = %d", id));
        return ResponseEntity.ok(answer);
    }

    @GetMapping(value = "/api/answers/all")
    public ResponseEntity<List<Answer>> getAnswers() {
        List<Answer> answers = answerRepository.findAll();
        return ResponseEntity.ok(answers);
    }

    @DeleteMapping(value = "/api/answers")
    public ResponseEntity<Void> delete(@RequestParam(name = "id") Long id) {
        answerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
