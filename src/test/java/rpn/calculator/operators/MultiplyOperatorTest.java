package rpn.calculator.operators;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import rpn.calculator.exceptions.ExpressionException;

public class MultiplyOperatorTest {
    private MultiplyOperator multOp;

    @Before
    public void setup() {
        multOp = new MultiplyOperator();
    }

    @Test
    public void mult() throws ExpressionException {
        assertEquals("*", multOp.operator());
        assertEquals(9, multOp.doCal(3, 3), 0.1);
    }

    @Test
    public void multNeg() throws ExpressionException {
        assertEquals(9, multOp.doCal(-3, -3), 0.1);
    }

    @Test
    public void multOneNeg() throws ExpressionException {
        assertEquals(-9, multOp.doCal(3, -3), 0.1);
    }
    
}
