package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*  백준 1238 (골드 3)
* N개의 숫자로 구분된 각각의 마을에 한 명의 학생이 살고 있다.
* 어느 날 이 N명의 학생이 X  파티를 벌이기로 했(1 ≤ X ≤ N)번 마을에 모여서 파티를 벌이기로 했다.
* 이 마을 사이에는 총 M개의 단방향 도로들이 있고 i번째 길을 지나는데 Ti(1 ≤ Ti ≤ 100)의 시간을 소비한다.
* 각각의 학생들은 파티에 참석하기 위해 걸어가서 다시 그들의 마을로 돌아와야 한다.
* 하지만 이 학생들은 워낙 게을러서 최단 시간에 오고 가기를 원한다.
* 이 도로들은 단방향이기 때문에 아마 그들이 오고 가는 길이 다를지도 모른다.
* N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생은 누구일지 구하여라.
*/

//너무 어려운데요...
public class Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);   //학생 수(노드 수)
        int M = Integer.parseInt(s[1]);   //도로 수(에지 수)
        int X = Integer.parseInt(s[2]);   //끝 노드 번호
        ArrayList<Edge>[] graph = new ArrayList[N+1]; //인접 리스트
        boolean[] visited = new boolean[N+1]; //방문 배열

        //인접 리스트 초기화
        for(int i=0; i<M; i++){
            String[] edge = br.readLine().split(" ");
            int start = Integer.parseInt(edge[0]); //시작점
            int end = Integer.parseInt(edge[1]); //끝점
            int value = Integer.parseInt(edge[2]); //가중치
            graph[start].add(new Edge(end, value));
        }

        //X를 시작점으로 하여 각 마을까지 걸리는 최단 거리 배열 만들기.
        int[] answer = new int[N+1];      //최단 거리 배열
        for(int i=1; i<answer.length; i++){    //최단 거리 배열 초기화
            if(i != X){     //시작점으로 고치기.
                answer[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Edge> queue = new LinkedList();
        //queue.offer(graph[X].)
        //최단 거리 배열 업데이트하기. (모든 노드를 방문할 때까지)
        //while(!queue.isEmpty())

    }


}

class Edge{
    int endpoint;
    int value;
    public Edge(int endpoint, int value){
        this.endpoint = endpoint;
        this.value = value;
    }
}
