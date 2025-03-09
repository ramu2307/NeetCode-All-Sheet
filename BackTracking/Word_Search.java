package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Word_Search {
    
    private static int[][] directions = {{ -1, 0} , {1, 0}, {0, 1}, {0, -1}};

    private static boolean search(int i, int j, int n, int m, String word, int idx, char[][] board, boolean[][] visited) {

        if(idx == word.length()) {
            return true;
        }

        if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }
      
        visited[i][j] = true;
        boolean ans = false;

        for(int[] dir : directions) {
            int nRow = i + dir[0];
            int nCol = j + dir[1];

            ans = ans || search(nRow, nCol, n, m, word, idx + 1, board, visited);

        }

        visited[i][j] = false;

        return ans;
    }

    public static boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(search(i, j, n, m, word, 0, board, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        String word = br.readLine();
        boolean ans = exist(board, word);
        System.out.println(ans ? "YES" : "NO");
    }
}
