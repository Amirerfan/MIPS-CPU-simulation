package stages;

import pipline.MEM_WB;
import units.RegisterFile;

import java.io.IOException;

public class WriteBack {

    public static String forwardingData ;
    public static boolean forwarded_NO_OP = true;
    public void writeBack() throws IOException {

        if(!MEM_WB.NO_OP){
            System.out.printf("                 WRITE BACK HAS BEEN STARTED WORKING\n");
            System.out.println("REGISTER WRITE CONTROL : " + MEM_WB.REGISTER_WRITE +
                    "\nMEMORY TO REGISTER CONTROL : " + MEM_WB.MEM_TO_REG +
                    "\nDESTINATION REGISTER : " + MEM_WB.DESTINATION_REGISTER +
                    "\nREAD DATA FROM MEMORY : " + MEM_WB.READ_DATA +
                    "\nALU RESULT : " + MEM_WB.ALU_RESULT);

            if(MEM_WB.REGISTER_WRITE == 1) {
                if (MEM_WB.MEM_TO_REG == 1) { // if we should write data from memory to register
                    RegisterFile.writeToReg(MEM_WB.DESTINATION_REGISTER,MEM_WB.READ_DATA);
                    forwardingData = MEM_WB.READ_DATA;
                } else {                      // if we should write data from ALU to register
                    RegisterFile.writeToReg(MEM_WB.DESTINATION_REGISTER,MEM_WB.ALU_RESULT);
                    forwardingData = MEM_WB.ALU_RESULT;
                }
            }
            WriteBack.forwarded_NO_OP = MEM_WB.NO_OP;
        }else{
            System.out.println("                             STALL");
        }
    }

}
