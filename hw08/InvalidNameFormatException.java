package hw08;

/**
 * This class represents the invalid name format
 * exception that extends exception.
 *
 * @author adyantm.
 * @version 1.0.
 */
public class InvalidNameFormatException extends Exception {
    /**
     * hw08.InvalidNameFormatException constructor.
     *
     * @param x String x.
     */
    public InvalidNameFormatException(String x) {
        super(x);
    }
}
