// 9012 괄호
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 규칙 찾기 : 괄호가 입력될때마다 '('가 ')'보다 항상 같거나 많아야 하며, 마지막에는 두 괄호의 개수가 같아야 한다.

        Queue<String> que = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        // 입력받을 개수를 입력받는다.
        int n = sc.nextInt();

        sc.nextLine();
        // for문으로 n개만큼 스트링을 입력받는다.
        for (int i = 0; n > i; i++) {
            String str = sc.nextLine();
            que.add(str);    // 큐에 넣는다.
        }

        // 큐에서 뺴면서 yesOrNo 메서드 호출 결과로 YES or NO 출력
        while (que.size() > 0) {
            if(yesOrNo(que.poll()) == true) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    /**
     * 큐에서 뽑은 str을 chatAt를 이용하여 한글자 단위로 나누고, '('와 ')'의 개수를 카운팅하여 비교하는 메서드
     * @param str que.poll()
     * @return '('이 ')'보다 항상 개수가 같거나 많으며, 최종적으로 둘의 개수가 같은 경우에만 true 리턴
     */
    static boolean yesOrNo(String str) {
        int left = 0;    // '(' 개수
        int right = 0;    // ')' 개수
        for (int i = 0; str.length() > i; i++) {
            if (left >= right) {
                if (str.charAt(i) == '(') left++;
                else {
                    right++;
                }
            }
            if (left < right) return false;    // ※ for문이 끝나면 right의 수가 더 큰지 체크
        }
        if(left == right) return true;    // for문이 종료되고 둘의 수가 같으면 true 리턴
        else return false;
    }
}