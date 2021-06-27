package rpn.calculator;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import rpn.calculator.exceptions.ExpressionException;
import rpn.calculator.exceptions.OpNotSupportedException;

public class CalculatorTest {

    private RPNFactory factory;
    private RPNCalculator calculator;

    @Before
    public void setup() {
        factory = new DefaultRPNFactory();
        calculator = factory.getRpnCalculator();
    }

    @Test
    public void calculatorTest() throws ExpressionException, OpNotSupportedException {
        String res = calculator.doRpn(new String[] { "5", "2" });
        assertTrue(stringCompare("5 2", res));
        res = calculator.doRpn(new String[] {"clear", "3", "4", "-"});
        assertTrue(stringCompare("-1", res));
    }

    @Test
    public void sqrtTest() throws ExpressionException, OpNotSupportedException {
        String res = calculator.doRpn(new String[] { "9", "sqrt" });
        assertTrue(stringCompare("3", res));
    }

    @Test
    public void sqrtDTest() throws ExpressionException, OpNotSupportedException {
        String res = calculator.doRpn(new String[] { "2", "sqrt" });
        assertTrue(stringCompare("1.4142135623", res));
    }

    @Test
    public void clearTest() throws ExpressionException, OpNotSupportedException {
        String res = calculator.doRpn(new String[] { "5", "2", "-"});
        assertTrue(stringCompare("3", res));
        res = calculator.doRpn(new String[] { "3", "-"});
        assertTrue(stringCompare("0", res));
        res = calculator.doRpn(new String[] { "clear"});
        assertTrue(stringCompare("", res));
    }
    @Test
    public void undoTest() throws ExpressionException, OpNotSupportedException {
        String res = calculator.doRpn(new String[] { "5", "4", "3", "2"});
        assertTrue(stringCompare("5 4 3 2", res));
        res = calculator.doRpn(new String[] { "undo", "undo", "*"});
        assertTrue(stringCompare("20", res));
        res = calculator.doRpn(new String[] { "5", "*"});
        assertTrue(stringCompare("100", res));
        res = calculator.doRpn(new String[] { "undo"});
        assertTrue(stringCompare("20 5", res));
    }

    @Test
    public void divideTest() throws ExpressionException, OpNotSupportedException {
        String res = calculator.doRpn(new String[] { "7", "12", "2", "/"});
        assertTrue(stringCompare("7 6", res));
        res = calculator.doRpn(new String[] { "*"});
        assertTrue(stringCompare("42", res));
        res = calculator.doRpn(new String[] { "4", "/"});
        assertTrue(stringCompare("10.5", res));
    }

    @Test
    public void errorTest() throws ExpressionException, OpNotSupportedException {
        assertThrows("operator * (position: 15): insufficient parameters", ExpressionException.class, () -> calculator.doRpn(new String[] {"1", "2", "3", "*", "5", "+", "*", "*", "6", "5"}));
        String res  = calculator.printNumStack();
        assertTrue(stringCompare("11", res));
    }

 


    public boolean stringCompare(String str1, String str2) {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int) str1.charAt(i);
            int str2_ch = (int) str2.charAt(i);

            if (str1_ch != str2_ch) {
                return false;
            }
        }
        if (l1 != l2) {
            return false;
        } else {
            return true;
        }
    }
}
