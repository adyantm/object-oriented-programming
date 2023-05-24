package hw06;

/**
 * This class represents a hw06.MechanicalEngr Object.
 *
 * @author adyantm.
 * @version 1.0.
 */
public class MechanicalEngr extends Course {
    /**
     * String array of equations.
     */
    private String[] equations;

    /**
     * Constructor for hw06.MechanicalEngr.
     *
     * @param title String.
     * @param subject String.
     * @param courseCode String.
     * @param creditHours int.
     * @param equations array.
     */
    public MechanicalEngr(String title, String subject, String courseCode,
    int creditHours, String[] equations) {
        super(title, subject, courseCode, creditHours);
        this.equations = equations;
    }

    /**
     * summarizes characterists of me major.
     *
     * @return string value.
     */
    @Override
    public String summarize() {
        String x = super.summarize() + " This course uses these equation(s): ";
        for (int i = 0; i < equations.length; i++) {
            if (i == equations.length - 1) {
                x += equations[i] + ".";
            } else {
                x += equations[i] + ", ";
            }
        }
        return x;
    }
}
