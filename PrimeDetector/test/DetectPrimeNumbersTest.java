public class DetectPrimeNumbersTest {
    
    @Test
    public void testDetector_withPrimeNumbers(){
        assertTrue(DetectPrimeNumbers.detector(11));
    }
    @Test
    public void testDetector_withNotPrimeNumbers(){
        assertFalse(DetectPrimeNumbers.detector(9));
    }
    @Test
    public void testDetector_withEdgeCase1() {
        assertFalse(DetectPrimeNumbers.detector(1));
    }

    @Test
    public void testDetector_withZero() {
        assertFalse(DetectPrimeNumbers.detector(0));
    }

    @Test
    public void testDetector_withNegative() {
        assertFalse(DetectPrimeNumbers.detector(-5));
    }
}
