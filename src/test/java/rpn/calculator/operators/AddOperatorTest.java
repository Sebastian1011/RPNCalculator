package rpn.calculator.operators;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import rpn.calculator.exceptions.ExpressionException;

public class AddOperatorTest {

    private AddOperator addOp;

    @Before
    public void setup() {
        addOp = new AddOperator();
    }

    @Test
    public void addTest() throws ExpressionException {
        assertEquals("+", addOp.operator());
        assertEquals(2.0, addOp.doCal(1, 1), 0.1);
    }
    
}
