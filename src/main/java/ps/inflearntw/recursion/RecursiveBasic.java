package ps.inflearntw.recursion;

public class RecursiveBasic {

    public static void DFS(int number){
        if(number > 0){
            System.out.println(number);
            DFS(number-1);
        }
    }

    public static void main(String[] args) {
        RecursiveBasic.DFS(3);
    }
}
