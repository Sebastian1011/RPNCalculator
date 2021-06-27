package rpn.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import rpn.calculator.functions.SqrtFunction;
import rpn.calculator.operators.AddOperator;

public class ProviderTest {

    private FunctionProvider functions;
    private OperatorProvider operators;

    @Before
    public void setup() {
        functions = new DefaultFunctionProvider();
        operators = new DefaultOperatorProvider();
    }

    @Test
    public void test() {
        assertEquals(true, functions.isFuncAvailable("sqrt"));
        assertEquals(false, functions.isFuncAvailable("sin"));
        assertTrue(functions.getFunction("sqrt") instanceof SqrtFunction);
        assertEquals(true, operators.isOperatorAvailable("+"));
        assertEquals(false, operators.isOperatorAvailable("%"));
        assertTrue(operators.getOperator("+") instanceof AddOperator);
    }

}
