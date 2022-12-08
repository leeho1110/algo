package algorithm.dfs;

import algorithm.Sample;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    private int subSetNumber;
    private int[] ch;

    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> findSubset(int number) {
        /**
         * 1,2,3을 다 쓰는 경우가 있을 것이고
         * 1,2만 사용하는 경우가 있을 것이고
         * 1만 사용하는 경우 그니까 모든 경우를 전부다 탐색을 하는데 이걸
         */
        this.subSetNumber = number;
        this.ch = new int[number];
        dfs(1);
        return answer;
    }

    private void dfs(int level) {
        if(level == subSetNumber + 1){
            List<Integer> numbers = new ArrayList<>();
            for (int i : ch) {
                if(ch[i] == 1){
                    numbers.add(i+1);
                }
            }
        } else {
            ch[level] = 1; // 사용한다.
            dfs(level+1);
            ch[level] = 0; // 사용하지 않는다.
            dfs(level+1);
        }
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
        System.out.println("첫번째 sample의 객체 주소값은 "+ sample); // sample의 해시값(1)

        Sample sample2 = sample;
        System.out.println("sample2의 객체주소값은 " + sample2); // sample2에는 sample의 주소값이 들어가있ㅇ므 그래서 이건 위에거랑 똑같음 (2)

        // sample2 <- sample <- new Sample()

        sample = new Sample();
        System.out.println(sample);

        // sample2 <- sample <- 50라인 new Sample()?
        //            new Sample()?
        // 근데 여기서 samepl2가 참고하는건 맨 처음에 sample이 갖고 있는 객체 주소의 복사본을 들고 있는거임

        // 그래서 맨 위 샘플은 값이 바뀌는데 sample2가 들고있는 sample은 바뀌지 않음

        System.out.println("새로운값을 넣은 뒤 sample "+sample); // 근데 sample에다가 새로운 객체의 주소를 할당했음, 그럼 여기서 문제가 발생하는데, 얘는 (1)이랑 다른 새로운 애
        System.out.println("새로운값을 넣은 뒤 sample2 "+sample2); // 얘는 자기가 들고 있떤 sample은 맨 윗줄에서 생성됐던 메모리 주소의 위치기떄문에 새롭게 할당됐다고 해도 기존 상태를 유지한다.  (2)랑 같고

    }

    public static void process(Sample sample){
        sample.setValue(10);

        Sample sample1 = new Sample();
        sample1.setValue(15);
        sample = sample1;
    }
}
