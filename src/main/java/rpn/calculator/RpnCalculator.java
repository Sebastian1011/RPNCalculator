package rpn.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rpn.calculator.exceptions.ExpressionException;
import rpn.calculator.exceptions.OpNotSupportedException;
import rpn.calculator.functions.AbstractFunction;

/**
 * RPN 计算实现类
 * 
 * @author zmzhang
 */
public class RPNCalculator {
    private final FunctionProvider functions;
    private final OperatorProvider operators;
    private final NumFormatter formatter;
    // 数据栈
    private Stack<Double> numStack;
    // 操作栈，用于 undo
    private Stack<List<Double>> logStack;

    public RPNCalculator(final FunctionProvider functions, final OperatorProvider operators,
            final NumFormatter formatter) {
        this.functions = functions;
        this.operators = operators;
        this.formatter = formatter;
        this.numStack = new Stack<>();
        this.logStack = new Stack<>();
    }

    /**
     * 输入数字或者操作符进行计算
     * 
     * @param input
     * @return 当前栈结果
     * @throws ExpressionException
     * @throws OpNotSupportedException
     */
    public String doRpn(String[] input) throws ExpressionException, OpNotSupportedException {
        for (int i = 0; i < input.length; i++) {
            String o = input[i];
            if (Utils.isNumber(o)) {
                numStack.push(Double.valueOf(o));
                record();
            } else if (operators.isOperatorAvailable(o)) {
                if (numStack.size() < 2) {
                    throw new ExpressionException(
                            String.format("operator %s (position: %d): insufficient parameters", o, 2 * i + 1));
                }
                Double n2 = numStack.pop();
                Double n1 = numStack.pop();
                numStack.push(operators.getOperator(o).doCal(n1, n2));
                record();
            } else if (functions.isFuncAvailable(o)) {
                AbstractFunction func = functions.getFunction(o);
                if (numStack.size() < func.paramCount()) {
                    throw new ExpressionException(
                            String.format("operator %s (position: %d): insufficient parameters", o, 2 * i + 1));
                }
                Double[] args = new Double[func.paramCount()];
                for (int j = func.paramCount() - 1; j >= 0; j--) {
                    args[j] = numStack.pop();
                }
                numStack.push(func.execute(args));
                record();
            } else if ("undo".equals(o)) {
                undo();
            } else if ("clear".equals(o)) {
                clear();
            } else {
                throw new OpNotSupportedException("不支持的操作: " + o);
            }
        }
        return printNumStack();
    }

    private void record() {
        List<Double> numbers = new ArrayList<>(numStack);
        logStack.push(numbers);
    }

    /**
     * undo 上一步操作
     */
    private void undo() {
        if (logStack.isEmpty()) {
            return;
        }
        logStack.pop();
        numStack.clear();
        if (!logStack.isEmpty()) {
            List<Double> log = logStack.peek();
            for (Double d : log) {
                numStack.push(d);
            }
        }
    }

    /**
     * 清理数据栈
     */
    private void clear() {
        numStack.clear();
        logStack.clear();
    }

    /**
     * print numStack
     * 
     * @return
     */
    public String printNumStack() {
        StringBuilder builder = new StringBuilder("stack: ");
        for (Double d : numStack) {
            builder.append(formatter.format(d));
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
