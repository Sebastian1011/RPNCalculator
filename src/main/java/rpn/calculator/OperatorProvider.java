package rpn.calculator;

import rpn.calculator.operators.AbstractOperator;

/**
 * operator provider
 * @author zmzhang
 */
public interface OperatorProvider {

    /**
     * 通过操作符获取 op 类
     * @param operator
     * @return {@link AbstractOperator}
     */
    AbstractOperator getOperator(String operator);

    /**
     * check 操作符是否合法
     * @param operator
     * @return
     */
    boolean isOperatorAvailable(String operator);
    
}
