package root.iv.fanorona.data.question;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = Question.TABLE_NAME)
public class Question implements Serializable {
    public static final String TABLE_NAME = "question";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;
}
