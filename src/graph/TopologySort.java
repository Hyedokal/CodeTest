package graph;

/* 백준 2252(골드 2)
*
* N명의 학생들을 키 순서대로 줄을 세우려고 한다. 각 학생의 키를 직접 재서 정렬하면 간단하겠지만,
* 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 하였다.
* 그나마도 모든 학생들을 다 비교해 본 것이 아니고, 일부 학생들의 키만을 비교해 보았다.
* 일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오.
*/

import java.util.*;

public class TopologySort {
    //학생들을 노드로 생각하고, 키 순서 비교 데이터로 에지를 만든다고 생각하자.
    //전제조건 '답이 여러 개이면 아무 것이나 출력해도 된다' <- 유일성을 보장하지 않는 위상정렬의 전제와 같다.

    //1. 인접 리스트에 노드 데이터를 저장하고, 진입차수 배열값을 업데이트한다.
    //2. 위상 정렬을 수행한다. (진입차수가 0인 노드를 큐에 저장하고, poll하며 해당 노드가 가리키는 노드의 진입차수--.
                        // 감소했을 때 진입차수가 0이 되는 노드를 큐에 offer. 큐가 빌 때까지 반복.)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //학생 수
        int M = sc.nextInt(); //키를 비교한 횟수
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(); //인접 리스트 생성.
        for(int i=0; i<=N; i++){
            A.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[N+1];  //진입차수 배열 생성.
        for(int i=0; i<M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A.get(S).add(E);
            indegree[E]++;          //진입차수 배열에 데이터 저장.
        }

        //위상정렬 실행.
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i]==0){ //i의 진입차수가 0이라면...
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for(int next : A.get(now)){
                indegree[next]--;
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
        }
    }
}
