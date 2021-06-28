package rpn.cmd;

import java.util.Arrays;
import java.util.Scanner;

import rpn.CalApp;
import rpn.calculator.DefaultRPNFactory;
import rpn.calculator.RPNCalculator;
import rpn.calculator.RPNFactory;
import rpn.calculator.exceptions.RPNException;

/**
 * RPN 计算器命令行程序实现类
 * 
 * @author zmzhang
 */
public class Cmd implements CalApp {

    @Override
    public void start() {
        RPNFactory factory = new DefaultRPNFactory();
        RPNCalculator calculator = factory.getRpnCalculator();
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] params = parse(input.nextLine());
            try {
                System.out.println(calculator.doRpn(params));
            } catch (RPNException e) {
                System.out.println(e.getMessage());
                System.out.println(calculator.printNumStack());
            }
        }
        input.close();
    }

    private String[] parse(String in) {
        return Arrays.stream(in.trim().split(" ")).map(s -> s.trim()).filter(x -> x.length() > 0).toArray(String[]::new);
    }

}
