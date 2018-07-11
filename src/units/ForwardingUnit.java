package units;

import pipline.EX_MEM;
import pipline.ID_EX;
import pipline.MEM_WB;
import stages.Memory;
import stages.WriteBack;


public class ForwardingUnit {

    private String forwardA = "00";
    private String forwardB = "00";

    public String forwardingUnit(){

        if (!WriteBack.forwarded_NO_OP) {

            System.out.print("                  FORWARDING UNIT STARTED\n");

            System.out.print("MEM_WB , DESTINATION REGISTER : " + Memory.forwardedDestination +
                    "\nMEM_WB , REGISTER WRITE CONTROL : " + MEM_WB.REGISTER_WRITE +
                    "\nID_EX , RS : " + ID_EX.RS +
                    "\nID_EX , RT : " + ID_EX.RT + "\n");

            if (Memory.forwardedDestination != null) {
                System.out.println("hi");
                if ((MEM_WB.REGISTER_WRITE == 1 & Memory.forwardedDestination != "00000")
                        & (Memory.forwardedDestination.equals(ID_EX.RS))){
                    forwardA = "01";
                    System.out.print("FORWARD TYPE 2 REGISTER RS\n");
                }
                if ((MEM_WB.REGISTER_WRITE == 1 & Memory.forwardedDestination != "00000")
                        & (Memory.forwardedDestination.equals(ID_EX.RT))) {
                    forwardB = "01";
                    System.out.print("FORWARD TYPE 2 REGISTER RT\n");
                }
            }
        }
        if(!MEM_WB.NO_OP){
            System.out.print("EX_MEM , REGISTER WRITE : " + EX_MEM.REGISTER_WRITE +
                    "\nEX_MEM , DESTINATION REGISTER : " + EX_MEM.DESTINATION_REGISTER +
                    "\nRT : " + ID_EX.RT + "\n");

            if ((EX_MEM.REGISTER_WRITE == 1) & (EX_MEM.DESTINATION_REGISTER != "00000")
                    & (EX_MEM.DESTINATION_REGISTER.equals(ID_EX.RS))) {
                System.out.print("FORWARD TYPE 1 REGISTER RS\n");
                forwardA = "10";
            }
            if ((EX_MEM.REGISTER_WRITE == 1) & (EX_MEM.DESTINATION_REGISTER != "00000")
                    & (EX_MEM.DESTINATION_REGISTER.equals(ID_EX.RT))) {
                System.out.print("FORWARD TYPE 1 REGISTER RT\n");
                forwardB = "10";
            }

            if (ID_EX.MEMORY_WRITE == 1 | ID_EX.MEMORY_READ == 1){
                forwardB = "11";
            }
        }

        return forwardA + forwardB;
    }

}
