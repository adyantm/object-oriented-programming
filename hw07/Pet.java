package hw07;

/**
 * This class represents the hw07.Pet object.
 *
 * @author adyantm.
 * @version 1.0.
 */
public abstract class Pet {
    /**
     * String pet name.
     */
    protected String name;
    /**
     * Int pet age.
     */
    protected int age;
    /**
     * Int pet painLevel.
     */
    protected int painLevel;

    /**
     * Constructor representing hw07.Pet object.
     *
     * @param name String.
     * @param age int.
     * @param painLevel int.
     */
    public Pet(String name, int age, int painLevel) {
        this.name = name;

        if (age < 1) {
            this.age = 1;
        } else if (age > 100) {
            this.age = 100;
        } else {
        this.age = age;
        }
        if (painLevel < 1) {
            this.painLevel = 1;
        } else if (painLevel > 10) {
            this.painLevel = 10;
        } else {
        this.painLevel = painLevel;
    }
}
    /**
     * Allows two pets to play.
     *
     * @param p object P.
     */

     abstract void playWith(Pet p);

    /**
     * ToString method that summarizes characteristics of hw07.Pet Object.
     *
     * @return String.
     */
    public String toString() {
        return "My name is " + name + "and I am "
                + age + ". On a scale of one to ten my pain level is "
                + painLevel + ".";
    }

    /**
     * Equals object that checks if two objects are equal if params are equal.
     *
     * @param o object o.
     * @return boolean true if equal.
     */
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Pet)) {
            return false;
        } else {
            Pet pet = (Pet) o;
            return this.toString().equals(o.toString());
        }
    }
}
