package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    String label = "";

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {}

    @Override
    public void load(String nextToken) {

    }

    public String toString() {
        return "LABEL " + label;
    }

    public String getLabel() {
        return label;
    }
}