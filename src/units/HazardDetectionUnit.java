package units;

import pipline.ID_EX;
import pipline.IF_ID;
import stages.Execution;

public class HazardDetectionUnit {

    public void hazardDetectionUnit(String rs){
        System.out.printf("\n\n                HAZARD DETECTION UNIT STARTED\nHAZARD : ");

        if ((Execution.HAZARD_DETECTION_UNIT_INPUT == 1) & (!ID_EX.NO_OP)
                &((ID_EX.RT.equals(rs)) | (ID_EX.RS.equals(rs)))){
            System.out.printf("TRUE\n");
            IF_ID.PC = Integer.toString(Integer.parseInt(IF_ID.PC , 2) - 1,2) ;
            IF_ID.NO_OP = true;
        }else{
            System.out.printf("FALSE\n");
            ID_EX.NO_OP = false;
        }

    }
}
