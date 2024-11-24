package greedy_06;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1744_수묶기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 카드 묶음의 수 저장하기
        //양수는 내림차순 정렬하기
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) { // 4개의 그룹으로 분리해 저장하기
            int data = sc.nextInt();
            if (data > 1) {
                plusPq.add(data);
            } else if (data == 1) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minusPq.add(data);
            }
        }
        int sum = 0;
        // 양수 처리하기
        while(plusPq.size() > 1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum = sum + first * second;
        }
        if(!plusPq.isEmpty()) {
            sum = sum + plusPq.remove();
        }
        // 음수 처리하기
        while(minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum = sum + first * second;
        }
        if(!minusPq.isEmpty()) {
            if (zero == 0) {
                sum = sum + minusPq.remove();
            }
        }
        // 1 처리하기
        sum = sum + one;
        System.out.println(sum);
    }
}

