package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    int i;
    String codeID = "";

    public void init(ArrayList<String> args) {
        if (args.size() == 1) {
            i = Integer.parseInt(args.get(0));
        } else {
            codeID = args.get(args.size() - 1);
            i = Integer.parseInt(args.get(0));
        }
    }

    public void execute(VirtualMachine vm) {
        vm.store(i);
    }

    @Override
    public void load(String nextToken) {

    }

    public String toString() {
        return "STORE " + i + " " + codeID;
    }

}
