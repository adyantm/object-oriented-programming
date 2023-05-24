package hw06;//I worked on the assignment alone, using only course-provided materials.

/**
 * This class represents the hw06.ComputerScience object.
 *
 * @author adyantm.
 * @version 1.0.
 */
public class ComputerScience extends Course {
    /**
     * language representing the Computer Science Object.
     */
    private String language;
    /**
     * boolean hasLab. set true if object has lab component.
     */
    private boolean hasLab;

    /**
     * Constructor for hw06.ComputerScience object.
     *
     * @param title String.
     * @param subject String.
     * @param courseCode String.
     * @param creditHours int.
     * @param language String.
     * @param hasLab boolean.
     */
    public ComputerScience(String title, String subject, String courseCode,
                           int creditHours, String language, boolean hasLab) {

        super(title, subject, courseCode, creditHours);
        this.language = language;
        this.hasLab = hasLab;
    }

    /**
     * summarizes the Computer Science object.
     *
     * @return String summary.
     */
    public String summarize() {
        if (hasLab) {
            return super.summarize() + " The language used in this course is "
                    + language + ", and it has a lab component.";
        }
        return super.summarize() + " The language used in this course is "
                + language + ", and it doesn't have a lab component.";
    }
}
