package hw07;

/**
 * This class represents a hw07.Cat object.
 *
 * @author adyantm.
 * @version 1.0.
 */
public class Cat extends Pet implements Treatable {
   protected boolean hasStripes;

    /**
     * Constructor for cat object.
     *
     * @param name String.
     * @param age int.
     * @param painLevel int.
     * @param hasStripes boolean.
     */
    public Cat(String name, int age, int painLevel, boolean hasStripes) {
        super(name, age, painLevel);
        this.hasStripes = hasStripes;
    }

    /**
     * Constructor for hw07.Cat Object.
     *
     * @param hasStripes boolean.
     */
    public Cat(boolean hasStripes) {
        this("Purrfect", 4, 9, hasStripes);
    }

    /**
     * Void method that defines cat's playWith method.
     *
     * @param p object P.
     */
    void playWith(Pet p) {
        if (p instanceof Cat) {
            Cat cat = (Cat) (p);
            if (this.hasStripes && cat.hasStripes) {
                this.painLevel -= 4;
                System.out.println("Meow! I love playing with other cats "
                        + "with the same pattern as me");
            } else {
                this.painLevel -= 2;
                System.out.println("Meow! I love playing with other cats"
                        + "without the same pattern as me");
            }
        }
        if (p instanceof Dog) {
            Dog dog = (Dog) (p);
            this.painLevel += 1;
            System.out.println("Meow. Go away "
                    + dog.name + "! I don't like playing with Dogs!");
        }
    }

    /**
     * Void method that defines treat.
     *
     */
    public void treat() {
       this.painLevel -= 1;
    }

    /**
     * ToString method that summarizes cat object.
     *
     * @return String.
     */
    public String toString() {
        return "My name is " + this.name + "and I am "
                + this.age + ". On a scale of one to ten my pain level is "
                + this.painLevel + ". My age in human years is "
                + Treatable.convertCatToHumanYears(this.age);
    }

    /**
     * Equals method that checks if two cat objects are equal.
     *
     * @param o object o.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cat) || o.equals(null)) {
            return false;
        }
        Cat cat = (Cat) (o);
        return super.equals(cat)
                && this.hasStripes == cat.hasStripes;
    }
}
