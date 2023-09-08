import java.util.Scanner;

public class BJ1004 {
  private int x, y;
  private int dx, dy;
  private int pn;
  private int[] px, py, pr;
  private int[] a;

  public BJ1004(Scanner scanner) {
    x = scanner.nextInt();
    y = scanner.nextInt();
    dx = scanner.nextInt();
    dy = scanner.nextInt();
    pn = scanner.nextInt();
    px = new int[pn];
    py = new int[pn];
    pr = new int[pn];
    a = new int[pn];
    for (int n = 0; n < pn; n++) {
      px[n] = scanner.nextInt();
      py[n] = scanner.nextInt();
      pr[n] = scanner.nextInt();
    }
  }

  public void calc() {
    for (int i = 0; i < pn; i++) {
      double dis = Math.sqrt((double) ((x - px[i]) * (x - px[i]) + (y - py[i]) * (y - py[i])));
      if (dis < pr[i])
        a[i] = (a[i] + 1) % 2;
      dis = Math.sqrt((double) ((dx - px[i]) * (dx - px[i]) + (dy - py[i]) * (dy - py[i])));
      if (dis < pr[i])
        a[i] = (a[i] + 1) % 2;
    }
  }

  public void print() {
    int num = 0;
    for (int n = 0; n < pn; n++) {
      if (a[n] == 1) {
        num++;
      }
    }
    System.out.println(num);
  }

  public static void main(String[] arg) {
    int test;
    Scanner scanner = new Scanner(System.in);
    test = scanner.nextInt();
    for (int i = 0; i < test; i++) {
      BJ1004 m = new BJ1004(scanner);
      m.calc();
      m.print();
    }

    scanner.close();

  }
}
