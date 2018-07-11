package stages;

import pipline.ID_EX;
import pipline.IF_ID;
import units.ControlUnit;
import units.HazardDetectionUnit;
import units.RegisterFile;
import units.SignExtend;


public class InstructionDecode {


    private RegisterFile registerFile = new RegisterFile();
    private ControlUnit controlUnit = new ControlUnit();
    private HazardDetectionUnit hazardDetectionUnit = new HazardDetectionUnit();
    private SignExtend signExtend = new SignExtend();

    static String SIGN_EXTEND_ADDRESS;
    static String PC_ADDRESS;
    static boolean IF_FLUSH;

    public void instructionDecode(){

        if((!IF_ID.INSTRUCTION.equals("0")) & (!IF_ID.NO_OP)) {
            System.out.printf("                INSTRUCTION HAS BEEN DECODED\n");


            String function = IF_ID.INSTRUCTION.substring(26, 32);
            String rd = IF_ID.INSTRUCTION.substring(16, 21);
            String rt = IF_ID.INSTRUCTION.substring(11, 16);
            String rs = IF_ID.INSTRUCTION.substring(6, 11);
            String opCode = IF_ID.INSTRUCTION.substring(0, 6);
            String address = IF_ID.INSTRUCTION.substring(16,32);
            String jumpAddress = IF_ID.INSTRUCTION.substring(6);

            System.out.printf ( "\nINSTRUCTION : " + IF_ID.INSTRUCTION +
                                "\nOP_CODE : " + opCode+
                                "\nRS : " + rs+
                                "\nRT : " + rt+
                                "\nRD : " + rd+
                                "\nFUNCTION : " + function+
                                "\nADDRESS : " + address);

            ID_EX.RS = rs;
            ID_EX.RT = rt;
            ID_EX.RD = rd;


            // calling control unit to do his job
            controlUnit.controlUnit(opCode);

            // checking hazard in the code
            hazardDetectionUnit.hazardDetectionUnit(rs);

            ID_EX.RS_AMOUNT = registerFile.getRegister(rs);
            ID_EX.RT_AMOUNT = registerFile.getRegister(rt);
            ID_EX.FUNCTION = function;

            //sign extending the 15 starting bits if instruction
            SIGN_EXTEND_ADDRESS = signExtend.signExtend(address);

            ID_EX.ADDRESS = (SIGN_EXTEND_ADDRESS + "00").substring(2);

            // checking if the instruction is branch and if we should jump too another pc
            if (ID_EX.RS_AMOUNT.equals(ID_EX.RT_AMOUNT) & (ID_EX.BRANCH == 1)) {
                IF_FLUSH = true;
                PC_ADDRESS = Integer.toString(Integer.parseInt(SIGN_EXTEND_ADDRESS,2)+Integer.parseInt(IF_ID.PC,2),2);
                System.out.println("--\nBRANCH HAS BEEN TAKEN\nADDRESS : " + Integer.parseInt(SIGN_EXTEND_ADDRESS , 2)
                        + "\nPC : "+ Integer.parseInt(IF_ID.PC,2) + "\nNEW PC : " + Integer.parseInt(PC_ADDRESS,2));
            } else {
                PC_ADDRESS = IF_ID.PC;
            }

            // checking if the instruction is a jump instruction
            if (opCode.equals("000010")){
                IF_FLUSH = true;
                PC_ADDRESS = "000000" +jumpAddress;
                System.out.println("--\nJUMP HAS BEEN TAKEN\nNEW PC : " + Integer.parseInt(PC_ADDRESS,2));
            }

            ID_EX.NO_OP = IF_ID.NO_OP;

        }else{
            System.out.println("                             STALL");
        }
    }
}
