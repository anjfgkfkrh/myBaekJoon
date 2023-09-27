import java.util.Scanner;

public class BJ1005 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    int[] p = new int[num];
    int[] n = new int[num];
    int[] c = new int[num];
    int d;

    for (int i = 0; i < num; i++) {
      p[i] = scanner.nextInt();
      n[i] = p[i];
    }
    for (int i = 0; i < num; i++) {
      for (int j = 0; j < num - i - 1; j++) {
        if (n[j] > n[j + 1]) {
          d = n[j + 1];
          n[j + 1] = n[j];
          n[j] = d;
        }
      }
    }
    for (int i = 0; i < num; i++) {
      for (int j = 0; j < num; j++) {
        if ((p[i] == n[j]) && (c[j] == 0)) {
          System.out.print(j + " ");
          c[j] = 1;
          break;
        }
      }
    }
    System.out.println();

    scanner.close();
  }
}

// 되긴 하는데.. 시간이 걸림...
// 싸게싸게 되는 알고리즘이 뭘까?
// 그러니까.. 수열을 주면, 그 수열 순서대로 작은순서대로 기록해서 수열로 만들라는 거잖아
// output이 순서를 기록한 배열인 거지
// 그럼 들어왔을때 순서를 판단해야되
// 순서를 판단하는 방법은,
// 1. 이미 들어온 수 중 나보다 큰게 나올때 까지 반복문으로 비교하여 오름차순으로 정렬한다.
// 2.