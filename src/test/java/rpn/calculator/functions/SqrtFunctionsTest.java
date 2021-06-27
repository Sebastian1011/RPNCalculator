package rpn.calculator.functions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import rpn.calculator.exceptions.ExpressionException;

public class SqrtFunctionsTest {
    private SqrtFunction sqrt;

    @Before
    public void setup() {
        sqrt = new SqrtFunction();
    }

    @Test
    public void sqrtTest() throws ExpressionException {
        assertEquals("sqrt", sqrt.name());
        assertEquals(2, sqrt.execute(4.0), 0.1);
    }

    @Test
    public void sqrtNegTest() {
        assertThrows(ExpressionException.class, () -> sqrt.execute(-4.0));
    }
    
}
