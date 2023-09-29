package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

/*
*   N개의 정수가 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램 작성.
*   난이도: 실버 5
*/
public class BinarySearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i<N; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        for(int i=0; i<M; i++){
            boolean find = false;
            int target = sc.nextInt();

            int start = 0;          //시작 인덱스
            int end = A.length-1;   //끝 인덱스

            while(start <= end){
                int mid_index = (start+end)/2; //중앙 인덱스
                int mid_value = A[mid_index];   //중앙값
                if(mid_value > target){         //중앙값이 찾는 값보다 작으면..
                    // 끝 인덱스를 중앙 인덱스 이전 인덱스로 설정.(즉 오른쪽 값은 다 버린다는 의미)
                    end = mid_index -1;
                } else if (mid_value < target) {//중앙값이 찾는 값보다 크면..
                    // 시작 인덱스를 중앙 인덱스 이후 인덱스로 설정.(즉 왼쪽 값은 다 버린다는 의미)
                    start = mid_index +1;
                } else{
                    find = true;
                    break;
                }
            }
            if(find){ System.out.println(1);}
                else{ System.out.println(0);}
        }
    }
}
