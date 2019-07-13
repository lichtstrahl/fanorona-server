package root.iv.fanorona.data.visit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Visit.TABLE_NAME)
public class Visit {
    public static final String TABLE_NAME = "visit";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "name", nullable = false)
    private String name;
}
