package rpn.calculator.operators;

import java.math.BigDecimal;
import java.math.RoundingMode;

import rpn.calculator.exceptions.ExpressionException;

/**
 * 除法实现
 * 
 * @author zmzhang
 */
public class DivideOperator extends AbstractOperator {

    private int scale;

    public DivideOperator() {
        // 默认值
        this(15);
    }

    public DivideOperator(int scale) {
        super("/");
        this.scale = scale;
    }

    @Override
    public double doCal(double first, double second) throws ExpressionException {
        BigDecimal b1 = new BigDecimal(first);
        BigDecimal b2 = new BigDecimal(second);
        try {
            return b1.divide(b2, scale, RoundingMode.HALF_UP).doubleValue();
        } catch (RuntimeException e) {
            throw new ExpressionException(e.getMessage());
        }
    }

}
