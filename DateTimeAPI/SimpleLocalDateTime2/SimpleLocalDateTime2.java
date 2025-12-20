import java.time.LocalDateTime;

public class SimpleLocalDateTime2 {
    
    public static void main(String[] args) {
        var now = LocalDateTime.now();
        var nextWeek = now.plusWeeks(1);
        System.out.println(now);
        System.out.println(nextWeek);

    }
}
