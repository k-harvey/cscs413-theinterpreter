package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    int litCode = 0;
    String codeName = "";

    @Override
    public void init(ArrayList<String> args) {
        litCode = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            codeName = args.get(args.size() - 1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.push(litCode);
    }

    @Override
    public void load(String nextToken) {

    }

    public String toString() {
        return "LIT " + litCode + " " + codeName;
    }
}