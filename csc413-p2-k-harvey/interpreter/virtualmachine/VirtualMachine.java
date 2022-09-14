package interpreter.virtualmachine;

import java.util.Stack;

import interpreter.bytecode.*;

        public class VirtualMachine {

            private RunTimeStack   runTimeStack;
            private Stack<Integer> returnAddress;
            private Program        program;
            private int            programCounter;
            private boolean        isRunning;
            private boolean        dump;

            public VirtualMachine(Program program) {
                this.program = program;
            }   //changed from public to protected




/*public void executeProgram(){
    programCounter = 0;
    runTimeStack = new RunTimeStack();
    isRunning = true;

    while(isRunning){
        ByteCode code = program.getCode(programCounter);
        code.execute(this);
        programCounter++;
    }
}*/

            public void executeProgram() {  //changed from protected to public

                runTimeStack = new RunTimeStack();
                returnAddress = new Stack<>();
                isRunning = true;
                while(isRunning) {
                    ByteCode newCode = program.getCode(programCounter);
                    newCode.execute(this);
                    if (dump && !(newCode instanceof DumpCode)) {
                        System.out.println(newCode.toString());
                        runTimeStack.dump();
                    }
                    programCounter++;
                }
            }


            public void setRunning(boolean isRunning) {
                this.isRunning = isRunning;
            }

            public int peek() {
                return runTimeStack.peek();
            }

            public int pop() {
                return runTimeStack.pop();
    }

    public void newFrameAt(int offset) {
        runTimeStack.newFrameAt(offset);
    }

    public void popFrame() {
        runTimeStack.popFrame();
    }

    public int store(int offset) {
        return runTimeStack.store(offset);
    }

    public int load(int offset) {
        return runTimeStack.load(offset);
    }

    public void push(int result) {
        runTimeStack.push(result);
    }

    public void setPc(int pc) {
        this.programCounter = pc;
    }

    public int getPc() {
        return programCounter;
    }

    public int popReturnAddrs() {
        return returnAddress.pop();
    }

    public void pushReturnAddrs(int address) {
        returnAddress.push(address);
    }

    public void dumpOn() {
        dump = true;
    }

    public void dumpOff() {
        dump = false;
    }
}