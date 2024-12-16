package chap06_greedy;

import java.util.Scanner;

public class P1541_잃어버린괄호 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] str = example.split("-");
        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);
            if (i == 0) {
                answer = answer + temp; // 가장 앞에 있는 값만 더함
            } else {
                answer = answer - temp;
            }
        }
        System.out.println(answer);
    }
    static int mySum(String a) { // 나뉜 그룹의 더하기 연산 수행 함수
        int sum = 0;
        String temp[] = a.split("[+]");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}

