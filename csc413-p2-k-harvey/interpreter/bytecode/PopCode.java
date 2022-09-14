package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    int popCode = 0;

    @Override
    public void init(ArrayList<String> args) {
        popCode = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 0; i > popCode; i++) {
            vm.pop();
        }
    }

    @Override
    public void load(String nextToken) {

    }

    public String toString() {
        return "POP " + popCode;
    }
}