package week;

import java.util.Scanner;

public class BMICalculator{ 
    public static void main(String[] args){
        // Create an instance of the Start class, which handles the flow of the program.
        Start start = new Start(); // creates instance of class Start
        start.run(); // calls the run() method to begin program execution
    }
}

class BMICalculation { 
    double kg; // stores weight in kilograms
    double m;  // stores height in meters

    void metric(){
        double bmi = kg/(m*m);
        System.out.println("your bmi is: " + bmi);
    }
    // TIP: This method could later be extended to display additional BMI-related facts.

    class HeightConverter { 
        // This inner class handles converting different height units to meters.
        void corona(double user_Input){
            m = user_Input * 0.0231;
        }
        void feet(double user_Input){
            m = user_Input * 0.3048;
        }
    }
    
    class WeightConverter {
        // This inner class handles converting different weight units to kilograms..
        void elephant(double user_Input){
            // Converts "elephant" units to kilograms.
            kg = user_Input * 6300; 
            System.out.println("so you weigh about: " + kg + " kg");
        }
        void pounds(double user_Input){
            // Converts pounds to kilograms.
            kg = user_Input/2.2; 
            System.out.println("so you weigh about: " + kg + " kg");
        }
    }
}

class Start {
    double M_user; // stores the user's input for weight
    double H_user; // stores the user's input for height

    void run(){
        Scanner input = new Scanner(System.in);  
        BMICalculation BMICalculation = new BMICalculation();     
        System.out.println("please type corresponding number for your desired unit of mass:   1:elephants 2:pounds");
        int MassU = input.nextInt();
        // Tip: Instead of using recursion for invalid input (which may lead to a stack overflow on repeated errors), consider using a loop.

        // Use if-statements to decide which weight conversion method to call.
        if(MassU == 2 || MassU == 1){
            BMICalculation.WeightConverter weightConverter = BMICalculation.new WeightConverter();
            if(MassU == 1){
                System.out.println("how many elephants do you weigh: ");
                M_user = input.nextDouble(); 
                weightConverter.elephant(M_user);
            }
            else if(MassU == 2){
                System.out.println("How many pounds do you weigh: ");
                M_user = input.nextDouble(); 
                weightConverter.pounds(M_user); 
            }
        }
        else if (MassU > 2 || MassU < 1){
            System.out.println("Invalid input");
            run(); // Tip: Instead of recursively calling run(), consider a loop to re-prompt for input.
            return;
        }

        System.out.println("Please type corresponding number for your desired height unit:  1:corona bottle 2:feet");
        int heightU = input.nextInt();
        if(heightU == 1 || heightU == 2){
            BMICalculation.HeightConverter HeightConverter = BMICalculation.new HeightConverter();
            if(heightU == 1){
                System.out.println("How many corona bottles tall are you");
                H_user = input.nextDouble();
                HeightConverter.corona(H_user);
            }
            if(heightU == 2){
                System.out.println("How many feet tall are you (no inches, just feet in one number please)");
                H_user = input.nextDouble();
                HeightConverter.feet(H_user);
            }
        }
        else if(heightU < 1 || heightU > 2){
            System.out.println("invalid input");
            run(); // Tip: Again, consider using a loop for robust input handling rather than recursion.
            return;
        }
        // Finally, call the metric() method to calculate and display the BMI.
        BMICalculation.metric();
    }
}
//add gui

//bmi into array list to "store history"
// say that array list is better as i can jsut append my new bmi each time instead of creating an array full of bmi variables

//remove Recursion loop - go back to failed step instead of going back to starts also account for incorrect string inputs
//for final bmi calc stuck for loop to then restart the program and set the next bmi into the next part of the arraylist using i as the arraylist value

// Use while loop (true) -> Ask / prompt the user -> save the input into a variable ->  if (MassU > 2 || MassU < 1) break; -> else prompt the user again 
// DO NOT overcomplicate 