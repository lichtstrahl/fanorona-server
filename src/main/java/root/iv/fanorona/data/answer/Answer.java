package root.iv.fanorona.data.answer;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "answer")
public class Answer implements Serializable {
    public static final String TABLE_NAME = "answer";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Id
    @Column(name = "content", nullable = false)
    private String content;
}
