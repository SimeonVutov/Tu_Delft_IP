import java.util.Optional;

public class CalculatorApplication {

    /**
     * Safely divides two doubles.
     *
     * @param dividend The dividend, i.e. a in a/b
     * @param divisor The divisor, i.e. b in a/b
     * @return An optional of the quotient or an empty optional if the divisor is zero
     */
    public static Optional<Double> safeDivide(double dividend, double divisor) {
        if(divisor != 0.0) {
            return Optional.of(dividend / divisor);
        }
        return Optional.empty();
    }

}
