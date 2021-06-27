package rpn.calculator.functions;

import java.math.BigDecimal;

public class SqrtFunction extends AbstractFunction {

    public SqrtFunction() {
        super("sqrt", 1);
    }

    @Override
    public double execute(String... params) {
        return BigDecimal.valueOf(Math.sqrt(Double.valueOf(params[0]))).doubleValue();
    }
    
}
