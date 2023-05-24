package hw07;//I worked on the assignment alone, using only course-provided materials.

/**
 * Represents an object of type hw07.Vet.
 *
 * @author adyantm.
 * @version 1.0
 */
public class Vet {

    /**
     * Static method that inspects hw07.Pet.
     *
     * @param pet object pet.
     */
     public static void inspectPet(Pet pet) {
        System.out.println(pet.toString());
        if (pet instanceof Dog) {
            Dog dog = (Dog) (pet);
            dog.bark();
        }
    }

    /**
     * Static method that treats pet.
     *
     * @param pet object pet.
     */
     public static void treatPet(Pet pet) {
        if (pet instanceof Treatable) {
            System.out.println("Welcome to the vet " + pet.name);
            ((Treatable) pet).treat();
            if (pet instanceof Dog) {
                System.out.println("Wow what a cute dog!");
                giveDogTreat((Dog) pet);
            }
        } else {
            System.out.println("Sorry, we cannot treat " + pet.name);
        }
    }

     /**
     * Static method that reduces dog pain level.
     *
     * @param dog object
     */
     public static void giveDogTreat(Dog dog) {
        dog.painLevel -= 2;
        if (dog.painLevel < 0) {
            dog.painLevel = 1;
        }
    }
}
