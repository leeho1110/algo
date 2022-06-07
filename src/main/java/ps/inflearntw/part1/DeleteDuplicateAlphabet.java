package ps.inflearntw.part1;

import java.util.*;

public class DeleteDuplicateAlphabet {

    private Set<String> findedAlphabet = new LinkedHashSet<>();

    public String solution(String input){

        for(char alphabet : input.toCharArray()){
            findedAlphabet.add(String.valueOf(alphabet));
        }

        StringBuilder answer = new StringBuilder();
        Arrays.stream(findedAlphabet.toArray()).forEach(a -> answer.append(a));

        return answer.toString();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.next();

        DeleteDuplicateAlphabet m = new DeleteDuplicateAlphabet();
        System.out.println(m.solution(input));
    }
}
