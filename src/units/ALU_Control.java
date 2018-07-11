package units;

import pipline.ID_EX;
import stages.Execution;

public class ALU_Control {

    public void aluControl(){
        System.out.printf("\n                  ALU CONTROL STARTED WORKING\nALU_OP : " + ID_EX.ALU_OP + "\n");

        if(ID_EX.ALU_OP.equals("00"))                    // LW operation and SW operation
            Execution.ALU_INPUT = "0010";

        else if (ID_EX.ALU_OP.equals("01"))              // Beq operation
            Execution.ALU_INPUT = "0110";

        else if (ID_EX.ALU_OP.equals("10")) {            // R Type
            if (ID_EX.FUNCTION.equals("100000"))         // add
                Execution.ALU_INPUT = "0010";
            else if (ID_EX.FUNCTION.equals("100010"))    // subtract
                Execution.ALU_INPUT = "0110";
            else if (ID_EX.FUNCTION.equals("100100"))    // and
                Execution.ALU_INPUT = "0000";
            else if (ID_EX.FUNCTION.equals("100101"))    // or
                Execution.ALU_INPUT = "0001";
            else if (ID_EX.FUNCTION.equals("101010"))    // set les than
                Execution.ALU_INPUT = "0111";
            else if (ID_EX.FUNCTION.equals("100111"))    // nor
                Execution.ALU_INPUT = "1100";
            else if (ID_EX.FUNCTION.equals("101000"))    // xor
                Execution.ALU_INPUT = "1101";
        }
        System.out.printf("ALU OPERATION : " + Execution.ALU_INPUT+"\n");
    }
}
