package search_05;

import java.util.ArrayList;
import java.util.Scanner;

public class P1300_K번째수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long start = 1, end = K;
        long ans = 0;
        // 이진 탐색 수행하기
        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;
            // 중앙값보다 작은 수는 몇 개인지 계산하기
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(middle/i, N); // 작은 수를 카운트하는 핵심 로직
            }
            if (cnt < K) {
                start = middle + 1;
            } else {
                ans = middle; // 현재 단계의 중앙값을 정답 변수에 저장하기
                end = middle - 1;
            }
        }
        System.out.println(ans);
    }
}

