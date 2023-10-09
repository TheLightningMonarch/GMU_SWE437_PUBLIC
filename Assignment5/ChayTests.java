// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ChayTests{
    private conversion convert;

    @Test
    public void mph_to_kmph_50(){
       float response;
       float input = 50;
       response = convert.callConversion('S', Float.toString(input)); //Do conversion
       response = convert.roundToChoice(response, 3); //Round for comparison

       //Check if response matches expected
       assertTrue("Miles to Km failed for " + input, response == (float)80.467);
    }

    public static void main(String[] args){
      org.junit.runner.JUnitCore.main("ChayTests");
    }


}