package ps.inflearntw.part1;

import java.util.ArrayList;
import java.util.List;

public class Decryption {

    private final List<String> cryptos = new ArrayList<>();
    private List<String> binaries = new ArrayList<>();
    private List<Integer> decimals = new ArrayList<>();

    public Decryption(String text, int count) {
        for(int i=0; i<count; i++){
            cryptos.add(text.substring(7*i,7*(i+1)));
        }
    }

    public static Decryption of(String text,int count){
        return new Decryption(text,count);
    }

    public List<String> getCryptos() {
        return cryptos;
    }

    public void convertSpecialToBinary() {
        for (String crypto : cryptos) {
            binaries.add(crypto.replace("#","1").replace("*","0"));
        }
    }

    public List<String> getBinaries() {
        return this.binaries;
    }

    public List<Integer> getDecimals() {
        return this.decimals;
    }

    public void convertBinaryToDecimal() {
        for (String binary : binaries) {
            decimals.add(Integer.valueOf(binary,2));
        }
    }

    public String decryption() {
        convertSpecialToBinary();
        convertBinaryToDecimal();
        return convertDecimalToCharacter();
    }

    private String convertDecimalToCharacter() {
        String answer = "";
        for (Integer decimal : decimals) {
            answer += Character.toString(decimal);
        }
        return answer;
    }
}
