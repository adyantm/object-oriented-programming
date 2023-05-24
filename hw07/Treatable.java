package hw07;

/**
 * This class represents an interface treatable.
 *
 * @author adyantm.
 * @version 1.0.
 */
public interface Treatable {
    /**
     * Static method that converts given int to human years.
     *
     * @param age int.
     * @return int converted human years.
     */
    static int convertDogToHumanYears(int age) {
        return (int) (Math.floor(16 * Math.log(age) + 31));
    }
    /**
     * Static method that converts given int to human years.
     *
     * @param age int.
     * @return int converted human years.
     */
    static int convertCatToHumanYears(int age) {
        return (int) (Math.floor(9 * Math.log(age) + 18));
    }
    /**
     * Void method to be implemented by subclasses implementing the interface.
     *
     */
    void treat();
    default void pay(){
        System.out.println("Give me money");
    }
}
