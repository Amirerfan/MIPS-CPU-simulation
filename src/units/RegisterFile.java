package units;

import java.io.*;
import java.util.ArrayList;

public class RegisterFile {

    public static ArrayList<String> registers = new ArrayList<>();

    public RegisterFile() {
        readRegister();
    }

    /**
     * this function read all registers values from file named "Register File.txt"
     */
    public void readRegister() {
        try {
            File file = new File("Register File.txt");
            FileReader registerReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(registerReader);
            String register;
            while ((register = bufferedReader.readLine()) != null) {
                registers.add(register);
            }
            registerReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this function return value of specific register from register file
     * @param  index : number of register that you want its value
     * @return value of register in register file in String format
     */
    public String getRegister (String index){
        int decimal = Integer.parseInt(index , 2);
        return registers.get(decimal);
    }

    /**
     * this function change value of register that you want
     * @param regNumber : number of register that you want to change its value
     * @param value : value that you want to set the register
     * @return 1 if it works correct
     * @throws IOException
     */
    public static int writeToReg (String regNumber , String value ) throws IOException {
        registers.set(Integer.parseInt(regNumber,2) , value);

        try (PrintStream out = new PrintStream(new FileOutputStream("Register File.txt"))) {
            for (int i = 0 ; i < 32 ; i++){
                out.println(registers.get(i));
            }
        }

        return 0;
    }
}
