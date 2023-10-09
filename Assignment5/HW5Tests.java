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
