package rpn.calculator.operators;

import java.math.BigDecimal;

import rpn.calculator.exceptions.ExpressionException;

public class MultiplyOperator extends AbstractOperator {

    public MultiplyOperator() {
        super("*");
    }

    @Override
    public double doCal(double first, double second) throws ExpressionException {
        BigDecimal b1 = new BigDecimal(first);
        BigDecimal b2 = new BigDecimal(second);
        return b1.multiply(b2).doubleValue();
    }

}
