
package interpreter;

import interpreter.virtualmachine.Program;
import interpreter.bytecode.*;
//import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;
import java.util.ArrayList;




public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    //private Program program;
    private Program program = new Program();
    private StringTokenizer tok;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts. Can also use the split function in the String class.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */

/*
    public Program loadCodes() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.program = new Program();
        ArrayList<String> args = new ArrayList<>();
        String lineReader = byteSource.readLine();
        while (lineReader != null) {
            StringTokenizer tok = new StringTokenizer(lineReader);
            args.clear();
            String byteCodeClass = CodeTable.getClassName(tok.nextToken());
            while (tok.hasMoreTokens()) {
                args.add(tok.nextToken());
            }
            ByteCode byteCode = (ByteCode)(Class.forName("interpreter.ByteCode." + byteCodeClass).newInstance());
            byteCode.init(args);
            program.addCode(byteCode);
            lineReader = byteSource.readLine();
        }
        program.resolveAddrs(program);
        return program;
    }
}
*/
    public Program loadCodes()  { //removed throws IOException
        String line = null;
        String codeClass = null;
        try {
            while ((line = this.byteSource.readLine()) != null) {
                tok = new StringTokenizer(line);  //contructor delimeter is "" just a space
                codeClass = CodeTable.getClassName(tok.nextToken());
                try {
                    ByteCode ByteInstance = (ByteCode) (Class.forName("interpreter.ByteCode." + codeClass).newInstance());

                    while (tok.hasMoreElements()) {
                        ByteInstance.load(tok.nextToken());
                    }

                    this.program.addCode(ByteInstance);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

            }


        } catch (IOException e) {
            System.out.println(e.getMessage() + "Error reading file");
        }

        this.program.resolveAddrs(program);

        return program;
    }
}



/*
         catch (IOException e) { (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
            System.exit(status: 255);

        } catch (InstantiationException| InvocationTargetException | NoSuchMethodException | IllegalAccessException e){
            e.printStackTrace();
        }
 */
       // } catch (IOException e){

           // System.out.println(e.getMessage() + "Error reading file");

            //System.out.println(ex);
            //System.exit(status: 255);







   /* public Program loadCodes()  {    //removed throws IOException
        String line;  //removed =null
        String[] items;
        ArrayList<String> args = new ArrayList<>();
        String byteCodeName;
        String className;
        Class classBlueprint;
        Program program = new Program();
        ByteCode bc;

        try {
            while (this.byteSource.ready()) {
                line = this.byteSource.readLine();  //contructor delimeter is "" just a space
                items = line.split("\\s+");
                byteCodeName = items[0];
                className = CodeTable.getClassName(byteCodeName);
                classBlueprint = Class.forName("interpreter.ByteCode." + className);
                bc = (ByteCode) classBlueprint.getDeclaredConstructor().newInstance();
                for (int a = 1; a < items.length; a++) {
                    args.add(items[a]);
                }

                bc.init(args);
                program.addCode(bc);
                args.clear();
            }
        }
        catch (IOException | NoSuchMethodException e) {
            (IOException | ClassNotFoundException e){
                System.out.println(e);
                System.exit(255);

            }
        catch(InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e){
                e.printStackTrace();
            }

        }


    */