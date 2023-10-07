package graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class BOJ1516 {
    static int N;
    static boolean[] visited;

    static ArrayList<Node>[] myList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        myList = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){ //인접리스트 생성
            myList[i] = new ArrayList<>();
        }
        for(int i=1; i<N+1; i++){ //인접리스트 초기화
            int max= 0;
            String[] info = br.readLine().split(" ");
            for(int k=1; k<info.length; k++){
                max = Math.max(max, Integer.parseInt(info[k])); //가장 큰 노드번호
            }
            myList[max].add(new Node(i, Integer.parseInt(info[0])));
        }

        DFS(0, 0, new Node(0));


    }

    static void DFS(int vertex, int time, Node node){
        if(vertex == node.getVertex(node) && node.getVertex(node) != 0){
            System.out.println(time);
        }
        if(!visited[vertex]){
            visited[vertex] = true;
            for(Node n : myList[vertex]){
                DFS(n.getVertex(n), time + n.getTime(n), n);
            }
            visited[vertex] = false;
        }
    }
    static class Node{
        int vertex; //노드 번호
        int time; // 걸리는 시간
        Node(){

        }
        Node(int vertex) {
            this.vertex = vertex;
        }
        Node(int vertex, int time){
            this.vertex = vertex;
            this.time = time;
        }
        int getTime(Node node){
            return node.time;
        }
        int getVertex(Node node){
            return node.vertex;
        }
    }
}
