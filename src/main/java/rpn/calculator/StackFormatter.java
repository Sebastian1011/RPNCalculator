package rpn.calculator;

import java.util.Stack;

/**
 * 数字展示的格式化接口，可以自定义格式化方法
 * 
 * @author zmzhang
 */
public interface StackFormatter {

    public String format(Stack<Double> stack);

}
