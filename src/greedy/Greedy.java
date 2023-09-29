package greedy;

import java.util.Scanner;

/*
* 준규가 소유한 동전은 총 N종류이고, 각 동전의 개수가 많다.
* 동전을 적절히 사용해 그 가격을 K로 만들려고 한다.
* 이에 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하라.
* 난이도: 실버 4
*/
public class Greedy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        // 그리디 알고리즘 -> 최대한 큰 동전 먼저 사용하기
        int count = 0;
        for(int i=N-1; i>=0; i--){
            if(A[i] <= K){
                count += (K/A[i]);
                K %= A[i];
            }
        }
        System.out.println(count);
    }

}
