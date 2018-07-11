package pipline;

public class ID_EX {

    public static String RS_AMOUNT ;
    public static String RT_AMOUNT ;
    public static String RS ;
    public static String RT ;
    public static String RD ;
    public static String ADDRESS;

    public static boolean NO_OP = true;

    /**
     * Execution Stage Control Registers
     */
    public static int ALU_SOURCE ;
    public static String ALU_OP = null ;
    public static int REGISTER_DEST ;
    public static String FUNCTION;

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
