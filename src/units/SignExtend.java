package units;

public class SignExtend {

    public String signExtend(String address){
        if (address.substring(0).equals("1")){
            return "1111111111111111" + address ;
        }
        return "0000000000000000" + address;
    }
}
