package rpn.calculator;

/**
 * default rpn calculate facotry
 * 抽象工厂，题目要求默认实现，实际可根据传参数选择工厂类型创建对应的 calculator
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
