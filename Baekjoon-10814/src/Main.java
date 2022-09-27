// 10814 나이순 정렬
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        int user = Integer.parseInt(br.readLine()); // 유저 수 입력받기

        String[][] arr = new String[user][2]; // 이차원 배열 생성

        for (int i = 0; user > i; i++){
            String secondInput = br.readLine(); // 나이와 이름 공백을 기준으로 입력 받음
            String[] userBox = secondInput.split(" "); // 공백 기준으로 나눠
            arr[i][0] = userBox[0]; // 배열에 넣음
            arr[i][1] = userBox[1];
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                return Integer.compare(Integer.parseInt(o1[0]),Integer.parseInt(o2[0]));
            } // 인덱스 [0]의 값인 나이를 비교 하고 양수면 왼쪽, 음수면 오른쪽이 먼저 정렬됨
            // 나이가 같은 경우는 0이 반환되어 자연스레 입력순으로 정렬된다.
        });


        for (int i = 0; user > i; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}