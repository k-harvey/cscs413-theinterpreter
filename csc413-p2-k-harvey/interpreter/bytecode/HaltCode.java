package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {

    @Override
    public void init(ArrayList<String> args) {}

    @Override
    public void execute(VirtualMachine vm) {
        vm.setRunning(false);
    }

    @Override
    public void load(String nextToken) {

    }

    public String toString() {
        return "HALT ";
    }
}
