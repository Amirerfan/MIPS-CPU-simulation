package units;

import pipline.ID_EX;


public class ControlUnit {

    public void controlUnit(String op_code){
        System.out.printf("\n\n               CONTROL UNIT STARTED WORKING\nOP_CODE : " + op_code + "\nINSTRUCTION FORMAT : ");

        if(op_code.equals("000000")){         // R format instructions
            System.out.printf("R FORMAT\n");
            ID_EX.REGISTER_DEST = 1;
            ID_EX.ALU_SOURCE = 0;
            ID_EX.MEM_TO_REG = 0;
            ID_EX.REGISTER_WRITE = 1;
            ID_EX.MEMORY_READ = 0;
            ID_EX.MEMORY_WRITE = 0;
            ID_EX.BRANCH = 0;
            ID_EX.ALU_OP = "10";


        }else if (op_code.equals("100011")){   // LW instruction
            System.out.printf("LW INSTRUCTION \n");
            ID_EX.REGISTER_DEST = 0;
            ID_EX.ALU_SOURCE = 1;
            ID_EX.MEM_TO_REG = 1;
            ID_EX.REGISTER_WRITE = 1;
            ID_EX.MEMORY_READ = 1;
            ID_EX.MEMORY_WRITE = 0;
            ID_EX.BRANCH = 0;
            ID_EX.ALU_OP = "00";

        }else if (op_code.equals("101011")){   // SW instruction
            System.out.printf("SW INSTRUCTION \n");
            ID_EX.REGISTER_DEST = 0;
            ID_EX.ALU_SOURCE = 1;
            ID_EX.MEM_TO_REG = 0;
            ID_EX.REGISTER_WRITE = 0;
            ID_EX.MEMORY_READ = 0;
            ID_EX.MEMORY_WRITE = 1;
            ID_EX.BRANCH = 0;
            ID_EX.ALU_OP = "00";


        }else if (op_code.equals("000100")){   // beq instruction
            System.out.printf("BRANCH EQUAL INSTRUCTIONS \n");
            ID_EX.REGISTER_DEST = 0;
            ID_EX.ALU_SOURCE = 0;
            ID_EX.MEM_TO_REG = 0;
            ID_EX.REGISTER_WRITE = 0;
            ID_EX.MEMORY_READ = 0;
            ID_EX.MEMORY_WRITE = 0;
            ID_EX.BRANCH = 1;
            ID_EX.ALU_OP = "01";
        }
        else
            System.out.printf("THIS OP_CODE IS NOT IN CONTROL UNIT \n");

    }
}
