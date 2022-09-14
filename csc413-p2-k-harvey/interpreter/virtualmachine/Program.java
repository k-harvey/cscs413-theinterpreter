package interpreter.virtualmachine;


import java.util.ArrayList;
import interpreter.bytecode.*;
import java.util.*;

public class Program extends Object{

    private ArrayList<ByteCode> program;
    static HashMap<String, Integer> programLabels;

    public Program() {
        program = new ArrayList<>();
        programLabels = new HashMap<>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    public int getSize() {
        return this.program.size();
    }
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    public void addCode(ByteCode byteCode) {      //changed from protected to public
        if (byteCode instanceof LabelCode) {
            LabelCode newBranch = (LabelCode) byteCode;
            addLabel(newBranch.getLabel(), program.size());
        }
        program.add(byteCode);
    }

    protected static void addLabel(String label, int size) { //changed from protected to public
        programLabels.put(label, size);
    }
    public void resolveAddrs(Program program) {

        for (int i = 0; i < program.getSize(); i++) {
            if (program.getCode(i) instanceof GoToCode) {
                GoToCode newCode = (GoToCode) program.getCode(i);
                newCode.setFinalAddress(programLabels.get(newCode.getLabel()));
            } else if (program.getCode(i) instanceof FalseBranchCode) {
                FalseBranchCode newCode = (FalseBranchCode) program.getCode(i);
                newCode.setFinalAddress(programLabels.get(newCode.getLabel()));
            } else if (program.getCode(i) instanceof CallCode) {
                CallCode newCode = (CallCode) program.getCode(i);
                newCode.setFinalAddress(programLabels.get(newCode.getLabel()));
            }
        }
    }



}
