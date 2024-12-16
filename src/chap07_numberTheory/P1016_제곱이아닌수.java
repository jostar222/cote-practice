package chap07_numberTheory;

import java.util.Scanner;

public class P1016_제곱이아닌수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();
        // 최댓값과 최솟값의 차이만큼 배열 선언하기
        boolean[] Check = new boolean[(int) (Max - Min + 1)];
        // 2의 제곱수인 4부터 Max보다 작거나 같은 값까지 반복하기
        for (long i = 2; i * i <= Max; i++) {
            long pow = i * i; // 제곱수
            long start_index = Min / pow;
            if (Min % pow != 0) {
                start_index++; // 나머지가 있으면 1을 더해야 Min보다 큰 제곱수에서 시작됨
            }
            for (long j = start_index; pow * j <= Max; j++) { // 제곱수를 true로 변경하기
                Check[(int) ((j * pow) - Min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i <= Max - Min; i++) {
            if (!Check[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
