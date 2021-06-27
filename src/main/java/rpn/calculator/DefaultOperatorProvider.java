package rpn.calculator;

import java.util.HashMap;
import java.util.Map;

import rpn.calculator.operators.AbstractOperator;
import rpn.calculator.operators.AddOperator;
import rpn.calculator.operators.DivideOperator;
import rpn.calculator.operators.MultiplyOperator;
import rpn.calculator.operators.SubtractOperator;

/**
 * default pop provider implement
 * 
 * @author zmzhang
 */
public class DefaultOperatorProvider implements OperatorProvider {
    private Map<String, AbstractOperator> operators;
    
    public DefaultOperatorProvider() {
        operators = new HashMap<>();
        init();
    }

    private void init() {
        AddOperator add = new AddOperator();
        operators.put(add.operator(), add);
        SubtractOperator sub = new SubtractOperator();
        operators.put(sub.operator(), sub);
        MultiplyOperator mul = new MultiplyOperator();
        operators.put(mul.operator(), mul);
        DivideOperator div = new DivideOperator();
        operators.put(div.operator(), div);
    }
    

    @Override
    public AbstractOperator getOperator(String operator) {
        return operators.get(operator);
    }

    @Override
    public boolean isOperatorAvailable(String operator) {
        return operators.containsKey(operator);
    }

}
