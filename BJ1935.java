import java.util.Scanner;
import java.util.Stack;

public class BJ1935 {
  public static void main(String[] args) {
    Stack<Double> stack = new Stack<>();
    Scanner scanner = new Scanner(System.in);

    int num;
    double a, b;
    num = scanner.nextInt();
    scanner.nextLine();

    String exp;
    exp = scanner.nextLine();
    char c;

    double[] n = new double[num];
    for (int i = 0; i < num; i++) {
      n[i] = scanner.nextDouble();
    }

    for (int i = 0; i < exp.length(); i++) {
      c = exp.charAt(i);
      switch (c) {
        case '+':
          b = stack.pop();
          a = stack.pop();
          stack.add(a + b);
          break;
        case '-':
          b = stack.pop();
          a = stack.pop();
          stack.add(a - b);
          break;
        case '*':
          b = stack.pop();
          a = stack.pop();
          stack.add(a * b);
          break;
        case '/':
          b = stack.pop();
          a = stack.pop();
          stack.add(a / b);
          break;
        default:
          stack.add(n[c - 'A']);
          break;
      }
    }
    double p = (double) ((long) (stack.pop() * 100)) / 100;
    System.out.printf("%.2f\n", p);
    scanner.close();
  }
}
