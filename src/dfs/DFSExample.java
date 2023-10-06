package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFSExample {
    static int N;
    static int M;
    static boolean[] visited; //노드의 중복 방문 방지
    static ArrayList<Integer>[] myList; //인접 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        visited = new boolean[N+1];
        visited[0] = true;

        myList = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            myList[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            StringTokenizer s = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(s.nextToken());
            int v = Integer.parseInt(s.nextToken());  //에지의 양 끝점
            myList[u].add(v);
            myList[v].add(u);
        }

        int count = 0;
        for(int k=1; k<N+1; k++){
            if(!visited[k]){
                count++;
                DFS(k);
            }
        }
        System.out.print(count);
    }

    //재귀함수로 구현한 DFS 알고리즘.
    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : myList[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
