package hw05; //I worked on the assignment alone, using only course-provided materials.

/**
 * This class represents a hw05.Bender object.
 *
 * @author Adyant Mishra
 * @version 1.0
 */

public abstract class Bender {
    protected String name;
    protected int strength;
    protected int health;

    /**
     * This is a constructor that takes in 1 String and 2 ints.
     * @param name1 variable 1
     * @param strength1 variable 2
     * @param health1 variable 3
     */
    public Bender(String name1, int strength1, int health1) {
        name = name1;
        strength = strength1;
        health = health1;
    }

    /**
     * Sets the name of a bender.
     *
     * @param name String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name.
     *
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the health.
     *
     * @param health int health.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets the health.
     *
     * @return health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the strength.
     *
     * @param strength int strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Gets the strength.
     *
     * @return an int
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Method that checks if bender is alive.
     *
     * @return a boolean
     */
    public boolean isAlive() {
        return health > 0;
    }
    public abstract void attack(Bender b);

    /**
     * Returns if the two objects are equal.
     * @param bender
     * @return boolean
     */
    public boolean equals(final Object bender) {
        if (bender == null) {
            return false;
        } else if (getClass() != bender.getClass()) {
            return false;
        }
       return this.getStrength() == ((Bender) bender).getStrength()
               && this.getName().equals(((Bender) bender).getName())
               && this.getHealth() == ((Bender) bender).getHealth();
    }

    /***
     * makes a string summary of bender attributes.
     * @return a String
     */
    public String toString() {
        return "My name is "
                + name + ". " + "I am a bender. My strength is "
                + strength + " and my current health is "
                + health + ".";
    }

}
