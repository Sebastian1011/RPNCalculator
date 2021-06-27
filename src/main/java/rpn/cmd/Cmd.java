package rpn.cmd;

import java.util.Arrays;
import java.util.Scanner;

import rpn.CalApp;
import rpn.calculator.DefaultRPNFactory;
import rpn.calculator.RPNCalculator;
import rpn.calculator.RPNFactory;
import rpn.calculator.exceptions.RPNException;

/**
 * CMD app implement
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
                calculator.doRpn(params);
            } catch (RPNException e) {
                System.out.println(e.getMessage());
            }
        }
        input.close();
    }

    private String[] parse(String in) {
        return Arrays.stream(in.trim().split(" ")).map(s -> s.trim()).filter(x -> x.length() > 0).toArray(String[]::new);
    }

}
