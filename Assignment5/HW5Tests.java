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
    float input;
    float expected;
    char selection;

    private float value, value2;

    @Before
    public void setUp() throws Exception{
        convert = new conversion();
        value = 50;
        value2 = 100;
    }

    //MPH to KMPH Tests
    @Test
    public void mph_to_kmph_50(){
        input = 50;
        selection = 'R';
        expected = (float)80.467;

        testLogic(input, selection, expected);
    }

    @Test
    public void mph_to_kmph_80(){
        input = 80;
        selection = 'R';
        expected = (float)128.748;

        testLogic(input, selection, expected);
    }

    //Kelvin to Celsius tests
    @Test
    public void testK2C(){
        expected = (float)-223.15;
        input = value;
        selection = 'T';

        testLogic(input, selection, expected);
    }

    @Test
    public void test_different_val_K2C(){
        expected = (float)-173.15;
        input = value2;
        selection = 'T';

        testLogic(input, selection, expected);
    }

    //Celsius to Kelvin tests
    @Test
    public void testC2K(){
        expected = (float) 323.15;
        input = value;
        selection = 'U';

        testLogic(input, selection, expected);
    }

    @Test
    public void test_different_val_C2K(){
        expected = (float)373.15;
        input = value2;
        selection = 'U';

        testLogic(input, selection, expected);
    }

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
