package hw07;

/**
 * This class represents a hw07.Narwhal object that extends hw07.Pet.
 *
 * @author adyantm.
 * @version 1.0.
 */
public class Narwhal extends Pet {
    private int hornLength;

    /**
     * Constructor representing hw07.Narwhal object.
     *
     * @param name String.
     * @param age int.
     * @param painLevel int.
     * @param hornLength int.
     */
    public Narwhal(String name, int age, int painLevel, int hornLength) {
        super(name, age, painLevel);
        this.hornLength = hornLength;
    }

    /**
     * Constructor that sets default values.
     */
    public Narwhal() {
        this("Jelly", 19, 2, 7);
    }

    /**
     * Implements playWith method.
     *
     * @param p object P.
     */
    void playWith(Pet p) {
        if (p instanceof Narwhal) {
            this.painLevel -= 2;
            System.out.println("Who needs dogs and "
                    +
                    "cats when we have each other");
        } else {
            this.painLevel += 1;
            System.out.println("I live in the ocean "
                    + "so I can't play with you");
        }
    }

    /**
     * ToString method that summarizes hw07.Narwhal's characteristics.
     *
     * @return String value.
     */
    public String toString() {
        return super.toString() + " I have a horn that is "
                + hornLength + " feet long.";
    }

    /**
     * Equals method that compares two object.
     *
     * @param o object o.
     * @return boolean value.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Narwhal) || o.equals(null)) {
            return false;
        } else {
            Narwhal n = (Narwhal) (o);
            return super.equals(n)
                    && this.hornLength == n.hornLength;
        }
    }
}
