//10828 스텍
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 입력횟수
        ArrayList<String> list = new ArrayList<>();    // 입력값 임시 저장
        ArrayList<Integer> stack = new ArrayList<>();    // 스택

        // 입력값 list에 임시 저장
        for (int i = 0; n > i; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; n > i; i++) {
            if (list.get(i).contains(" ")) {
                push(stack, Integer.parseInt(list.get(i).substring(5)));
            } else {
                if (list.get(i).equals("pop")) {
                    System.out.println(pop(stack));
                }
                if (list.get(i).equals("size")) {
                    System.out.println(size(stack));
                }
                if (list.get(i).equals("empty")) {
                    System.out.println(empty(stack));
                }
                if (list.get(i).equals("top")) {
                    System.out.println(top(stack));
                }
            }
        }
    }

    //스택 메서드
    //push
    static void push(ArrayList<Integer> stack, int num){
        stack.add(num);
    }

    //pop
    static int pop(ArrayList<Integer> stack){
        if (stack.size() == 0) return -1;
        else {
            return stack.remove(stack.size()-1);
        }
    }

    //size
    static int size(ArrayList<Integer> stack){
        return stack.size();
    }

   //empty
    static int empty(ArrayList<Integer> stack){
        if (stack.isEmpty()) return 1;
        else return 0;
    }

    //top
    static int top(ArrayList<Integer> stack){
        if (!(stack.isEmpty())) return stack.get(stack.size()-1);
        else return -1;
    }
}