package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {
    static int N;   //정점 개수
    static int M;   //간선 개수
    static int V;   //탐색시작 번호;
    static ArrayList<Integer>[] myList; //인접 리스트;
    static boolean[] visited;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        V = Integer.parseInt(s[2]);
        myList = new ArrayList[N+1];
        visited = new boolean[N+1];
        //인접리스트 초기화
        for(int i=1; i<N+1; i++){
            myList[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            myList[u].add(v);
            myList[v].add(u);
        }
        //myList 정렬
        for(int i=1; i<N+1; i++){
            Collections.sort(myList[i]);
        }
        DFS(V);
        //visited배열 초기화
        for(int i=0; i<visited.length; i++){
            visited[i] = false;
        }
        System.out.println();
        queue = new LinkedList<>();
        visited[V] = true;
        queue.offer(V);
        BFS();
    }
    static void DFS(int node){
        if(visited[node]){
            return;
        }
        System.out.print(node + " ");
        visited[node] = true;
        for(int i : myList[node]){
            DFS(i);
        }
    }
    static void BFS(){
        while(!queue.isEmpty()){
            int idx = queue.poll();
            System.out.print(idx + " ");
            for(int i : myList[idx]){
                if(!visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
