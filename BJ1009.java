import java.util.Scanner;

public class Main {

  public static void main(String[] arg) {
    int test;
    Scanner scanner = new Scanner(System.in);
    test = scanner.nextInt();

    for (int i = 0; i < test; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      if (b == 0) {
        System.out.println(1);
        continue;
      }
      a = a % 10;
      if (a == 0) {
        System.out.println(10);
        continue;
      }
      b = b % 4;
      if (b == 0)
        b = 4;
      System.out.println((int) Math.pow(a, b) % 10);
    }
    scanner.close();

  }
}
// 1 1..
// 2 2 4 8 6 / 2 4 8 6 / 2 4
// 3 3 9 7 1 / 3 9 7 1 /
// 4 4 6 / 4 6
// 5 5..
// 6 6..
// 7 7 9 3 1 /
// 8 8 4 2 6 / 8
// 9 9 1 /
