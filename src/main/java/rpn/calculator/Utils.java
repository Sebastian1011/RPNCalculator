package rpn.calculator;

/**
 * 计算工具类
 * 
 * @author zmzhang
 */
public class Utils {

    /**
     * 判断输入字符是否为数字
     * 
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s.trim());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
