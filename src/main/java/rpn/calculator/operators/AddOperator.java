package rpn.calculator.operators;

import java.math.BigDecimal;

import rpn.calculator.exceptions.ExpressionException;

/**
 * 加法实现类
 * 
 * @author zmzhang
 */
public class AddOperator extends AbstractOperator {

    public AddOperator() {
        super("+");
    }

    @Override
    public double doCal(double first, double second) throws ExpressionException {
        BigDecimal b1 = new BigDecimal(first);
        BigDecimal b2 = new BigDecimal(second);
        return b1.add(b2).doubleValue();
    }

}
