package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    String label = "";

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (label.equals("ON")) {
            vm.dumpOn();
        } else {
            vm.dumpOff();
        }
    }

    @Override
    public void load(String nextToken) {

    }

    public String toString() {
        return "DUMP " + label;
    }
}
