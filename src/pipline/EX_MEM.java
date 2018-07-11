package pipline;

public class EX_MEM {

    public static String ALU_RESULT ;
    public static String ALU_INPUT2 ;
    public static String DESTINATION_REGISTER ;

    public static boolean NO_OP = true;

    /**
     * Memory Stage Control Registers
     */
    public static int BRANCH ;
    public static int MEMORY_WRITE ;
    public static int MEMORY_READ ;

    /**
     * Wrote Back Stage Control Registers
     */
    public static int MEM_TO_REG ;
    public static int REGISTER_WRITE ;

}
