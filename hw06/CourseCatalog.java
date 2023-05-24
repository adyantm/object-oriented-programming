package hw06;

import java.util.Arrays;

/**
 * This class represents the hw06.CourseCatalog Object.
 *
 * @author Adyant Mishra
 * @version 1.0
 */
public class CourseCatalog {
    /**
     * catalog of Courses.
     */
    private Course[] catalog;

    /**
     * Default constructor for hw06.CourseCatalog.
     */
    public CourseCatalog() {
      catalog = new Course[0];
    }

    /**
     * Constructor for hw06.CourseCatalog
     *
     * @param catalog hw06.Course[].
     */
    public CourseCatalog(Course[] catalog) {
        this.catalog = catalog;
        Arrays.sort(catalog);
    }

    /**
     * Prints out the courseCode and summarizes each course.
     */
    public void browseCourseCatalog() {
        for (Course c : catalog) {
            System.out.println(c.getCourseCode() + ": " + c.summarize());
        }
    }

    /**
     * Adds a newCourse to the catalog.
     *
     * @param newCourse hw06.Course object.
     */
    public void addCourse(Course newCourse) {
        Course[] array = new Course[catalog.length + 1];
        for (int i = 0; i < catalog.length; i++) {
            array[i] = catalog[i];
        }
            array[array.length - 1] = newCourse;
            Arrays.sort(array);
            this.catalog = array;
    }

    /**
     * returns course with given courseCode.
     *
     * @param courseCode String.
     * @return hw06.Course.
     */
    public Course getCourse(String courseCode) {
            for (int i = 0; i < catalog.length; i++) {
                if (catalog[i].getCourseCode().equals(courseCode)) {
                    return catalog[i];
                }
            }
            return null;
        }

    /**
     * returns the number of courses in the catalog.
     *
     * @return int value of number of courses.
     */
        public int getNumberOfCourses() {
        return catalog.length;
    }
}
