package numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929 {
    static int M;
    static int N;
    static int[] numbers;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N+1];
        isPrime = new boolean[N+1];
        for(int i=0; i<N+1; i++){ //number배열 초기화.
            numbers[i] = i;
        }
        findPrime(N);
    }

    //에라토스테네스의 체 구현.
    static void findPrime(int N){
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i=2; i<=Math.sqrt(N); i++){   //배수들을 지워나간다.
            for(int j=i+i; j<N+1; j+=i){
                if(isPrime[j]){
                    continue;
                } else{
                    isPrime[j] = true;
                }
            }
        }
        for(int k=M; k<N+1; k++){
            if(!isPrime[k]){
                System.out.println(k);
            }
        }
    }
}
