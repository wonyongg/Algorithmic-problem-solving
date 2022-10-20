//10866 덱
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 입력횟수
        ArrayList<String> list = new ArrayList<>();    // 입력값 임시저장
        ArrayList<Integer> deque = new ArrayList<>();    // 덱


        for (int i = 0; n > i; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; n > i; i++) {
            if (list.get(i).contains("push_front")) {
                push_front(deque, Integer.parseInt(list.get(i).substring(11)));
            }
            else if (list.get(i).contains("push_back")) {
                push_back(deque, Integer.parseInt(list.get(i).substring(10)));
            }
            else {
                if (list.get(i).equals("pop_front")) {
                    System.out.println(pop_front(deque));
                }
                if (list.get(i).equals("pop_back")) {
                    System.out.println(pop_back(deque));
                }
                if (list.get(i).equals("size")) {
                    System.out.println(size(deque));
                }
                if (list.get(i).equals("empty")) {
                    System.out.println(empty(deque));
                }
                if (list.get(i).equals("front")) {
                    System.out.println(front(deque));
                }
                if (list.get(i).equals("back")) {
                    System.out.println(back(deque));
                }
            }
        }
    }

    //덱 메서드
    //push_front
    static void push_front(ArrayList<Integer> deque, int num){
        deque.add(0,num);
    }

    //push_back
    static void push_back(ArrayList<Integer> deque, int num){
        deque.add(num);
    }

    //pop_front
    static int pop_front(ArrayList<Integer> deque){
        if (deque.size() == 0) return -1;
        else {
            return deque.remove(0);
        }
    }

    //pop_back
    static int pop_back(ArrayList<Integer> deque){
        if (deque.size() == 0) return -1;
        else {
            return deque.remove(deque.size()-1);
        }
    }

    //size
    static int size(ArrayList<Integer> deque){
        return deque.size();
    }

    //empty
    static int empty(ArrayList<Integer> deque){
        if (deque.isEmpty()) return 1;
        else return 0;
    }

    //front
    static int front(ArrayList<Integer> deque){
        if (!(deque.isEmpty())) return deque.get(0);
        else return -1;
    }

    //back
    static int back(ArrayList<Integer> deque){
        if (!(deque.isEmpty())) return deque.get(deque.size()-1);
        else return -1;
    }
}