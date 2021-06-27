package rpn.calculator.operators;

import rpn.calculator.exceptions.ExpressionException;

/**
 * 抽象操作类
 * 
 * @author zmzhang
 */
public abstract class AbstractOP {
    private final String operator;
    private volatile int hashCode = 0;

    public AbstractOP(final String op) {
        this.operator = op;
    }

    /**
     * 执行操作符计算方法
     * 
     * @param first
     * @param second
     * @return
     * @throws ExpressionException
     */
    public abstract double doCal(double first, double second) throws ExpressionException;

    public String operator() {
        return operator;
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            int result = 17;
            result = 31 * result + operator.hashCode();
            hashCode = result;
        }
        return hashCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AbstractOP that = (AbstractOP) o;
        return operator.equals(that.operator);
    }


}
