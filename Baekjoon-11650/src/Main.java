// 11650 좌표정렬하기
import java.io.*;

public class Main {
    private static void mergeSort(int[][] arr){ // 2차원 배열을 매개변수로 하는 합병정렬 메서드 생성
        int[][] tmp = new int[arr.length][2]; // tmp라는 임시 저장 배열 생성
        mergeSort(arr, tmp, 0, arr.length-1); // 재귀 호출로 합병정렬 시작
    }
    private static void mergeSort(int[][] arr, int[][] tmp, int startIdx, int endIdx){ // 쪼개기
        if (startIdx < endIdx){
            int midIdx = (startIdx + endIdx) / 2; // 배열을 반으로 나눔
            mergeSort(arr, tmp, startIdx, midIdx); // 재귀 호출로 앞부분 쪼개기
            mergeSort(arr, tmp, midIdx+1, endIdx); // 재귀 호출로 뒷부분 쪼개기
            merge(arr,tmp,startIdx,midIdx,endIdx); // 합병 메서드 호출로 나뉘어진 두 정렬을 하나로 함침
        }
    }
    private static void merge(int[][] arr, int[][] tmp, int startIdx, int midIdx, int endIdx){ // 합병
        for (int i = startIdx; i <= endIdx; i++){
            tmp[i] = arr[i]; // 임시 저장 배열에 옮김
        }
        int part1 = startIdx; // 앞 배열의 시작 인덱스와
        int part2 = midIdx + 1; // 뒤 배열의 시작 인덱스
        int index = startIdx;

        while (part1 <= midIdx && part2 <= endIdx){
            if (tmp[part1][0] < tmp[part2][0]) { // 뒤 배열의 x좌표가 크면
                arr[index] = tmp[part1]; // 오름차순이므로 앞부분 값이 저장
                part1++; // 앞 배열의 다음 x좌표와 비교하기 위해
            }
            else if (tmp[part1][0] == tmp[part2][0]) { // 같은 경우
                if (tmp[part1][1] <= tmp[part2][1]){ // y좌표 값을 비교
                    arr[index] = tmp[part1];
                    part1++; // 앞 배열의 다음 x좌표와 비교하기 위해
                }
                else {
                    arr[index] = tmp[part2];
                    part2++; // 뒤 배열의 다음 x좌표와 비교하기 위해
                }
            }
            else { // 앞 배열의 x좌표가 크면
                arr[index] = tmp[part2]; // 오름차순이므로 뒷부분 값이 저장
                part2++; // 뒤 배열의 다음 x좌표와 비교하기 위해
            }
            index++; // 인덱스값을 더하여 다음 인덱스값에 넣을 준비
        }
        for (int i = 0; i <= midIdx - part1; i++){
            arr[index + i] = tmp[part1 + i];
            // 만약 앞 배열이 남으면, 원본 배열에 붙임(원본 배열 값 변경)
            // 뒤 배열이 남는 경우는 원본 배열과 같으므로 신경 안써도됨
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String firstInput = br.readLine(); // 좌표 개수 입력받기
        int num = Integer.parseInt(firstInput);
        int[][] coordinate = new int[num][2]; // 좌표 배열 생성
        for (int i = 0; num > i; i++){ // 좌표 입력받기
            String secondInput = br.readLine();
            String[] str = secondInput.split(" ");
            coordinate[i][0] = Integer.parseInt(str[0]);
            coordinate[i][1] = Integer.parseInt(str[1]);
        }

        mergeSort(coordinate); // 합병정렬로 정렬

        for (int i = 0; num > i; i++){
            bw.write(coordinate[i][0] + " " + coordinate[i][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}