import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//원의 교점
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트케이스 개수
        int[] position = new int[6];
        int[] answer = new int[T];
        for(int i=0; i<T; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<6; j++){
                position[j] = Integer.parseInt(s[j]);   //좌표배열 초기화
            }
            int x1 = position[0];
            int y1 = position[1];
            int x2 = position[3];
            int y2 = position[4];
            int r1 = position[2];
            int r2 = position[5];
            if(x1 == x2 && y1 == y2){
                if(r1 == r2) answer[i] = -1;
                else answer[i] = 0;
            }else{
                //두 사람 사이 거리
                double distance = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
                if(distance > r1+r2) answer[i] = 0;
                else if(distance == r1+r2) answer[i] = 1;
                else answer[i] = 2;
            }
        }

        for(int k =0; k< answer.length-1; k++){
            System.out.println(answer[k]);
        }
        System.out.print(answer[T-1]);
    }
}