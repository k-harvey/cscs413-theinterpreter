package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
    String label = "";
    int finalAddress = 0;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int temp = vm.pop();
        if (temp == 0) {
            vm.setPc(finalAddress);
        }
    }

    @Override
    public void load(String nextToken) {

    }

    public String toString() {
        return "FALSEBRANCH " + label;
    }

    public String getLabel() {
        return label;
    }

    public void setFinalAddress(Integer finalAddress) {
        this.finalAddress = finalAddress;
    }
}