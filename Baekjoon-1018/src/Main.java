// 1018 체스판 칠하기
import java.io.*;

public class Main {
    public static int GetMin(int startRow, int startCol, String[] board) { //최소값을 얻는 메서드로, 최소값 계산에 기준이 되는 시작점 값과 체스판 배열을 인자로 받음
        String[] correctBoard =  {"BWBWBWBW", "WBWBWBWB"}; // 올바른 체스판 배열의 경우의 수

        int blackfirst = 0; // 검은색이 시작이 되는 경우를 기준으로 잡음
        for (int i = 0; i < 8; i++){ // GetMin의 매개변수로 받은 시작점 row, column을 기준으로 위아래 8칸짜리 체스판 내에서 잘못 칠해진 색을 찾음
            int row = startRow + i; // 시작점을 기준으로 가로로 8칸까지
            for (int j = 0; j < 8; j++){
                int column = startCol + j; //시작점을 기준으로 세로로 8칸까지
                if (board[row].charAt(column) != correctBoard[i % 2].charAt(j)) blackfirst++; // [i % 2]로 홀짝 구분 가능
            }   // 입력받은 체스판의 행의 각 요소를 올바른 체스판의 요소와 1;1 비교하여 다르면 검은색으로 칠하는 수를 1씩 카운트함
        }
        return Math.min(blackfirst, 64-blackfirst);
        // 중요한 포인트로, 검은색을 기준으로 잡을 때와과 하얀색을 기준으로 잡을 때를 더하면 최대값인 64가 된다.
        // 이를 이용하여 검은색 기준과 하얀색 기준 중 더 작은 값을 리턴
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력값 받는 객체 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력하는 객체 생성

        String firstInput = bf.readLine(); // 첫번째 입력값 받기
        String[] wl = firstInput.split(" "); // 공백 기준으로 나눠서
        int row = Integer.parseInt(wl[0]); // 왼쪽값은 row에
        int column = Integer.parseInt(wl[1]); // 오른쪽값은 column에 넣기

        String[] board = new String[row]; // 체스판 배열 생성
        for (int i = 0; row > i; i++) {
            board[i] = bf.readLine(); // for문을 이용해 board 배열에 스트링형태의 요소 입력 받기 (체스판 완성)
        }
        int result = Integer.MAX_VALUE; // int형 정수의 최대값으로 result 변수 선언
        for (int i = 0; row-8 >= i; i++) { // 체스판의 왼쪽 상단 [0][0]을 기준으로
            for (int j = 0; column-8 >= j; j++) { // row, column에 -8을 해서 8*8모양의 체스판이 주어진 값에 따라 움직일 수 있게 함
                int minCount = GetMin(i,j,board); // getMin이라는 메서드를 통해 최소값을 구해 대입
                if (result > minCount) result = minCount; //for 문을 돌며 나오는 최소값을 result에 대입
            }
        }
        bw.write(Integer.toString(result) + "\n"); //출력
        bw.flush();
        bw.close();
    }
}