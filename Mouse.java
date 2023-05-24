package hw04;

public final class Mouse {
    private double mass = 0.0;
    private double speed = 0.0;

    public Mouse(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Mouse(double mass) {
        this.mass = mass;
        this.speed = 10;
    }

    public Mouse() {
        this.mass = 50;
        this.speed = 10;
    }

    public void consumeCheese() {
        mass += 20;
        if (mass < 100) {
            speed += 1;
        } else {
            speed -= 0.5;
        }
    }

    public boolean isDead() {
        return mass == 0;
    }

    public String toString() {
        String speed1 = String.format("%.2f", speed);
        String  mass1 = String.format("%.2f", mass);
        if (mass == 0) {
            return "I'm dead, but I used to be a mouse with a speed of "
                    + speed1 + ".";
        }
        return "I'm a speedy mouse with "
                + speed1 + " speed and " + mass1 + " mass.";
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }
}
