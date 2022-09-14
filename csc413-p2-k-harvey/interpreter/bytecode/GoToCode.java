package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GoToCode extends ByteCode {
    String label = "";
    int finalAddress = 0;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setPc(finalAddress);
    }

    @Override
    public void load(String nextToken) {

    }

    public String toString() {
        return "GOTO " + label;
    }

    public String getLabel() {
        return label;
    }

    public void setFinalAddress(Integer finalAddress) {
        this.finalAddress = finalAddress;
    }
}

