package driver;

import stages.*;

import java.io.IOException;

public class Driver {

    public static int THERE_IS_INSTRUCTION  = 1;

    private static InstructionFetch instructionFetch = new InstructionFetch();
    private static InstructionDecode instructionDecode = new InstructionDecode();
    private static Execution execution = new Execution();
    private static Memory memory = new Memory();
    private static WriteBack writeBack = new WriteBack();

    public static void main(String[] args) throws IOException {

        while(true){
            int instructionEnd = runPipline();
            if (instructionEnd == 1)
                break;
        }
        emptyPipline();

    }

    private static int runPipline() throws IOException {
        System.out.printf("================================================================\n************************ CLOCK STARTED *************************\n");
        System.out.printf("                    ** WRITE BACK CALLED **\n\n");
        writeBack.writeBack();

        System.out.printf("      ----------------------------------------------------\n                      ** MEMORY CALLED **\n\n");
        memory.memory();

        System.out.printf("      ----------------------------------------------------\n                    ** EXECUTION CALLED **\n\n");
        execution.execution();

        System.out.printf("      ----------------------------------------------------\n                     ** DECODE CALLED ** \n\n");
        instructionDecode.instructionDecode();

        System.out.printf("      ----------------------------------------------------\n                      ** FETCH CALLED ** \n\n");
        int end = instructionFetch.instructionFetch();

        System.out.printf("\n\n************************* CLOCK ENDED *************************\n");
        if (end == 1){
            return 1;
        }
        return 0;
    }

    public static void emptyPipline() throws IOException {
        System.out.printf("                     ********************\n                     ** EMPTY PIPELINE **\n                     ********************");
        System.out.printf("\n================================================================\n" +
                "************************ CLOCK STARTED *************************\n");
        System.out.printf("                    ** WRITE BACK CALLED **\n\n");
        writeBack.writeBack();

        System.out.printf("      ----------------------------------------------------\n                       ** MEMORY CALLED **\n\n");
        memory.memory();

        System.out.printf("      ----------------------------------------------------\n                     ** EXECUTION CALLED **\n\n");
        execution.execution();

        System.out.printf("\n\n************************* CLOCK ENDED *************************\n");

        System.out.printf("================================================================\n" +
                "************************ CLOCK STARTED *************************\n");
        System.out.printf("                    ** WRITE BACK CALLED **\n\n");
        writeBack.writeBack();

        System.out.printf("      ----------------------------------------------------\n                       ** MEMORY CALLED **\n\n");
        memory.memory();

        System.out.printf("\n\n************************* CLOCK ENDED *************************\n");

        System.out.printf("================================================================\n" +
                "************************ CLOCK STARTED *************************\n");
        System.out.printf("                    ** WRITE BACK CALLED **\n\n");
        writeBack.writeBack();

        System.out.printf("\n\n************************* CLOCK ENDED *************************\n");
    }
}
