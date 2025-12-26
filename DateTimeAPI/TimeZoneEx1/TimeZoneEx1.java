import java.time.ZoneId;

public class TimeZoneEx1 {
    
    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds().contains("Asia/Tehran"));

        ZoneId.of("Asia/Tehran").getRules().getTransitions().forEach(System.out::print);
    }
    
}
