package rpn.calculator.operators;

import java.math.BigDecimal;

import rpn.calculator.exceptions.ExpressionException;

/**
 * 减法实现
 * 
 * @author zmzhang
 */
public class SubtractOperator extends AbstractOperator {

    public SubtractOperator() {
        super("-");
    }

    @Override
    public double doCal(double first, double second) throws ExpressionException {
        BigDecimal b1 = new BigDecimal(first);
        BigDecimal b2 = new BigDecimal(second);
        return b1.subtract(b2).doubleValue();
    }

}
