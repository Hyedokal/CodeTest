package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 1260
public class DFSandBFS {
    static int N;
    static int M;
    static int V;
    static ArrayList<Integer>[] myList;
    static boolean[] visited;
    static Queue<Integer> queue;
    static ArrayList<Integer> dfsAnswer;
    static ArrayList<Integer> bfsAnswer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //노드 수
        M = Integer.parseInt(st.nextToken());   //에지 수
        V = Integer.parseInt(st.nextToken());   //시작 노드 번호
        myList = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            myList[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        dfsAnswer = new ArrayList<>();

        bfsAnswer = new ArrayList<>();
        //인접리스트 초기화
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            myList[start].add(end);
            myList[end].add(start);
        }
        for(int i=0; i<N+1; i++){
            Collections.sort(myList[i]);
        }
        DFS(V);
        for(int i : dfsAnswer){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i=0; i<N+1; i++){visited[i] = false;}


        BFS();
        for(int i : bfsAnswer){
            System.out.print(i + " ");
        }
    }
    static void DFS(int start){
        visited[start] = true;
        dfsAnswer.add(start);
        for(int i : myList[start]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
    static void BFS(){
        queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            bfsAnswer.add(poll);
            for(int i : myList[poll]){
                if(!visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
