package rpn.calculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;

/**
 * 题目描述中默认的格式化程序
 * 
 * @author zmzhang
 */
public class DefaultNumFormatter implements StackFormatter {

    /**
     * 精度至少为15位小数，但是显示10位小数
     */
    @Override
    public String format(Stack<Double> stack) {
        StringBuilder builder = new StringBuilder("stack: ");
        DecimalFormat numFormat = new DecimalFormat("##########.##########");
        numFormat.setRoundingMode(RoundingMode.DOWN);// 舍去末尾
        for (Double d : stack) {
            builder.append(numFormat.format(d));
            builder.append(" ");
        }
        return builder.toString().trim();
    }

}
