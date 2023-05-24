//I worked on the assignment alone, using only course-provided materials.

import java.util.Scanner;


public class StudentCenterRough {

    public static void main(String[] args) {

        //a - finding total activity cost (Bowling or Billiards)
        System.out.println("Welcome to the Student Center!" + '\n' + "Activities" + '\n' + "Bowling: $4.00 ($2 to rent bowling shoes)" + '\n' + "Billiards: $5.00" + '\n' + "Food" + '\n' + "Pizza: $8.50" + '\n' + "Salad: $7.00" + '\n');
        double activityTotal = 0.00;
        Scanner x = new Scanner(System.in);
        System.out.println('\n');

        System.out.print("What activity would you like to do? ");
        String activity = x.next();


            if (activity.equalsIgnoreCase("Bowling")) {
                activityTotal += 4;
                System.out.print("Do you need bowling shoes?  ");
                String b = x.next();
                if (b.equalsIgnoreCase("Yes")) {
                    activityTotal += 2;
                }
            }
            else
        {
            activityTotal+=5;
        }



        //b - finding the food total
        System.out.print('\n'+  "What food would you like?  ");
        String food = x.next();
        double foodTotal = 0.00;
        if (food.equalsIgnoreCase("Pizza"))
        {
            foodTotal+=8.50;
            System.out.print("Choose a topping (mushrooms: $1.5, pepperoni: $1, none: $0)  ");
            String topping = x.next();

            switch (topping.toUpperCase())
            {
                case "MUSHROOMS":
                {
                    foodTotal+=1.5;
                }
                case "PEPPERONI":
                {
                    foodTotal+=1;
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

        //c - calculating the tip
        System.out.print('\n'+ "What percentage would you like to tip for food?  ");
        double tip = x.nextDouble();

        if (tip < 0 )

        {
            tip = .18;
        }


        //d  calculating people
        System.out.print('\n'+ "How many people are with you?  ");
        int people = x.nextInt();
        if(people<=0){
            people=1;
        }
        else
        {
            people++;
        }

        //final calculations
        double subtotal = (activityTotal + foodTotal) * (people) ;
        double foodTip = (foodTotal) * ((people) * tip);
        double finalPrice = (subtotal + foodTip);

        System.out.println('\n'+ "Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Food Tip: $" + String.format("%.2f", foodTip));
        System.out.println("Total: $" + String.format("%.2f", finalPrice));

        }
}












