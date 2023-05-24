package hw05;

/**
 * This class represents a hw05.FireBender Object.
 *
 * @author adyantm
 * @version 1.0
 */
public class FireBender extends Bender {
    /**
     * Represents a fireBender's sourceStrength.
     */
    private static double fireSourceStrength = 1;

    /**
     * This is a constructor that takes in 1 string and 2 ints.
     * @param name first variable
     * @param strength second variable
     * @param health third variable
     */
   public FireBender(String name, int strength, int health) {
       super(name, strength, health);
   }

    /**
     * gets the fireSourcestrength.
     * @return double
     */
    public static double getFireSourceStrength() {
        return fireSourceStrength;
    }

    /**
     * gets strength of bender from super class.
     * @return an int
     */
    @Override
    public int getStrength() {
       return super.getStrength();
    }

    /**
     * gets Name.
     * @return a String
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * returns health.
     * @return an int
     */
    @Override
    public int getHealth() {
        return super.getHealth();
    }

    /**
     * This is a constructor that takes in 1 string
     * @param name variable 1
     */
    public FireBender(String name) {
       super(name, 60, 50);
   }


    public void attack(Bender b) {
        if (this.isAlive()) {
            if (b instanceof WaterBender) {
               b.setHealth((b.getHealth()
                       - (int) (getStrength() * getFireSourceStrength())));
               if (b.getHealth() < 0) {
                   b.setHealth(0);
               }
            }
            if (b instanceof FireBender) {
                b.setHealth((int) (b.getHealth() - fireSourceStrength));
                if (b.getHealth() < 0) {
                    b.setHealth(0);
                }
            }
            fireSourceStrength = fireSourceStrength - 0.05;
            if (fireSourceStrength < 0) {
                fireSourceStrength = 0;
            }
        }
    }

    /**
     * This method replenishes fireSources.
     */
    public void replenishFireSources() {
       if (this.getStrength() < 50) {
           fireSourceStrength = 0.8;
       } else {
           fireSourceStrength = 1;
       }
    }

    /***
     * returns a String summary of firebender attributes.
     * @return a String
     */
    @Override
    public String toString() {
        return super.toString() + " I bend fire.";
    }
}
