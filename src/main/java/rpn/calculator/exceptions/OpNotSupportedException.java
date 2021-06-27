package rpn.calculator.exceptions;

/**
 * OP not support exception
 * @author zmzhang
 */
public class OpNotSupportedException extends RPNException {
    private static final long serialVersionUID = 1L;
    
    /**
     * 构造函数
     * @param message   异常信息
     */
    public OpNotSupportedException(String message) {
        super(message);
    }
}
