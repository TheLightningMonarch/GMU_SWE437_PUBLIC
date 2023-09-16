/** *****************************************************************
 conversion.java
 Converts various measures from one unit to another

 @author Jeff Offutt & Ren Li, Einin Blevins & Erica Therkorn & Christopher Chay

 @version 1.0    October 2000
 @version 2.0    June 2015
 @version 2.1    January 2020
 @version 3.0    September 2023
  ********************************************************************* */

// Import Java Libraries
import java.util.*;
import java.lang.*;

// conversion class
//
// CONSTRUCTOR: no constructor specified (default)
//
// ****************  PUBLIC OPERATIONS  **********************************
// void  main()                 --> Main looping logic for the menu
// void  printMenu()            --> Displays the menu to the user via command line
// float callconversion()       --> Uses user selection to call corresponding backend conversion function
// String getInputMeasurement() --> Retrieves user input for measurement to be converted via command line
// float convertX2Y()           --> One for each conversion pair
//*************************************************************************
//
// The possible IOException on the PrintWriter is thrown up.

public class conversion
{

    //Global to help print the conversion output with the correct unit
    private static String unit;

    private static char options[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'};

    //Main looping logic for the menu/input/conversion cycle
    public static void main(String args[]){
        conversion convert = new conversion();
        char userSelect = ' ';
        Scanner scnr = new Scanner(System.in);
        String inputString = "";
        boolean inputIsValid = true;
        int numDigits = -1;
        String outputFormat = "";

        float convertedValue = 0;

        //We will loop this until the user chooses to exit the program.
        while (Character.toUpperCase(userSelect) != 'Q'){

            //Print the menu
            printMenu();

            //Prompt user for their choice
            inputString = "";
            outputFormat = "Converted value: %.";
            
            while (inputString.length() < 1) {
                System.out.print("Your selection: ");
                inputString = scnr.nextLine();
            }
            userSelect = Character.toUpperCase(inputString.charAt(0));

            //Check if valid input
            inputIsValid = checkCase(userSelect);

            if (!inputIsValid){
                System.out.println("Invalid selection. Please enter an option from the menu, or Q to quit.");
                unit = "";
                continue;
            }
            
            if (userSelect == 'Q'){
                break;
            }

            //Convert the value
            convertedValue = callConversion(userSelect, convert);
            
            //Get number of digits to round to
            System.out.print("Enter number of digits to round to (0 - 4): ");
            while (numDigits < 0 || numDigits > 4){
                numDigits = scnr.nextInt();
                
                if (numDigits < 0 || numDigits > 4){
                    System.out.println("Invalid selection. Please try again.");
                }
            }
            
            outputFormat = outputFormat.concat(Integer.toString(numDigits));
            outputFormat = outputFormat.concat("f %s\n");
            

            //Round the value to user's choice of digits past the decimal point (0-4)
            convertedValue = roundToChoice(convertedValue, numDigits);

            //Print result, if applicable
            if (unit.length() > 0){
                System.out.printf(outputFormat, convertedValue, unit);
            }

            //Reset values to blank
            convertedValue = 0;
            unit = "";
            numDigits = -1;

            System.out.println();
        }
        scnr.close();
    }

    //Prints the menu on the user's command line
    public static void printMenu(){
        String measurements[]   = {"Fahrenheit", "Celsius", "Inches", "Centimeters", "Feet", "Meters",
                "Miles", "Kilometers", "Gallons", "Liters", "Ounces", "Grams", "Pounds", "Kilograms", "Hours", "Seconds"};
        String abbreviations[]  = {"F", "C", "in", "cm", "ft", "m", "mi", "km", "gal", "L", "oz", "g", "lb", "kg", "hr", "s"};

        //Display the menu for the user
        System.out.println("Enter the associated character(s) with each option to select a conversion.");
        System.out.println("(Enter Q to quit the program.)\n------------------------------------------");
        for (int i = 0; i < measurements.length; i++){

            //Display conversion pairings
            if (i % 2 == 0) {
                System.out.print(options[i] + ": " + measurements[i] + " (" + abbreviations[i] + ") to " + measurements[i+1] + " ("
                        + abbreviations[i+1] + ")");
            }

            else{
                System.out.print(options[i] + ": " + measurements[i] + " (" + abbreviations[i] + ") to " + measurements[i-1] + " ("
                        + abbreviations[i-1] + ")");
            }
            System.out.println();
        }
    }

    //Checks to make sure a user selection is a valid selection based on the menu options
    //Returns true if valid, false if invalid
    public static boolean checkCase (char input){
        for (int i = 0; i < options.length; i++){
            if (options[i] == input){
                return true;
            }
        }

        if (input == 'Q'){
            return true;
        }
        return false;
    }
    
    //Uses user input to determine which conversion method to call
    //Then, returns the result of the conversion
    public static float callConversion (char userSelect, conversion convert){
        String inputAsStr = "";
        float toBeConverted;
        float convertedValue = 0;

        inputAsStr = getInputMeasurement();
        
        //Convert value to be converted to a float value
        toBeConverted = (Float.valueOf(inputAsStr).floatValue());
    
        //Determine what to do
        switch (userSelect){
            case 'A':
                convertedValue = convert.convertF2C(toBeConverted);
                unit = "C";
                break;
            case 'B':
                convertedValue = convert.convertC2F(toBeConverted);
                unit = "F";
                break;
            case 'C':
                convertedValue = convert.convertIn2Cm(toBeConverted);
                unit = "cm";
                break;
            case 'D':
                convertedValue = convert.convertCm2In(toBeConverted);
                unit = "in";
                break;
            case 'E':
                convertedValue = convert.convertF2M(toBeConverted);
                unit = "m";
                break;
            case 'F':
                convertedValue = convert.convertM2F(toBeConverted);
                unit = "ft";
                break;
            case 'G':
                convertedValue = convert.convertM2K(toBeConverted);
                unit = "km";
                break;
            case 'H':
                convertedValue = convert.convertK2M(toBeConverted);
                unit = "mi";
                break;
            case 'I':
                convertedValue = convert.convertG2L(toBeConverted);
                unit = "L";
                break;
            case 'J':
                convertedValue = convert.convertL2G(toBeConverted);
                unit = "gal";
                break;
            case 'K':
                convertedValue = convert.convertOz2G(toBeConverted);
                unit = "g";
                break;
            case 'L':
                convertedValue = convert.convertG2Oz(toBeConverted);
                unit = "oz";
                break;
            case 'M':
                convertedValue = convert.convertLb2K(toBeConverted);
                unit = "kg";
                break;
            case 'N':
                convertedValue = convert.convertK2Lb(toBeConverted);
                unit = "lb";
                break;
                            
            //New Cases added in HW3
            case 'O':
                convertedValue = convert.convertHr2S(toBeConverted);
                unit = "s";
                break;
            case 'P':
                convertedValue = convert.convertS2Hr(toBeConverted);
                unit = "hr";
                break;
            
            default:
                System.out.println("Should not be reached.");
                convertedValue = -1;
        }
        return convertedValue;
    }

    //Gets the value to be converted from user keyboard input
    public static String getInputMeasurement (){
        float userInput = 0;
        String finalValue = "";
        Scanner measurementScnr = new Scanner(System.in);

        //Get valid float input from user
        System.out.print("Enter the value to be converted: ");
        userInput = measurementScnr.nextFloat();
        System.out.println();

        //Convert it to string because the conversion methods take String input
        finalValue = Float.toString(userInput);
        //measurementScnr.close();

        return finalValue;
    }

    // Rounds the output to numDigits number of digits past the decimal point (0-4)
    public static float roundToChoice(float toBeRounded, int numDigits){

        float multiplier, n;
        float ret;

        multiplier = (float)Math.pow(10, numDigits);
        
        n    = Math.round(toBeRounded * (float)multiplier);
        ret = (float) (n / (float)multiplier);
        return ret;
    }


    private float convertF2C (float num1)
    {  // Convert farenheit to celsius
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) ( ( (num1-32.0) * 5.0) / 9.0);
        
        return (num2);
    }

    private float convertC2F (float num1)
    {  // Convert celsius to farenheit
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) ( (num1 * 9.0 / 5.0) + 32.0);
        
        return(num2);
    }

    // small distance
    private float convertIn2Cm (float num1)
    {  // Convert inches to centimeters
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 * 2.54);
        
        return(num2);
    }

    private float convertCm2In (float num1)
    {  // Convert centimeters to inches
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 * 0.3937);
        
        return(num2);
    }

    // medium distance
    private float convertF2M (float num1)
    {  // Convert feet to meters
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 * 0.3048);
        
        return(num2);
    }

    private float convertM2F (float num1)
    {  // Convert meters to feet
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 / 0.3048);
        
        return(num2);
    }

    // large distance
    private float convertM2K (float num1)
    {  // Convert miles to kilometers
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 * 1.609);
        
        return(num2);
    }

    private float convertK2M (float num1)
    {  // Convert kilometers to miles
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 * 0.6214);
        
        return(num2);
    }

    // volume
    private float convertG2L (float num1)
    {  // Convert gallons to liters
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 * 3.785);
        
        return(num2);
    }

    private float convertL2G (float num1)
    {  // Convert liters to gallons
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 / 3.785);
        
        return(num2);
    }

    // small weight
    private float convertOz2G (float num1)
    {  // Convert ounces to grams
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 * 28.35);
        
        return(num2);
    }

    private float convertG2Oz (float num1)
    {  // Convert grams to ounces
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 / 28.35);
        
        return(num2);
    }

    // medium weight
    private float convertLb2K (float num1)
    {  // Convert pounds to kilograms
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 * 0.4536);
        
        return(num2);
    }

    private float convertK2Lb (float num1)
    {  // Convert kilograms to pounds
        float num2; // temporary variables
        int n; // temporary variable
        
        // Convert
        num2 = (float) (num1 * 2.205);
    
        return(num2);
    }
    
    private float convertHr2S (float num1)
    {  //Convert hours to seconds
       float num2; //temporary variable
       int n;
       
       //Convert
       num2 = (float) (num1 * (float)60 * (float)60);
       
       return(num2);
    
    }
    
    private float convertS2Hr (float num1)
    { //Convert seconds to hours
       float num2; //temporary variable
       int n;
       
       //Convert
       num2 = (float) (num1 / (float)60 / (float)60);
       
       return(num2);
    }
    
}