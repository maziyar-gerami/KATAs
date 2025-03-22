import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeapYearTest {

    @Test
    public void testLeapYear_divisibleYear() {
        int[] years = new int[]{1, 200, 300, 400, 1996};
        LeapYear leapYear = new LeapYear();

        assertFalse(leapYear.calculate(years[0]));
        assertFalse(leapYear.calculate(years[1]));
        assertTrue(leapYear.calculate(years[3]));
        assertTrue(leapYear.calculate(years[4]));
    }
}