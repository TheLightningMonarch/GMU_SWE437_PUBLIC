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

    //Main looping logic for the menu/input/conversion cycle
    public static void main(String args[]){
        conversion convert = new conversion();
        char userSelect = ' ';
        Scanner scnr = new Scanner(System.in);
        String inputString = "";

        float convertedValue = 0;

        //We will loop this until the user chooses to exit the program.
        while (Character.toUpperCase(userSelect) != 'Q'){

            //Print the menu
            printMenu();

            //Prompt user for their choice
            inputString = "";
            while (inputString.length() < 1) {
                System.out.print("Your selection: ");
                inputString = scnr.nextLine();
            }
            userSelect = Character.toUpperCase(inputString.charAt(0));

            //Convert the value
            if (userSelect != 'Q') {
                convertedValue = callConversion(userSelect, convert);
            }

            //Print result, if applicable
            if (unit.length() > 0){
                System.out.println("Converted value: " + convertedValue + " " + unit);
            }

            System.out.println();
        }
        scnr.close();
    }

    //Prints the menu on the user's command line
    public static void printMenu(){
        String measurements[]   = {"Fahrenheit", "Celsius", "Inches", "Centimeters", "Feet", "Meters",
                "Miles", "Kilometers", "Gallons", "Liters", "Ounces", "Grams", "Pounds", "Kilograms"};
        String abbreviations[]  = {"F", "C", "in", "cm", "ft", "m", "mi", "km", "gal", "L", "oz", "g", "lb", "kg"};
        char options[]          = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'};

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

    //Uses user input to determine which conversion method to call
    //Then, returns the result of the conversion
    public static float callConversion (char userSelect, conversion convert){
        String toBeConverted = "";
        float convertedValue = 0;

        //Determine what to do
        switch (userSelect){
            case 'A':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertF2C(toBeConverted);
                unit = "C";
                break;
            case 'B':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertC2F(toBeConverted);
                unit = "F";
                break;
            case 'C':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertIn2Cm(toBeConverted);
                unit = "cm";
                break;
            case 'D':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertCm2In(toBeConverted);
                unit = "in";
                break;
            case 'E':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertF2M(toBeConverted);
                unit = "m";
                break;
            case 'F':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertM2F(toBeConverted);
                unit = "ft";
                break;
            case 'G':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertM2K(toBeConverted);
                unit = "km";
                break;
            case 'H':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertK2M(toBeConverted);
                unit = "mi";
                break;
            case 'I':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertG2L(toBeConverted);
                unit = "L";
                break;
            case 'J':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertL2G(toBeConverted);
                unit = "gal";
                break;
            case 'K':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertOz2G(toBeConverted);
                unit = "g";
                break;
            case 'L':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertG2Oz(toBeConverted);
                unit = "oz";
                break;
            case 'M':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertLb2K(toBeConverted);
                unit = "kg";
                break;
            case 'N':
                toBeConverted = getInputMeasurement();
                convertedValue = convert.convertK2Lb(toBeConverted);
                unit = "lb";
                break;
            default:
                System.out.println("Invalid selection. Please enter an option from the menu, or Q to quit.");
                unit = "";
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


    private float convertF2C (String FAsStr)
    {  // Convert farenheit to celsius
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf(FAsStr).floatValue());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) ( ( (num1-32.0) * 5.0) / 9.0);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return (num2);
    }

    private float convertC2F (String CAsStr)
    {  // Convert celsius to farenheit
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (CAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) ( (num1 * 9.0 / 5.0) + 32.0);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // small distance
    private float convertIn2Cm (String inAsStr)
    {  // Convert inches to centimeters
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (inAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 2.54);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    private float convertCm2In (String cmAsStr)
    {  // Convert centimeters to inches
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (cmAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 0.3937);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // medium distance
    private float convertF2M (String ftAsStr)
    {  // Convert feet to meters
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (ftAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 0.3048);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    private float convertM2F (String mAsStr)
    {  // Convert meters to feet
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (mAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 / 0.3048);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // large distance
    private float convertM2K (String miAsStr)
    {  // Convert miles to kilometers
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (miAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 1.609);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    private float convertK2M (String kmAsStr)
    {  // Convert kilometers to miles
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (kmAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 0.6214);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // volume
    private float convertG2L (String galAsStr)
    {  // Convert gallons to liters
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (galAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 3.785);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    private float convertL2G (String LAsStr)
    {  // Convert liters to gallons
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (LAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 / 3.785);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // small weight
    private float convertOz2G (String ozAsStr)
    {  // Convert ounces to grams
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (ozAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 28.35);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    private float convertG2Oz (String gAsStr)
    {  // Convert grams to ounces
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (gAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 / 28.35);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // medium weight
    private float convertLb2K (String lbAsStr)
    {  // Convert pounds to kilograms
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (lbAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 0.4536);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    private float convertK2Lb (String kgAsStr)
    {  // Convert kilograms to pounds
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (kgAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 2.205);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

}