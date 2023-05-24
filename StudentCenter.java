//I worked on the assignment alone, using only course-provided materials.

import java.util.Scanner;

public class StudentCenter {
    public static void main(String[] args) {
        System.out.println("Welcome to the Student Center! ");
        System.out.println("Activities");
        System.out.println("Bowling: $4.00 ($2 to rent bowling shoes) ");
        System.out.println("Billiards: $5.00");
        System.out.println("Food");
        System.out.println("Pizza: $8.50 ");
        System.out.println("Salad: $7.00");

        System.out.println('\n');

        System.out.print("What activity would you like to do? ");
        Scanner x = new Scanner(System.in);
        double activityTotal=0.0;

        String activity = x.next();


        if (activity.equalsIgnoreCase("Bowling")) {
            activityTotal += 4;
            System.out.print("Do you need bowling shoes? ");
            String b = x.next();
            if (b.equalsIgnoreCase("Yes")) {
                activityTotal += 2;
            }
        }
        else
        {
            activityTotal+=5;
        }

        System.out.print('\n');
        System.out.print('\n');
        System.out.print("What food would you like? ");


        String food = x.next();
        double foodTotal = 0.00;
        if (food.equalsIgnoreCase("Pizza"))
        {
            foodTotal+=8.50;
            System.out.print("Choose a topping (mushrooms: $1.5, pepperoni: $1, none: $0)  ");
            String topping = x.next();

            switch (topping.toUpperCase())
            {

                case "PEPPERONI":
                {
                    foodTotal+=1;
                    break;
                }
                case "MUSHROOMS":
                {
                    foodTotal+=1.5;
                    break;
                }
                case "NONE":
                {
                    foodTotal+=0;
                }

                default:
                    break;}}
        else
        {
            foodTotal+=7;
        }

        System.out.println('\n');
        System.out.print("What percentage would you like to tip for the food? ");
        double tip = x.nextDouble();

        if (tip < 0 )

        {
            tip = .18;
        }

        System.out.print('\n');
        System.out.print('\n');
        System.out.print("How many people are with you? ");
        int people = x.nextInt();
        if(people<0){
            people=0;
        }
        double subtotal = 0;
        double foodTip = 0;
        double finalPrice = 0;

        if (people == 0)
        {
            subtotal = (activityTotal + foodTotal);
            foodTip = (foodTotal) * (tip);
            finalPrice = (subtotal + foodTip);

        }
        else {
            people++;
            subtotal = (activityTotal + foodTotal) * (people);
            foodTip = (foodTotal) * ((people) * tip);
            finalPrice = (subtotal + foodTip);
        }



        System.out.print('\n');
        System.out.print('\n');
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Food Tip: $" + String.format("%.2f", foodTip));
        System.out.println("Total: $" + String.format("%.2f", finalPrice));


    }
}
