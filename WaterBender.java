package hw05;

/**
 * This class represents a hw05.WaterBender object.
 *
 * @author adyantm
 * @version 1.0
 */
@SuppressWarnings("checkstyle:JavadocPackage")
class WaterBender extends Bender {
    /**
     * Whether the waterBender is a healer or not.
     */
    protected boolean healer;

    /**
     * This is a constructor that takes in 1 String, 2 ints, and 1 boolean.
     * @param name1 variable 1
     * @param strength1 variable 2
     * @param health1 variable 3
     * @param healer1 variable 4
     */
    public WaterBender(String name1, int strength1,
                       int health1, boolean healer1) {
        super(name1, strength1, health1);
        healer = healer1;
    }

    /**
     * This is a constructor that takes in 1 String.
     * @param name1 variable 1
     */
    public WaterBender(String name1) {
         super(name1, 40, 80);
         healer = false;
    }

    /**
     * returns health.
     * @return an int
     */
    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public int getHealth() {
        return super.getHealth();
    }

    /**
     * gets strength from superClass.
     * @return int
     */
    @Override
    public int getStrength() {
        return super.getStrength();
    }

    /**
     * gets Name from superClass.
     * @return a string
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * gets healer value.
     * @return boolean
     */
    public boolean getHealer() {
        return healer;
    }


    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public void attack(final Bender b) {
        if (isAlive()) {
            if (b instanceof FireBender) {
                b.setHealth(b.getHealth() - getStrength());
                if (b.getHealth() < 0) {
                    b.setHealth(0);
                }
            } else if (b instanceof WaterBender) {
                b.setHealth(b.getHealth() - 1);
                if (b.getHealth() < 0) {
                    b.setHealth(0);
                }
            }
        }
    }

    public void heal(final WaterBender wb) {
        if (!healer || !isAlive()) {
            return;
        }
        if (healer) {
            wb.setHealth(getHealth() + 40);
        } else {
            wb.setHealth(getHealth() + 20);
        }
    }

    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public boolean equals(final Object bender) {
        return super.equals(bender);
    }

    /***
     * makes a string summary of hw05.WaterBender attributes.
     * @return a String
     */
    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public String toString() {
        if (getHealer()) {
            return super.toString()
                    + " With my waterbending, I can heal others.";
        }
        return super.toString()
                + " With my waterbending, I cannot heal others.";
    }
}


