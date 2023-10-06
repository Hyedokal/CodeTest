package dfs;

//백준 2023
/*
* 수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 가지고 노는 것이다. 요즘 수빈이가 가장 관심있어 하는 소수는 7331이다.
* 7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다. 즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다!
* 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.
* 수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.
*/

import java.util.Scanner;

public class FindPrime {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   //자리수
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    //수를 이어붙이는 함수
    static void DFS(int num, int digit){
        if(digit == N){
            if(isPrime(num)){
                System.out.println(num);
            }
            return;
        } else{
            for(int i=1; i<10; i++){
                if(i%2 == 0){continue;} //짝수라면 탐색할 필요 없음.
                if(isPrime(num * 10 + i)){ //소수이면 자리수 하나를 더 늘림.
                    DFS(num*10+i, digit +1);
                }
            }
        }
    }

    static boolean isPrime(int n){
        for(int i=2; i<=n/2; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
