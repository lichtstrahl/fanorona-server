package root.iv.fanorona.data.message;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
public class Message {
    private String from;
    private String message;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("from", from)
                .append("message", message)
                .toString();
    }
}
