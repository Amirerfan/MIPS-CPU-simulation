package units;

import java.io.*;
import java.util.ArrayList;

public class DataMemory {

    public static ArrayList<String> memory = new ArrayList<>();
    String memoryBity ;

    public DataMemory() {
        readMemory();
    }


    /**
     * this function read all memory values from file named "Data Memory.txt"
     */
    void readMemory(){

        try {
            File file = new File("Data Memory.txt");
            FileReader memoryReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(memoryReader);
            while ((memoryBity = bufferedReader.readLine()) != null) {
                memory.add(memoryBity);
            }

            memoryReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * this function return value of specific memory word from data memory
     * @param index of memory that you want its value
     * @return value of memory in String format
     */
    public String readMemory (int index){
        return memory.get(index) + memory.get(index+1) + memory.get(index+2) + memory.get(index+3);
    }

    /**
     * this function change value of specific word in memory
     * as MIPS cpu memory is big endian here too
     * @param index of memory word that you want to change its value
     * @param content that you want to write in memory
     * @return 1 if it works correct
     */
    public int writeMemory (int index , String content){
        memory.set(index,content.substring(0,8));
        memory.set(index+1,content.substring(8,16));
        memory.set(index+2,content.substring(16,24));
        memory.set(index+3,content.substring(24,32));

        try (PrintStream out = new PrintStream(new FileOutputStream("Data Memory.txt"))) {
            for (int i = 0 ; i < 128 ; i++){
                out.println(memory.get(i));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
