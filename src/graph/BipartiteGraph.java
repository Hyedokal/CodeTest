package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*이분 그래프 판별하기 (백준 1707)
 그래프의 정점의 집합을 둘로 분할하여,
 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때,
 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
 그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.
*/
public class BipartiteGraph {
    //트리는 항상 이분그래프이나, 사이클이 발생하면 이분 그래프가 불가능함.
    //즉 기존의 탐색 메커니즘에서 탐색한 노드에 다시 접근하게 됐을 때 현재 노드의 집합과 같으면 이분그래프 불가능.
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++){ //주어진 테스트 케이스만큼 돌린다.
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V+1]; //0번째 인덱스를 사용하지 않기 위함.
            visited = new boolean[V+1];
            check = new int[V+1];
            IsEven = true;
            for(int i=1; i<=V; i++){
                A[i] = new ArrayList<Integer>();
            }
            //에지 데이터 저장
            for(int i=0; i<E; i++){
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);  //방향이 없으므로 반대로 가는 것도 저장.
            }
            //모든 노드에서 DFS 실행
            for(int i=1; i<=V; i++){
                if(IsEven){
                    DFS(i);
                } else{
                    break;
                }
            }
            if(IsEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static void DFS(int start){
        visited[start] = true;
        for(int i : A[start]){ // 인접리스트로 받아서 start에서 연결된 모든 노드를 탐색.
            if(!visited[i]){
                // 직전 노드와 다른 집합으로 분류해주기.
                check[i] = (check[start]+1) % 2 ; //0과 1로만 표시하기 위함.
                DFS(i);
            } else if(check[start] == check[i]){
                IsEven = false;
            }
        }
    }
}
