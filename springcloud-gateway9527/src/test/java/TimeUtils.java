import java.sql.Time;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

public class TimeUtils {

    public static void main(String[] args) {
        time();
    }
    public static ZonedDateTime time(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        return now;
    }
}
