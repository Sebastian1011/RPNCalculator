package rpn.calculator.operators;

import java.math.BigDecimal;

import rpn.calculator.exceptions.ExpressionException;

public class DivideOperator extends AbstractOperator {

    public DivideOperator() {
        super("/");
    }

    @Override
    public double doCal(double first, double second) throws ExpressionException {
        BigDecimal b1 = new BigDecimal(first);
        BigDecimal b2 = new BigDecimal(second);
        try {
            return b1.divide(b2).doubleValue();
        } catch (RuntimeException e) {
            throw new ExpressionException(e.getMessage());
        }
    }

}
