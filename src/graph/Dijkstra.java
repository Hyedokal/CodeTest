package graph;

/* 백준 1753(골드 5)
* 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오.
* 단, 모든 간선의 가중치는 10 이하의 자연수이다.
*
* 첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
*  모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다.
*  셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
*  이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다.
*  서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//시작점과 다른 노드간 최단거리 + 양수 가중치 -> 다익스트라
public class Dijkstra {
    static class Node implements Comparable<Node> {
        int v;  //끝점
        int w;  //가중치
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        public int getV(){
            return this.w;
        }
        public int getW(){
            return this.w;
        }

        @Override
        public int compareTo(Node o) {
            if(this.w < o.w){
                return -1;
            } else if(this.w == o.w){
                return 0;
            }
            return 1;
        }
    }

    static int MAX = 999999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int V = Integer.parseInt(str[0]); //정점의 개수
        int E = Integer.parseInt(str[1]); //간선의 개수
        int S = Integer.parseInt(br.readLine()); //시작점 번호
        PriorityQueue<Node> pq = new PriorityQueue<>(); //우선순위 큐
        int[] distance = new int[V+1];
        Arrays.fill(distance, MAX);
        ArrayList<ArrayList<Node>> myList = new ArrayList<>(); //인접 리스트
        for(int i=0; i<V+1; i++){
            myList.add(new ArrayList<>());
        }


        for(int i=0; i<E; i++){
            str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);   //시작점
            int v = Integer.parseInt(str[1]);   //끝점
            int w = Integer.parseInt(str[2]);   //가중치
            myList.get(u).add(new Node(v, w));
        }
        pq.offer(new Node(S, 0));
        distance[S] = 0;

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int dist = node.w;
            int now = node.v;

            if(distance[now] < dist){
                continue;
            }

            for(int i=0; i<myList.get(now).size(); i++){
                int cost = distance[now] + myList.get(now).get(i).getW();

                if(cost<distance[myList.get(now).get(i).getV()]){
                    distance[myList.get(now).get(i).getV()] = cost;
                    pq.offer(new Node(myList.get(now).get(i).getV(), cost));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(distance[i] == MAX){
                System.out.println("INF");
            } else{
                System.out.println(distance[i]);
            }
        }
    }
}

