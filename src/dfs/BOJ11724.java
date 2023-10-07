package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int N; //정점 개수
    static int M; //간선 개수
    static ArrayList<Integer>[] myList; //인접 리스트
    static boolean[] visited;
    static int count; //연결 요소 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        //인접리스트 초기화
        myList = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            myList[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            myList[u].add(v);
            myList[v].add(u);
        }
        count = 0;
        for(int i=1; i<N+1; i++){
            if(!visited[i]){count++;}
            DFS(i);
        }
        System.out.print(count);
    }
    static void DFS(int node){
        visited[node] = true;
        for(int i : myList[node]){
            DFS(i);
        }
    }
}
