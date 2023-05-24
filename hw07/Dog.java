package hw07;

/**
 * Represents an object hw07.Dog that extends hw07.Pet class.
 *
 * @author adyantm.
 * @version 1.0.
 */
public class Dog extends Pet implements Treatable {
    /**
     * Getter method for breed.
     *
     * @return String breed.
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Setter method for breed.
     *
     * @param breed String breed.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * String breed.
     */
    private String breed;

    /**
     * Constructor that sets values for hw07.Dog object.
     *
     * @param name String.
     * @param age int.
     * @param painLevel int.
     * @param breed String.
     */
    public Dog(String name, int age, int painLevel, String breed) {
        super(name, age, painLevel);
        this.breed = breed;
    }

    /**
     * 1 arg constructor that sets values for hw07.Dog object.
     *
     * @param breed String
     */
    public Dog(String breed) {
        this("Buzz", 6, 3, breed);
    }

    /**
     * Void method that defines the playWith method from the interface.
     *
     * @param p object P.
     */
    public void playWith(Pet p) {
        if (p instanceof Dog) {
            System.out.println("Woof! I love playing with other dogs so "
                    + "much that " + "my pain level went from "
                    + this.painLevel + " to "
                    + (this.painLevel - 3));
            this.painLevel -= 3;
        }
        if (p instanceof Cat) {
            Cat c = ((Cat) p);
            if (c.hasStripes) {
                System.out.println("AHHH! I thought you were a tiger!");
                this.painLevel += 2;
            } else {
                System.out.println("Woof. Cats without stripes are okay since "
                        +
                        "they made my pain level go from "
                        + this.painLevel + "to "
                        + (this.painLevel - 1));
                this.painLevel -= 1;
            }
        }
    }

    /**
     * Void methods that decreases dog's pain level.
     *
     */
    public void treat() {
        painLevel = painLevel - 3;
    }

    /**
     * Void method that prints out dog's bark.
     *
     */
    public void bark() {
        System.out.println("bark bark");
    }

    /**
     * ToString method that returns summary of hw07.Dog object.
     *
     * @return String.
     */
    public String toString() {
        return "My name is " + this.name + ", I am "
                + this.age + ", and I am a "
                + this.breed
                + ". On a scale of one to ten my pain level is "
                + this.painLevel + ". My age in human years is "
                + Treatable.convertDogToHumanYears(this.age) + ".";
    }

    /**
     * Equals method that compares dog objects.
     *
     * @param o object o.
     * @return boolean.
     */

    public boolean equals(Object o) {
        if (!(o instanceof Dog) || o.equals(null)) {
            return false;
        }
        Dog d = ((Dog) o);
        return super.equals(d) && this.breed.equals(d.breed);
    }
}
