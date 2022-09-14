package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {
    String label = "";
    int finalAddress = 0;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddrs(vm.getPc());
        vm.setPc(finalAddress);
    }

    @Override
    public void load(String nextToken) {

    }


    public String toString() {
        return "CALL " + label;
    }

    public String getLabel() {
        return label;
    }

    public void setFinalAddress(int finalAddress) {
        this.finalAddress = finalAddress;
    }
}