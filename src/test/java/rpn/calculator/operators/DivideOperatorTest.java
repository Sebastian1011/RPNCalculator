package rpn.calculator.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import rpn.calculator.exceptions.ExpressionException;

public class DivideOperatorTest {
    private DivideOperator divOp;

    @Before
    public void setup() {
        divOp = new DivideOperator();
    }

    @Test
    public void div() throws ExpressionException {
        assertEquals("/", divOp.operator());
        assertEquals(2, divOp.doCal(10, 5), 0.1);
    }
    
    @Test
    public void divNeg() throws ExpressionException {
        assertEquals(-2, divOp.doCal(-10, 5), 0.1);
    }

    @Test
    public void divSmall() throws ExpressionException {
        assertEquals(0.5, divOp.doCal(5, 10), 0.1);
    }

    @Test
    public void divZero() {
        assertThrows(ExpressionException.class, () -> divOp.doCal(10, 0));
    }
}
