package rpn.calculator.exceptions;

/**
 * RPN 异常基类
 * @author zmzhang
 */
public class RPNException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * 构造函数
     * @param message   异常信息
     */
    public RPNException(String message) {
        super(message);
    }
}
