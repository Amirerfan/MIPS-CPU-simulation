package stages;

import pipline.IF_ID;
import units.InstructionFile;

public class InstructionFetch {

    private int pc = 0;
    private InstructionFile instructionFile = new InstructionFile();

    public int instructionFetch(){
        System.out.printf("                 INSTRUCTION HAS BEEN FETCHED\n\n");

        //check if there is any branch or jump and update the pc
        if (InstructionDecode.IF_FLUSH){
            pc = Integer.parseInt(InstructionDecode.PC_ADDRESS , 2);
        }else{
            pc = Integer.parseInt(IF_ID.PC,2);
        }
        System.out.println("PC : " + pc);

        // fetching the instruction from instruction file
        IF_ID.INSTRUCTION = instructionFile.getInstruction(pc);
        IF_ID.NO_OP = false;
        if(IF_ID.INSTRUCTION == null){  // if there is no instruction left
            System.out.printf("   ||||||||||||||   end of instructions    ||||||||||||||");
            return 1;
        }
        System.out.printf("INSTRUCTION : " + IF_ID.INSTRUCTION);

        // updating PC
        IF_ID.PC = Integer.toString( pc + 1 , 2);
        return 0;
    }
}