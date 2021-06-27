package rpn.calculator.operators;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import rpn.calculator.exceptions.ExpressionException;

public class SubtractOperatorTest {
    private SubtractOperator sub;

    @Before
    public void setup() {
        sub = new SubtractOperator();
    }

    @Test
    public void subTest() throws ExpressionException {
        assertEquals("-", sub.operator());
        assertEquals(1, sub.doCal(2, 1), 0.1);
    }
    
}
