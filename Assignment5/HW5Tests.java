import java.io.*;
import java.util.*;
import java.util.regex.*;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

public class HW5Tests {

    private conversion convert;
    float response;
    float input1;
    float input2;
    float expected;
    char selection;


    @Before
    public void setUp() throws Exception{
        convert = new conversion();
        input1 = 50;
        input2 = 100;
    }

    //MPH to KMPH Tests
    @Test
    public void mph_to_kmph_50(){
        selection = 'R';
        expected = (float)80.467;

        testLogic(input1, selection, expected);
    }

    @Test
    public void mph_to_kmph_80(){
        selection = 'R';
        expected = (float)160.934;

        testLogic(input2, selection, expected);
    }
    
    //KMPH to MPH tests
    @Test
    public void kmph_to_mph_50(){
        selection = 'S';
        expected = (float)31.069;

        testLogic(input1, selection, expected);
    }

    @Test
    public void kmph_to_mph_100(){
        selection = 'S';
        expected = (float)62.137;

        testLogic(input2, selection, expected);
    }

    //Kelvin to Celsius tests
    @Test
    public void testK2C(){
        expected = (float)-223.15;
        selection = 'T';

        testLogic(input1, selection, expected);
    }

    @Test
    public void test_different_val_K2C(){
        expected = (float)-173.15;
        selection = 'T';

        testLogic(input2, selection, expected);
    }

    //Celsius to Kelvin tests
    @Test
    public void testC2K(){
        expected = (float) 323.15;
        selection = 'U';

        testLogic(input1, selection, expected);
    }

    @Test
    public void test_different_val_C2K(){
        expected = (float)373.15;
        selection = 'U';

        testLogic(input2, selection, expected);
    }
    
    //Helper methods
    public void testLogic(float input, char selection, float expected){
        //Compute selection and round it
        response = selectAndRound(input, selection, 3);

        //Check if response matches expected
        checkExpected(input, response, expected);
    }

    public float selectAndRound(float input, char selection, int digits){
        response = convert.callConversion(selection, Float.toString(input)); //Do conversion
        response = convert.roundToChoice(response, digits); //Round for comparison

        return response;
    }

    public void checkExpected(float input, float response, float expected){
        assertTrue("Test failed for input " + input,
                response == expected);
    }
}