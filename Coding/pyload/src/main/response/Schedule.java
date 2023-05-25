package response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Schedule {
    private Timestamp start;
    private Timestamp end;
    private int priority;
    private boolean expEnabled;
}
