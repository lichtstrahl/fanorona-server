package root.iv.fanorona.data.visit;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Перед вставкой данной сущности. Установленное время увеличивается на 3 часа
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = Visit.TABLE_NAME)
public class Visit {
    public static final String TABLE_NAME = "visit";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "ts", nullable = false)
    private long ts;

    @Column(name = "name", nullable = false)
    private String name;

    public static Visit create(String name, Calendar date) {
        Visit visit = new Visit();
        visit.setName(name);
        visit.setDate(date.getTime().toString());
        visit.setTs(date.getTime().getTime());
        return visit;
    }
}
