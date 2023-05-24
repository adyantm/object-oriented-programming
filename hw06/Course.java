package hw06;

/**
 * This class represents the hw06.Course interface.
 *
 * @author adyantm.
 * @version 1.0.
 */
public abstract class Course implements Comparable<Course>, Summarizable {

    private String title;
    private String courseCode;
    private int creditHours;
    private String subject;

    /**
     * Constructor for hw06.Course object.
     *
     * @param title String.
     * @param subject String.
     * @param courseCode String.
     * @param creditHours int.
     */
    public Course(String title, String subject,
                  String courseCode, int creditHours) {
        this.title = title;
        this.subject = subject;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }

    /**
     * Returns the course code. Necessary to access subclass.
     *
     * @return String courseCode.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the course code. Necessary to access subclass.
     *
     * @param courseCode String courseCode.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Returns the course title. Necessary to access subclass.
     *
     * @return String title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the course title. Necessary to access subclass.
     *
     * @param title String courseCode.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns number of Credit Hours.
     *
     * @return int creditHours.
     */
    public int getCreditHours() {
        return creditHours;
    }

    /**
     * Sets number of credit Hours.
     *
     * @param creditHours int creditHours.
     */
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    /**
     * Summarizes each course.
     *
     * @return String summary.
     */
    @Override
    public String summarize() {
        return "This course is "
                + title + ". The course is "
                + creditHours + " credit hours.";
    }

    /**
     * method that compares two hw06.Course objects.
     *
     * @param other the object to be compared.
     * @return int value.
     */
    @Override
    public int compareTo(Course other) {
        return this.getCourseCode().compareTo(other.getCourseCode());
    }

       /* int num1 = 0;
        int num2 = 0;
        int x = this.getCourseCode().compareTo(other.getCourseCode());
        if(x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        } else if (x == 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
           for(char c: this.getCourseCode().toCharArray()) {
                if(Character.isDigit(c)){
                    sb.append(c);
                }
           }
           for(char d: other.getCourseCode().toCharArray()) {
                if(Character.isDigit(d)){
                    sb2.append(d);
                }
           }
           int a = Integer.parseInt(sb.toString());
           int b = Integer.parseInt(sb2.toString());
           if (Integer.compare(a,b) > 0 ) {
               return 1;
           } else if (Integer.compare(a,b) < 0) {
               return -1;
           }
        }
        return 0;
    } */

}
