package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    int argsCode = 0;

    @Override
    public void init(ArrayList<String> args) {
        argsCode = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(argsCode);
    }

    @Override
    public void load(String nextToken) {

    }


    public String toString() {
        return "ARGS " + argsCode;
    }
}