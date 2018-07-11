package stages;

import pipline.EX_MEM;
import pipline.MEM_WB;
import units.DataMemory;

public class Memory {

    public static String forwardedDestination;
    private DataMemory dataMemory = new DataMemory();


    public void memory(){

        if(!EX_MEM.NO_OP){
            System.out.printf("                MEMORY HAS BEEN STARTED WORKING\n");
            System.out.println("\nMEMORY WRITE CONTROL : " + EX_MEM.MEMORY_WRITE +
                             "\nMEMORY READ CONTROL : " + EX_MEM.MEMORY_READ +
                             "\nALU_RESULT : " + EX_MEM.ALU_RESULT +
                             "\nALU_INPUT : " + EX_MEM.ALU_INPUT2);


            // write into memory
            if (EX_MEM.MEMORY_WRITE == 1){
                dataMemory.writeMemory(Integer.parseInt(EX_MEM.ALU_RESULT,2),EX_MEM.ALU_INPUT2);
            }

            // read from memory
            if (EX_MEM.MEMORY_READ == 1){
                MEM_WB.READ_DATA = dataMemory.readMemory(Integer.parseInt(EX_MEM.ALU_RESULT,2));
            }

        }else{
            System.out.println("                             STALL");
        }

        MEM_WB.ALU_RESULT = EX_MEM.ALU_RESULT;
        Memory.forwardedDestination = MEM_WB.DESTINATION_REGISTER;
        MEM_WB.DESTINATION_REGISTER = EX_MEM.DESTINATION_REGISTER;

        MEM_WB.NO_OP = EX_MEM.NO_OP;
        MEM_WB.MEM_TO_REG = EX_MEM.MEM_TO_REG;
        MEM_WB.REGISTER_WRITE = EX_MEM.REGISTER_WRITE;

    }

}
