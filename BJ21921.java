import java.util.Scanner;

public class BJ21921 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int days = scanner.nextInt(); // 방문일 수
    int num = scanner.nextInt(); // 계산할 방문 일수
    int[] visits = new int[days]; // 일일 방문 수 저장 배열
    int[] sumVisits = new int[days]; // 누접합 저장 배열

    for (int i = 0; i < days; i++) { // 방문수 입력과 동시에 저장 및 누적합 계산,저장
      visits[i] = scanner.nextInt();
      if (i == 0) { // 처음 입력시 계산x
        sumVisits[0] = visits[0];
        continue;
      }
      sumVisits[i] = sumVisits[i - 1] + visits[i]; // 누접합 배열에 저장
    }
    int numcal = days - (num - 1); //
    int max = sumVisits[num - 1]; // 최대값
    int same = 1; // 중복 일 개수
    int a;
    for (int i = 1; i < numcal; i++) {
      a = sumVisits[num + i - 1] - sumVisits[i - 1];
      if (a > max) {
        max = a;
        same = 1;
      } else if (a == max)
        same++;
    }
    if (max == 0)
      System.out.println("SAD");
    else {
      System.out.println(max);
      System.out.println(same);
    }

    scanner.close();
  }

}
