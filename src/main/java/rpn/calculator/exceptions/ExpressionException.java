package rpn.calculator.exceptions;

/**
 * 表达式格式错误
 * @author zmzhang
 */
public class ExpressionException extends RPNException {

    private static final long serialVersionUID = 1L;

    /**
     * 构造函数
     * @param message 异常信息
     */
    public ExpressionException(String message) {
        super(message);
    }
}
