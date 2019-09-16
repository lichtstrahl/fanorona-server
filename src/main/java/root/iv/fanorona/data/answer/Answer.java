package root.iv.fanorona.data.answer;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "answer")
public class Answer implements Serializable {
    public static final String TABLE_NAME = "answer";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    public static Answer create(String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        return answer;
    }

}
