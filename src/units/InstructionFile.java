package units;

import driver.Driver;

import java.io.*;
import java.util.ArrayList;

public class InstructionFile {

    private ArrayList<String> instructions = new ArrayList<>();
    private int numberOfIns;

    public InstructionFile() { readInstruction(); }


    /**
     * this function read all of the instructions from file named "Instruction File.txt"
     */
    void readInstruction(){
        try {
            File file = new File("Instruction File.txt");
            FileReader instructionReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(instructionReader);
            String instruction;
            while ((instruction = bufferedReader.readLine()) != null) {
                instructions.add(instruction);
                numberOfIns++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Driver.THERE_IS_INSTRUCTION = numberOfIns;
    }

    /**
     * It return one instruction
     * @param pc is Program Counter that specify number of instruction that should return
     * @return the instruction as String
     */
    public String getInstruction(int pc){
        if (pc < numberOfIns) {
            return instructions.get(pc);
        }
        return null;
    }

}
