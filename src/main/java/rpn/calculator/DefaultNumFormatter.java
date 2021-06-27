package rpn.calculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 题目描述中默认的格式化程序
 * 
 * @author zmzhang
 */
public class DefaultNumFormatter implements NumFormatter {

    /**
     * 精度至少为15位小数，但是显示10位小数
     */
    @Override
    public String format(double num) {
        DecimalFormat numFormat = new DecimalFormat("##########.##########");
        numFormat.setRoundingMode(RoundingMode.DOWN);// 舍去末尾
        String str = numFormat.format(num);
        return str;
    }

}
