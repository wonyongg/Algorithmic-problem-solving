// 1920 수 찾기

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstInput = br.readLine();    // 첫번째 입력값 N
        int N = Integer.parseInt(firstInput);
        String secondInput = br.readLine();    // 두번째 입력값 N개의 숫자 배열
        String[] arr1 = secondInput.split(" ");
        Integer[] arrN = new Integer[N];
        for (int i = 0; N > i; i++) {
            arrN[i] = Integer.valueOf(arr1[i]);
        }
        Arrays.sort(arrN);    // 정수형 배열로 변경한 후 오름차순 정렬

        String thirdInput = br.readLine();    // 세번째 입력값 M
        int M = Integer.parseInt(thirdInput);
        String fourthInput = br.readLine();    // 네번째 입력값 M 개의 숫자 배열
        String[] arr2 = fourthInput.split(" ");
        Integer[] arrM = new Integer[M];
        for (int i = 0; M > i; i++) {
            arrM[i] = Integer.valueOf(arr2[i]);    // 정수형 배열로 변경
        }

        for (int i = 0; M > i; i++) {    // 두번째 배열의 요소를 돌면서
            System.out.println(binary_Search(arrN, arrM[i]));    // 이진탐색(찾을 대상 배열, 찾을 수)으로 찾음
        }
    }

    public static int binary_Search(Integer[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target) return 1;
            else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            }
        }
        return 0;
    }
}