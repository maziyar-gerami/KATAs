public class DetectPrimeNumbersbyTDDTest {

    @Test
    public void testDetector_withPrimeNumbers() {
        assertTrue(DetectPrimeNumbersbyTDD.detector(11));
    }

    @Test
    public void testDetector_withNotPrimeNumbers() {
        assertFalse(DetectPrimeNumbersbyTDD.detector(9));
    }

    @Test
    public void testDetector_withEdgeCase1() {
        assertFalse(DetectPrimeNumbersbyTDD.detector(1));
    }

    @Test
    public void testDetector_withZero() {
        assertFalse(DetectPrimeNumbersbyTDD.detector(0));
    }

    @Test
    public void testDetector_withNegative() {
        assertThrows(IllegalArgumentException.class, () -> DetectPrimeNumbersbyTDD.detector(-5));
    }


}
