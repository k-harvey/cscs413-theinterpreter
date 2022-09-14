package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    String operation = "";

    @Override
    public void init(ArrayList<String> args) {
        operation = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (operation.equals("+")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = op2 + op1;
            vm.push(result);
        } else if (operation.equals("-")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = op2 - op1;
            vm.push(result);
        } else if (operation.equals("*")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = op2 * op1;
            vm.push(result);
        } else if (operation.equals("/")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = op2 / op1;
            vm.push(result);
        } else if (operation.equals("==")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = 0;
            if (op2 == op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals("!=")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = 0;
            if (op2 != op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals("<")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = 0;
            if (op2 < op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals("<=")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = 0;
            if (op2 <= op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals(">")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = 0;
            if (op2 > op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals(">=")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = 0;
            if (op2 >= op1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals("|")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = 0;
            if (op2 == 1 || op1 == 1) {
                result = 1;
            }
            vm.push(result);
        } else if (operation.equals("&")) {
            int op1 = vm.pop();
            int op2 = vm.pop();
            int result = 0;
            if (op2 == 1 && op1 == 1) {
                result = 1;
            }
            vm.push(result);
        }
    }

    @Override
    public void load(String nextToken) {

    }

    public String toString() {
        return "BOP " + operation;
    }
}