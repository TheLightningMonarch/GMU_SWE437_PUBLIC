import java.io.;
import java.util.;
import java.util.regex.;
import org.junit.;
import static org.junit.Assert.*;

public class ConvTest{

    // Define Test Domain
    private static final int NEGATIVE_INPUT = -10;
    private static final int ZERO_INPUT = 0;
    private static final float LARGE_INPUT = 10027.12345;
    private conversion convert;

    @Before
    public void setUp(){
        convert = new conversion();
    }

    @Test public void testRoundToChoice_0(){
        assertTrue(“testroundToChoice incorrect”, 1 == convert.roundToChoice(1.23456, 0));
    }

    @Test public void testRoundToChoice_1(){
        assertTrue(“testroundToChoice incorrect”, 1.2 == convert.roundToChoice(1.23456, 1));
    }

    @Test public void testRoundToChoice_2(){
        assertTrue(“testroundToChoice incorrect”, 1.23 == convert.roundToChoice(1.23456, 2));
    }

    @Test public void testRoundToChoice_3(){
        assertTrue(“testroundToChoice incorrect”, 1.234 == convert.roundToChoice(1.23456, 3));
    }

    @Test public void testRoundToChoice_4(){
        assertTrue(“testroundToChoice incorrect”, 1.2345 == convert.roundToChoice(1.23456, 4));
    }

    // Test F2C
    @Test public void testConvertF2C_Negative(){
        assertTrue(“testroundToChoice incorrect”, -23.333 == round(convert.convertF2C(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertF2C_ZERO(){
        assertTrue(“testroundToChoice incorrect”, -17.778 == round(convert.convertF2C(ZERO_INPUT), 3));
    }
    @Test public void testConvertF2C_Negative(){
        assertTrue(“testroundToChoice incorrect”, 5552.846 == round(convert.convertF2C(LARGE_INPUT), 3));
    }

    // Test C2F
    @Test public void testConvertC2F_Negative(){
        assertTrue(“testroundToChoice incorrect”, 14.000 == round(convert.convertC2F(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertC2F_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 32.000 == round(convert.convertC2F(ZERO_INPUT), 3));
    }
    @Test public void testConvertC2F_Negative(){
        assertTrue(“testroundToChoice incorrect”, 18080.822 == round(convert.convertC2F(LARGE_INPUT), 3));
    }

    // Test Cm2In
    @Test public void testConvertCm2In_Negative(){
        assertTrue(“testroundToChoice incorrect”, -3.937 == round(convert.convertCm2In(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertCm2In_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertCm2In(ZERO_INPUT), 3));
    }
    @Test public void testConvertCm2In_Negative(){
        assertTrue(“testroundToChoice incorrect”, 3947.686 == round(convert.convertCm2In(LARGE_INPUT), 3));
    }

    // Test In2Cm
    @Test public void testConvertIn2Cm_Negative(){
        assertTrue(“testroundToChoice incorrect”, -25.400 == round(convert.convertIn2Cm(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertIn2Cm_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertIn2Cm(ZERO_INPUT), 3));
    }
    @Test public void testConvertIn2Cm_Negative(){
        assertTrue(“testroundToChoice incorrect”, 25468.894 == round(convert.convertIn2Cm(LARGE_INPUT), 3));
    }

    // Test F2M, Input Domain
    @Test public void testConvertF2M_Negative(){
        assertTrue(“testroundToChoice incorrect”, -3.048 == round(convert.convertF2M(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertF2M_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertF2M(ZERO_INPUT), 3));
    }
    @Test public void testConvertF2M_Negative(){
        assertTrue(“testroundToChoice incorrect”, 3056.267 == round(convert.convertF2M(LARGE_INPUT), 3));
    }

    // Test M2F, Input Domain
    @Test public void testConvertM2F_Negative(){
        assertTrue(“testroundToChoice incorrect”, -32.808 == round(convert.convertM2F(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertM2F_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertM2F(ZERO_INPUT), 3));
    }
    @Test public void testConvertM2F_Negative(){
        assertTrue(“testroundToChoice incorrect”, 32897.387 == round(convert.convertM2F(LARGE_INPUT), 3));
    }

    // Test M2K (Miles to KM), should be Mi2Km
    @Test public void testConvertM2K_Negative(){
        assertTrue(“testroundToChoice incorrect”, -16.093 == round(convert.convertM2K(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertM2K_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertM2K(ZERO_INPUT), 3));
    }
    @Test public void testConvertM2K_Negative(){
        assertTrue(“testroundToChoice incorrect”, 16137.091 == round(convert.convertM2K(LARGE_INPUT), 3));
    }

    // Test K2M (Km to Miles), should be Km2Mi
    @Test public void testConvertK2M_Negative(){
        assertTrue(“testroundToChoice incorrect”, -6.214 == round(convert.convertK2M(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertK2M_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertK2M(ZERO_INPUT), 3));
    }
    @Test public void testConvertK2M_Negative(){
        assertTrue(“testroundToChoice incorrect”, 6230.566 == round(convert.convertK2M(LARGE_INPUT), 3));
    }

    // Test G2L
    @Test public void testConvertG2L_Negative(){
        assertTrue(“testroundToChoice incorrect”, -37.854 == round(convert.convertG2L(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertG2L_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertG2L(ZERO_INPUT), 3));
    }
    @Test public void testConvertG2L_Negative(){
        assertTrue(“testroundToChoice incorrect”, 37956.791 == round(convert.convertG2L(LARGE_INPUT), 3));
    }

    // Test L2G
    @Test public void testConvertL2G_Negative(){
        assertTrue(“testroundToChoice incorrect”, -2.642 == round(convert.convertL2G(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertL2G_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertL2G(ZERO_INPUT), 3));
    }
    @Test public void testConvertL2G_Negative(){
        assertTrue(“testroundToChoice incorrect”, 2648.886 == round(convert.convertL2G(LARGE_INPUT), 3));
    }

    // Test Oz2G
    @Test public void testConvertOz2G_Negative(){
        assertTrue(“testroundToChoice incorrect”, -0.078 == round(convert.convertOz2G(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertOz2G_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertOz2G(ZERO_INPUT), 3));
    }
    @Test public void testConvertOz2G_Negative(){
        assertTrue(“testroundToChoice incorrect”, 78.337 == round(convert.convertOz2G(LARGE_INPUT), 3));
    }

    // Test G2Oz
    @Test public void testConvertG2Oz_Negative(){
        assertTrue(“testroundToChoice incorrect”, -1280 == round(convert.convertG2Oz(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertG2Oz_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertG2Oz(ZERO_INPUT), 3));
    }
    @Test public void testConvertG2Oz_Negative(){
        assertTrue(“testroundToChoice incorrect”, 1283471.802 == round(convert.convertG2Oz(LARGE_INPUT), 3));
    }

    // Test Lb2K
    @Test public void testConvertLb2K_Negative(){
        assertTrue(“testroundToChoice incorrect”, -4.536 == round(convert.convertLb2K(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertLb2K_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertLb2K(ZERO_INPUT), 3));
    }
    @Test public void testConvertLb2K_Negative(){
        assertTrue(“testroundToChoice incorrect”, 4548.227 == round(convert.convertLb2K(LARGE_INPUT), 3));
    }

    // Test K2Lb
    @Test public void testConvertK2Lb_Negative(){
        assertTrue(“testroundToChoice incorrect”, -22.046 == round(convert.convertK2Lb(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertK2Lb_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertK2Lb(ZERO_INPUT), 3));
    }
    @Test public void testConvertK2Lb_Negative(){
        assertTrue(“testroundToChoice incorrect”, 22106.023 == round(convert.convertK2Lb(LARGE_INPUT), 3));
    }

    // Test Hr2S
    @Test public void testConvertHr2S_Negative(){
        assertTrue(“testroundToChoice incorrect”, -36000.000 == round(convert.convertHr2S(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertHr2S_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertHr2S(ZERO_INPUT), 3));
    }
    @Test public void testConvertHr2S_Negative(){
        assertTrue(“testroundToChoice incorrect”, 360097644.420 == round(convert.convertHr2S(LARGE_INPUT), 3));
    }

    // Test S2Hr
    @Test public void testConvertS2Hr_Negative(){
        assertTrue(“testroundToChoice incorrect”, -0.003 == round(convert.convertS2Hr(NEGATIVE_INPUT), 3));
    }
    @Test public void testConvertS2Hr_ZERO(){
        assertTrue(“testroundToChoice incorrect”, 0.000 == round(convert.convertS2Hr(ZERO_INPUT), 3));
    }
    @Test public void testConvertS2Hr_Negative(){
        assertTrue(“testroundToChoice incorrect”, 27.785 == round(convert.convertS2Hr(LARGE_INPUT), 3));
    }

    @After
    public void tearDown(){
        convert = null;
    }

 //run the unit tests
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("JUnitForInputOutput");
    }
}