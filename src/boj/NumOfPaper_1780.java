package boj;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumOfPaper_1780 {
    static int[][] m;
    static int[] check;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, row, col, dist, i, j;

        N = Integer.parseInt(st.nextToken());
        m = new int[N][N];
        check = new int[3];
        Arrays.fill(check, 0);

        for (row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (col = 0; col < N; col++) {
                m[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);
        System.out.println(check[0] + " " + check[1] + " " + check[2]);

    }

    /*
     * params
     *   dist: 한 변의 길이
     * */
    private static void solve(int row, int col, int dist) {
        int pivot = m[row][col];
        boolean allSame = true;

        for (int y = row; y < row + dist && allSame; y++) {
            for (int x = col; x < col + dist && allSame; x++) {
                if (pivot != m[y][x]) {
                    allSame = false;
                }
            }
        }

        if (!allSame) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    solve (row + dist / 3 * i, col + dist / 3 * j, dist / 3) ;
                }
            }
        } else {
            check[pivot + 1] += 1;
        }
    }

}
