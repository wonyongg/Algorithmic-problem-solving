//10845 큐
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 입력횟수
        ArrayList<String> list = new ArrayList<>();    // 입력값 임시 저장
        ArrayList<Integer> que = new ArrayList<>();    // 큐


        for (int i = 0; n > i; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; n > i; i++) {
            if (list.get(i).contains(" ")) {
                push(que, Integer.parseInt(list.get(i).substring(5)));
            }
            else {
                if (list.get(i).equals("pop")) {
                    System.out.println(pop(que));
                }
                if (list.get(i).equals("size")) {
                    System.out.println(size(que));
                }
                if (list.get(i).equals("empty")) {
                    System.out.println(empty(que));
                }
                if (list.get(i).equals("front")) {
                    System.out.println(front(que));
                }
                if (list.get(i).equals("back")) {
                    System.out.println(back(que));
                }
            }
        }
    }

    // 큐 메서드
    //push
    static void push(ArrayList<Integer> que, int num){
        que.add(num);
    }

    //pop
    static int pop(ArrayList<Integer> que){
        if (que.size() == 0) return -1;
        else {
            return que.remove(0);
        }
    }

    //size
    static int size(ArrayList<Integer> que){
        return que.size();
    }

    //empty
    static int empty(ArrayList<Integer> que){
        if (que.isEmpty()) return 1;
        else return 0;
    }

    //front
    static int front(ArrayList<Integer> que){
        if (!(que.isEmpty())) return que.get(0);
        else return -1;
    }

    //back
    static int back(ArrayList<Integer> que){
        if (!(que.isEmpty())) return que.get(que.size()-1);
        else return -1;
    }
}