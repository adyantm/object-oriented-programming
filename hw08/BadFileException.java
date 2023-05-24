package hw08;

/**
 * Class represents a bad file exception.
 *
 * @author adyantm.
 * @version 1.0.
 */
public class BadFileException extends RuntimeException {
    /**
     * hw08.BadFileException constructor.
     *
     * @param x String x.
     */
    public BadFileException(String x) {
        super(x);
    }
}
