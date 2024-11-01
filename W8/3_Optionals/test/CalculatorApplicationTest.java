import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorApplicationTest {
    @Test
    void safeDivide() {
        Optional<Double> result = CalculatorApplication.safeDivide(2.0, 4.0);
        assertTrue(result.isPresent());
        assertEquals(0.5, result.get());
    }

    @Test
    void zeroDivisionTest() {
        Optional<Double> result = CalculatorApplication.safeDivide(2.0, 0.0);
        assertTrue(result.isEmpty());
    }
}