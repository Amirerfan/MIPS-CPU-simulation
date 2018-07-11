package stages;

import pipline.EX_MEM;
import pipline.ID_EX;
import units.ALU;
import units.ALU_Control;
import units.ForwardingUnit;

public class Execution {


    public static int HAZARD_DETECTION_UNIT_INPUT;
    public static String ALU_INPUT;
    private int forwardA;
    private int forwardB;
    private String forward;
    private String ALU_input1;
    private String ALU_input2;

    private ALU alu = new ALU();
    private ForwardingUnit forwardingUnit = new ForwardingUnit();
    private ALU_Control alu_control = new ALU_Control();

    public void execution(){

        if(!ID_EX.NO_OP){
            System.out.printf("               EXECUTION HAS BEEN WORKED\n");

            EX_MEM.ALU_INPUT2 = ID_EX.RT_AMOUNT;

            // forwarding unit has been started working
            forward = forwardingUnit.forwardingUnit();

            forwardA = Integer.parseInt(forward.substring(0,2),2);
            forwardB = Integer.parseInt(forward.substring(2,4),2);

            System.out.printf("FORWARD A : " + forwardA +
                              "\nFORWARD B : " + forwardB + " \n");

            // setting ALU input
            if(forwardA == 0)
                ALU_input1 = ID_EX.RS_AMOUNT;
            else if (forwardA == 1)
                ALU_input1 = WriteBack.forwardingData;
            else
                ALU_input1 = EX_MEM.ALU_RESULT;

            if(forwardB == 0)
                ALU_input2 = ID_EX.RT_AMOUNT;
            else if (forwardB == 1)
                ALU_input2 = WriteBack.forwardingData;
            else if (forwardB == 2)
                ALU_input2 = EX_MEM.ALU_RESULT;
            else
                ALU_input2 = ID_EX.ADDRESS;

            // setting destination register value
            if(ID_EX.REGISTER_DEST == 1){
                EX_MEM.DESTINATION_REGISTER = ID_EX.RD;
            }else{
                EX_MEM.DESTINATION_REGISTER = ID_EX.RT;
            }


            System.out.printf("\nDESTINATION REGISTER : " + EX_MEM.DESTINATION_REGISTER + "\n");

            // ALU Control Unit
            alu_control.aluControl();

            // ALU operation
            EX_MEM.ALU_RESULT = alu.alu(ALU_input1,ALU_input2,Execution.ALU_INPUT);
            System.out.println("ALU_RESULT : " + EX_MEM.ALU_RESULT);

        }else{
            System.out.println("                             STALL");
        }

        EX_MEM.NO_OP = ID_EX.NO_OP;
        EX_MEM.BRANCH = ID_EX.BRANCH;
        EX_MEM.MEMORY_WRITE = ID_EX.MEMORY_WRITE;
        EX_MEM.MEMORY_READ = ID_EX.MEMORY_READ;

        EX_MEM.MEM_TO_REG = ID_EX.MEM_TO_REG;
        EX_MEM.REGISTER_WRITE = ID_EX.REGISTER_WRITE;

        Execution.HAZARD_DETECTION_UNIT_INPUT = ID_EX.MEMORY_READ;
    }
}
