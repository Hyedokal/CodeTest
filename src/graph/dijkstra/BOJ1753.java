package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1753 {
    static int V;   //정점 개수
    static int E;   //간선 개수
    static int K;   //시작 노드 번호
    static boolean[] visited; //방문여부
    static int[] answer; //정답배열
    static ArrayList<Node>[] myList; //에지 리스트
    static Queue<Integer> queue;
    static int MAX = 999999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        answer = new int[V+1];
        visited = new boolean[V+1];
        //정답배열 초기화
        for(int i=1; i<V+1; i++){
            if(i != K){
                answer[i] = MAX;
            }
        }
        //인접리스트 초기화
        myList = new ArrayList[V+1];
        for(int i=1; i<V+1; i++){
            myList[i] = new ArrayList<Node>();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            myList[u].add(new Node(v, w));
            //myList[v].add(new Node(u, w));
        }
        queue = new LinkedList<>();
        queue.offer(K);
        dijkstra();
        for(int i=1; i<V+1; i++){
            if(answer[i] == MAX){
                System.out.println("INF");
            } else{
                System.out.println(answer[i]);
            }

        }
    }

    static void dijkstra(){
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            visited[vertex] = true;
            for(Node node : myList[vertex]) {
                if(!visited[node.getVertex()]){
                    queue.add(node.getVertex());
                    visited[node.getVertex()] = true;
                    answer[node.getVertex()] = Math.min(answer[vertex]+node.getValue(), answer[node.getVertex()]);
                }
            }
        }
    }
    static class Node{
        int vertex;
        int value;
        Node(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }
        public int getValue(){
            return this.value;
        }
        public int getVertex(){
            return this.vertex;
        }
    }
}
