package units;

public class ALU {

    public String alu(String first , String second , String ALU_INPUT) {
        int ALU_operation = Integer.parseInt(ALU_INPUT,2);
        System.out.printf("\n                      ALU STARTED WORKING" +
                "\nREGISTER ONE AMOUNT : " + first +
                "\nREGISTER TWO AMOUNT : " + second +
                "\nALU OPERATION : " + ALU_INPUT);

        if (ALU_operation == 0)         // AND Operation
            return and(first, second);

        else if (ALU_operation == 1)    // OR Operation
            return or(first, second);

        else if (ALU_operation == 2)    // ADD Operation
            return add(first,second);

        else if (ALU_operation == 5)    // SUB Operation
            return sub(first, second);

        else if (ALU_operation == 7)    // SLT Operation
            return slt(first, second);

        else if (ALU_operation == 12)   // NOR Operation
            return nor(first, second);

        else if (ALU_operation == 13)   // XOR Operation
            return xor(first,second);

        return null;
    }

    private String and (String a ,String b){
        int  decimal1 = Integer.parseInt(a, 2);
        int  decimal2 = Integer.parseInt(b, 2);
        int  resault = decimal1 & decimal2;
        String res ;
        res = "00000000000000000000000000000000" + Long.toBinaryString(resault) ;
        return res.substring(res.length()-32,res.length());
    }

    private String add(String a , String b){
        int decimal1 = Integer.parseInt(a, 2);
        int decimal2 = Integer.parseInt(b, 2);
        int resault = decimal1 + decimal2;
        String res ;
        res = "00000000000000000000000000000000" + Integer.toBinaryString(resault) ;
        return res.substring(res.length()-32,res.length());
    }


    private String sub(String a, String b) {
        int decimal1 = Integer.parseInt(a, 2);
        int decimal2 = Integer.parseInt(b, 2);
        int resault = decimal1 - decimal2;
        String res ;
        res = "00000000000000000000000000000000" + Integer.toBinaryString(resault) ;
        return res.substring(res.length()-32,res.length());
    }

    private String or(String a, String b) {
        int  decimal1 = Integer.parseInt(a, 2);
        int  decimal2 = Integer.parseInt(b, 2);
        int  resault = decimal1 | decimal2;
        String res ;
        res = "00000000000000000000000000000000" + Long.toBinaryString(resault) ;
        return res.substring(res.length()-32,res.length());
    }

    private String xor(String a, String b) {
        int  decimal1 = Integer.parseInt(a, 2);
        int  decimal2 = Integer.parseInt(b, 2);
        int  resault = decimal1 ^ decimal2;
        String res ;
        res = "00000000000000000000000000000000" + Long.toBinaryString(resault) ;
        return res.substring(res.length()-32,res.length());
    }

    private String nor(String a, String b) {
        int  decimal1 = Integer.parseInt(a, 2);
        int  decimal2 = Integer.parseInt(b, 2);
        int  resault = (decimal1 | decimal2) ^ Integer.parseInt("011111111111111111111111111111111",2);
        String res ;
        res = "00000000000000000000000000000000" + Long.toBinaryString(resault) ;
        return res.substring(res.length()-32,res.length());
    }

    private String slt(String a, String b) {
        int  decimal1 = Integer.parseInt(a, 2);
        int  decimal2 = Integer.parseInt(b, 2);
        if (decimal1 < decimal2) {
            return "00000000000000000000000000000001";
        }else{
            return "00000000000000000000000000000000";
        }

    }
}
