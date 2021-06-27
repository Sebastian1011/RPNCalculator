package rpn.calculator;

import rpn.calculator.functions.AbstractFunction;

public interface FunctionProvider {
    
    /**
     * 通过操作符获取 func 类
     * @param name
     * @return {@link AbstractFunction}
     */
    AbstractFunction getFunction(String name);

    /**
     * check func name 是否合法
     * @param name
     * @return
     */
    boolean isFuncAvailable(String name);

}
