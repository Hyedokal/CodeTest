package dfs;

import java.util.Scanner;

public class BOJ2023 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();    //자리수
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int n, int digit){
        if(isPrime(n) && digit == N){
            System.out.println(n);
        }
        if(isPrime(n)){
            for(int i=1; i<10; i++){
                if(i % 2 == 0){
                    continue;
                }
                DFS(n * 10 + i, digit +1);
            }
        }

    }

    static boolean isPrime(int n){
        for(int i=2; i<= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
