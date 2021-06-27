package rpn.calculator.functions;

import java.math.BigDecimal;

import rpn.calculator.exceptions.ExpressionException;

public class SqrtFunction extends AbstractFunction {

    public SqrtFunction() {
        super("sqrt", 1);
    }

    @Override
    public double execute(Double... params) throws ExpressionException {
        try {
            return BigDecimal.valueOf(Math.sqrt(params[0])).doubleValue();
        } catch (RuntimeException e) {
            throw new ExpressionException(e.getMessage());
        }
    }

}
