package rpn.calculator.functions;

import rpn.calculator.exceptions.ExpressionException;

public abstract class AbstractFunction {
    private final String name;
    private final int paramCount;
    private volatile int hashCode = 0;
    
    /**
     * 构造函数.
     *
     * @param name       函数名
     * @param paramCount 参数数量
     */
    public AbstractFunction(String name, int paramCount) {
        this.name = name;
        this.paramCount = paramCount;
    }

    public String name() {
        return name;
    }

    public int paramCount() {
        return paramCount;
    }

    public abstract double execute(Double... params) throws ExpressionException;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractFunction) {
            AbstractFunction rpn = (AbstractFunction) obj;
            return (name != null ? name.equals(rpn.name) : false) && paramCount == rpn.paramCount;
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            int result = 17;
            result = 31 * result + name.hashCode();
            result = 31 * result + paramCount;
            hashCode = result;
        }
        return hashCode;
    }

}
