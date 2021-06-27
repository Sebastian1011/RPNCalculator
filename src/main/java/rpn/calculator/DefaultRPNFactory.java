package rpn.calculator;

/**
 * default rpn calculate facotry
 * 
 * @author zmzhang
 */
public class DefaultRPNFactory implements RPNFactory {

    @Override
    public RPNCalculator getRpnCalculator() {
        return new RPNCalculator(new DefaultFunctionProvider(), new DefaultOperatorProvider(),
                new DefaultNumFormatter());
    }

}
