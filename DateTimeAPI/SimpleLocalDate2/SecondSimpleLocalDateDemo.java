import java.time.LocalDate;

public class SecondSimpleLocalDateDemo {
    
    public static void main(String[] args) {
        var today = LocalDate.now();
        var nextYear = today.plusYears(1);
        System.out.println(nextYear);
    }
}
