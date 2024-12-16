package chap03_dataStructure;

import java.io.*;
import java.util.*;

public class P1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        int i = 0;
        int j = N-1;
        while (i < j) { // 투 포인터 이동 원칙에 따라 포인터를 이동하며 처리
            if (A[i] + A[j] < M) {
                i++;
            } else if(A[i] + A[j] > M){
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        bf.close();
    }
}
