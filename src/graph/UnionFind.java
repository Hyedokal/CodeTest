package graph;

/* 백준 1717 (골드 4)
* 초기에
* n+1개의 집합 {0}, {1}, {2}, ... , {n}이 있다. 여기에 합집합 연산과,
* 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
* 집합을 표현하는 프로그램을 작성하시오.
*/

import java.util.Scanner;

public class UnionFind {
    //최대 원소 개수 1,000,000개, 질의 개수 100,000로 큰 편 -> 전형적인 Union-Find 문제.
    //주의: find연산 수행 시 재귀함수에서 나오면서 탐색한 모든 노드의 대표 노드 값을 이번 연산에서 발견한 대표
    //      노드로 변경하는 부분을 신경 써서 코딩하자.
    static int[] parent; //대표 노드를 저장할 배열.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        //대표 노드를 저장하는 배열.
        int[] parent = new int[N+1];
        for(int i=0; i<N+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<M; i++) { //질의 계산하는 부분
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (question == 0) { //합집합 연산
                union(a, b);
            } else {
                boolean result = checkSame(a, b);
                if(result) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    private static void union(int a, int b){
        // 대표노드 찾아서 연결하기
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;  //두 개 연결.
        }
    }

    private static int find(int a){
        if(a == parent[a]){ //a의 대표 노드가 a이면..
            return a;
        } else{
                //경로 압축.
            return parent[a] = find(parent[a]); //value를 index로 바꿔서 또 찾아보기.
        }
    }

    private static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return true;
        return false;
    }
}
