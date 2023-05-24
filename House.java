package hw04;

//I worked on the assignment alone, using only course-provided materials.
public class House {
    public static void main(String[] args) {
        final Cat1 garfield = new Cat1("Garfield");
        final Cat1 tom = new Cat1("Tom", 10, 15);
        final Cat1 meowth = new Cat1("Meowth", 4.6, 5);
        final Cat1 ady = new Cat1("Ady", 5, 6);
        Mouse x = new Mouse(100, 3);
        Mouse y = new Mouse(60);
        Mouse jerry = new Mouse(50, 3);
        Cat1.setBreed("1331 Cats");
        System.out.println(garfield);
        System.out.println(y);
        meowth.increaseAge(8);
        meowth.eat(y);
        System.out.println(y);
        System.out.println(tom);
        System.out.println(ady);
        meowth.increaseAge(4);
        System.out.println(meowth);
        System.out.println(garfield);
    }
}

