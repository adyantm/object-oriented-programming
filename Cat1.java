package hw04;

/**
 *This class represents a hw04.hw07.Cat object.
 *@author Adyant Mishra
 *
 *@version 1.0
 */
public final class Cat1 {

    private String name;
    private int age;
    private double runningSpeed;
    private boolean isKitten;
    private static String breed = "Persian Tabby";

    public Cat1(String name, int age, double runningSpeed) {

        this.name = name;
        this.age = age;
        this.runningSpeed = runningSpeed;
        isKitten = age <= 6;
    }

    public Cat1(String name, double ageInYears, double runningSpeed) {

        this.name = name;
        int getTenths = (int) ageInYears % 10;
        double value = ageInYears - getTenths;
        int x = (int) (Math.round((value * 12) * 10) / 10);
        this.age = (getTenths * 12) + x;
        this.runningSpeed = runningSpeed;
        isKitten = age <= 6;
    }

    public Cat1(String name) {

        this.name = name;
        this.age = 5;
        this.runningSpeed = 5;
        isKitten = age <= 6;
    }

    public void increaseAge(final int months) {

        if (age < 12) {
            for (int i = age; i < age + months; i++) {
                runningSpeed += 2;
            }
            age += months;

        }
        if (age > 30) {
            for (int i = age; i < age + months; i++) {
                runningSpeed -= 3;
            }
            age += months;

            if (runningSpeed < 5) {
                runningSpeed = 5;
            }
            isKitten = age <= 6;
        }
    }

    public void increaseAge() {

        increaseAge(1);
    }

    public void eat(Mouse mouse) {
        if (mouse.isDead()) {
            return;
        }
        if (runningSpeed > mouse.getSpeed()) {
            mouse.setMass(0.0);
            if (mouse.getMass() * 0.65 >= age) {
                increaseAge(1);
            }
        } else {
            mouse.consumeCheese();
        }
    }

    public String toString() {
        String runningSpeed1 = String.format("%.2f", runningSpeed);
        if (isKitten) {
            return "My name is "
                    + name + " and I'm a Kitten! " + "I'm "
                    + age + " months old and I run at the speed of "
                    + runningSpeed1 + ".";
        }
        return "My name is "
                + name + " and I'm a " + breed + ".I'm "
                + age + " months old and I run at the speed of "
                + runningSpeed1 + ".";

    }

    public void setAge(int age) {
        this.age = age;
        if (age <= 6) {
            isKitten = true;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRunningSpeed(double runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public void setKitten(boolean kitten) {
        isKitten = kitten;
    }

    public static void setBreed(String breed1) {
        breed = breed1;
    }

    public static String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getRunningSpeed() {
        return runningSpeed;
    }

    public boolean getIsKitten() {
        return isKitten;
    }
}
