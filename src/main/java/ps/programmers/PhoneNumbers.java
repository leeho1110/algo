package ps.programmers;

import java.util.Arrays;

public class PhoneNumbers {

        /**
         놓친 부분
         - 정렬이 필요하다는 점
         -   정렬된 이후엔 사전순으로 정렬되어 있기 때문에
         같은 문자를 갖는 번호는 뭉쳐있을 것이다(ex. 119, 1192)
         즉 자신 바로 뒤에 있는 놈에게 접두어가 되지 않는다면, 그 뒤는 이어지지 않으므로 절대 접두어가 될 수 없다.
         따라서 바로 뒤에만 체크해보면 된다.

         ex) 119, 1921, 1194, 1193, 2334, 3456
         -> sort 시: 119, 1193, 1194, 1921, 2334, 3456
         -> 비교 시 119 ~ 1193! 다른 번호의 접두어가 되는 경우가 발견됐으므로 false

         ex) 119, 1921, 3456, 2334,
         -> sort 시: 119, 1921, 2334, 3456
         -> 비교 시 119~1921, 여기서부터 안되므로 뒤에는 볼 필요도 없고
         1921~2334, 역시 바로 뒤부터 안되므로 뒤를 볼 필요 없다.
         마지막 2334~3456 바로 뒤부터 안되므로 뒤는 없다.
         */

        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book);

            for(int i=0; i<phone_book.length; i++){
                if(i+1 < phone_book.length){
                    if(phone_book[i+1].startsWith(phone_book[i])){
                        return false;
                    }
                }
            }
            return true;
        }
}
