package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//백준 13023
public class FiveFriends {
    static int N;   //노드 개수
    static int M;   //에지 개수
    static ArrayList<Integer>[] myList;
    static boolean[] visited;
    static boolean hasFive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        myList = new ArrayList[N];
        visited = new boolean[N];
        hasFive = false;
        for(int i=0; i<N; i++){ //인접리스트 초기화
            myList[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            myList[u].add(v);
            myList[v].add(u);
        }
        for(int k=0; k<N; k++){
            DFS(k, 1);
            if(hasFive) break;
        }
        System.out.println(hasFive? 1 : 0);

    }

    static void DFS(int num, int count){
        if(count == 5 || hasFive){
            hasFive = true;
            return;
        }
        visited[num] = true;
        for(int i : myList[num]){
            if(!visited[i]){
                DFS(i, count+1);
            }
        }
        visited[num] = false;
    }
}
