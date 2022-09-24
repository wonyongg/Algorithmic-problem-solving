// 1181 단어정렬
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;


public class Main {
    public static void main(String[] args) throws IOException {

        // 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String strCount = br.readLine(); // readLine 메서드는 입력값 한 줄을 스트링으로 받음
        int count = Integer.parseInt(strCount); // 인트형으로 변환

        String[] strArr = new String[count]; // 스트링 배열 생성후 배열 크기를 count로 설정

        for (int i = 0; count > i; i++) { // for 문으로 입력 받은 단어를 배열의 요소로 넣음
            String str = br.readLine();
            strArr[i] = str;
        }

        Arrays.sort(strArr, new Comparator<String>() {
            // 첫번째 인자로 strArr을 받고, 두번째 인자로 Comparator 인터페이스를 구현한 객체를 받음(익명 구현 객체)
            @Override
            public int compare(String o1, String o2) { // 문자열 길이 및 순서 비교
                if(o1.length() == o2.length()) { // 두 문자열의 길이가 같을 때,
                    return o1.compareTo(o2);
                    // 각 문자열을 1:1 비교하여 다른 문자가 나오면, ex) abcd, axcv일 때 b와 x
                    // 두 문자를 ASCII코드로 변환해서 두 값의 차를 계산하여 양수 음수를 따져 사전 순 정렬
                }
                else{ // 두 문자열의 길이가 다르다면
                    return o1.length() - o2.length();
                    // 리턴값이 양수면 o1이 큰값이 되고, 음수면 o2가 큰 값이 된다.
                }
            }
        });

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(strArr));
        //LinkedHashset을 통해 중복 값을 제거함과 동시에 배열 순서를 유지.
        String[] newStrArr = linkedHashSet.toArray(new String[] {});
        // 새로운 배열을 만들어 Set을 배열로 옮김, {}는 길이가 0인 배열로 초기화 왜 0인지 궁금.

        for (int i = 0; newStrArr.length > i; i++) { // for문을 통해 하나씩 출력
            bw.write(newStrArr[i] + "\n"); //write는 쓰기를 통해 버퍼링함
        }
        bw.flush(); // flush로 write를 통해 버퍼링한 내용들을 한 번에 출력
        bw.close(); //stream 닫기
    }
}