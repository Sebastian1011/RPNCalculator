package rpn.calculator;

import java.util.HashMap;
import java.util.Map;

import rpn.calculator.functions.AbstractFunction;
import rpn.calculator.functions.SqrtFunction;

public class DefaultFunctionProvider implements FunctionProvider {
    private Map<String, AbstractFunction> functions;

    public DefaultFunctionProvider() {
        functions = new HashMap<>();
        init();
    }
    private void init() {
        SqrtFunction sqrt = new SqrtFunction();
        functions.put(sqrt.name(), sqrt);
    }

    @Override
    public AbstractFunction getOperator(String name) {
        return functions.get(name);
    }

    @Override
    public boolean isFuncAvailable(String name) {
        return functions.containsKey(name);
    }
    
}
