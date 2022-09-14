package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void init(ArrayList<String> args) {}

    @Override
    public void execute(VirtualMachine vm) {
        System.out.print("Please enter a number: ");
        int userInput = scanner.nextInt();
        vm.push(userInput);
    }

    @Override
    public void load(String nextToken) {

    }

    public String toString() {
        return "READ ";
    }
}
