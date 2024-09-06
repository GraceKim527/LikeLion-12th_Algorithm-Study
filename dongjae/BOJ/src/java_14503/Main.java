package java_14503;

import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, r, c, d;
    public static int[][] map;
    public static int count = 1;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(count);
    }

    public static void clean(int x, int y, int dir) {
        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = dx[dir] + x;
            int ny = dy[dir] + y;

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == 0) {
                    count++;
                    clean(nx, ny, dir);
                    return;
                }
            }
        }

        int back = (dir + 2) % 4;
        int bx = dx[back] + x;
        int by = dy[back] + y;

        if (bx >= 0 && by >= 0 && bx < n && by < m) {
            if (map[bx][by] != 1) {
                clean(bx, by, dir);
            }
        }
    }
}