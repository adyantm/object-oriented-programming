package hw06;

/**
 * This class represents the hw06.Summarizable interface.
 *
 * @author adyantm.
 * @version 1.0.
 */
public interface Summarizable {
    /**
     * summarizes course.
     *
     * @return String.
     */
    String summarize();

    /**
     * compares two objects.
     *
     * @param other hw06.Course.
     * @return int value.
     */
    int compareTo(Course other);
}
