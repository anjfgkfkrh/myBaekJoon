import java.util.Scanner;

public class Main {

  public static void search(int[][] map, int[][] mapx, int x, int y, int p) {
    if ((map[x][y] == 0) || (mapx[x][y] != 0))
      return;
    else {
      mapx[x][y] = p;
      if (x != map.length - 1)
        search(map, mapx, x + 1, y, p);
      if (x != 0)
        search(map, mapx, x - 1, y, p);
      if (y != map[0].length - 1)
        search(map, mapx, x, y + 1, p);
      if (y != 0)
        search(map, mapx, x, y - 1, p);
      return;
    }
  }

  public static void main(String[] arg) {
    Scanner scanner = new Scanner(System.in);
    int test = scanner.nextInt();
    for (int t = 0; t < test; t++) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      int n = scanner.nextInt();
      int a = 0, b = 0;
      int p = 1;
      int[][] map = new int[x][y];
      int[][] mapx = new int[x][y];
      for (int m = 0; m < n; m++) {
        a = scanner.nextInt();
        b = scanner.nextInt();
        map[a][b] = 1;
      }
      for (int j = 0; j < y; j++) {
        for (int i = 0; i < x; i++) {
          if ((map[i][j] == 1) && (mapx[i][j] == 0)) {
            search(map, mapx, i, j, p);
            p++;
          }
        }
      }

      System.out.println("정답 " + (p - 1));

    }

    scanner.close();
  }
}