package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BnSearch {
    static int N;
    static int M;
    static int[] target;
    static int[] toFind;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        target = new int[N];
        for(int i=0; i<N; i++){
            target[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(target);// 주어진 수열 정렬
        M = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");
        toFind = new int[M];
        for(int i=0; i<M; i++){
            toFind[i] = Integer.parseInt(s2[i]);
        }
        for(int i=0; i<M; i++){
            FIND(toFind[i]);
        }
    }

    //이진탐색 메서드
    static void FIND(int num){
        int sIdx = 0;
        int eIdx = target.length-1;
        while(sIdx <= eIdx){
            int mIdx = (sIdx + eIdx) / 2;
            int mValue = target[mIdx];
            if(mValue == num || target[sIdx] == num || target[eIdx] == num){
                System.out.println(1);
                return;
            } else if(mValue > num){
                eIdx = mIdx -1;
            } else{
                sIdx = mIdx+1;
            }
        }
        System.out.println(0);
    }
}
