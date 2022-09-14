package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {             //changed from protected to public
        Iterator newIterator = framePointer.iterator();
        int framePointerCounter = (Integer) newIterator.next();
        if (newIterator.hasNext()) {
            framePointerCounter = (Integer) newIterator.next();
        }
        System.out.print("[");
        if (!runTimeStack.isEmpty()) {
            System.out.print(runTimeStack.get(0));
        }
        for (int i = 1; i < runTimeStack.size(); i++) {
            if (i == framePointerCounter) {
                System.out.print("] [" + runTimeStack.get(i));
                if (newIterator.hasNext()) {
                    framePointerCounter = (Integer) newIterator.next();
                }
            } else {
                System.out.print("," + runTimeStack.get(i));
            }
        }
        System.out.println("]");
    }

    public int peek() { //changed from protected to public
        return (int) runTimeStack.get(runTimeStack.size() - 1);
    }

    public int pop() { //changed from protected to public
        int item = (int) runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return item;
    }

    public int push(int i) { //changed from protected to public
        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset) { //changed from protected to public
        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame() { //changed from protected to public
        int value = (int) runTimeStack.get(runTimeStack.size() - 1);
        while (runTimeStack.size() != framePointer.peek()) {
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        framePointer.pop();
        runTimeStack.add(value);
    }

    public int store(int offset) { //changed from protected to public
        int value = (int) runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        runTimeStack.set(framePointer.peek() + offset, value);
        return value;
    }

    public int load(int offset) { //changed from protected to public
        int value = (int) runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(value);
        return value;
    }

}


