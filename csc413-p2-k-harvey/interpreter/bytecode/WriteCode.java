package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {

    @Override
    public void init(ArrayList<String> args) {}

    @Override
    public void execute(VirtualMachine vm) {
        int i = vm.peek();
        System.out.println(i);
    }

    @Override
    public void load(String nextToken) {

    }

    public String toString() {
        return "WRITE ";
    }
}