import java.util.Scanner;
//1013
//(100+1+ | 01)+

public class Main {

  public static boolean analysis1(String radio, int p, int s) {
    if ((p >= radio.length()) || ((radio.charAt(p) != '0') && (radio.charAt(p) != '1'))) {
      if ((s == 4) || (s == 3))
        return true;
      else
        return false;
    }
    switch (s) {
      case 0:
        if (radio.charAt(p) == '0')
          return analysis1(radio, p + 1, s + 1);
        else
          return false;
      case 1:
        if (radio.charAt(p) == '0')
          return analysis1(radio, p + 1, s + 1);
        else
          return false;
      case 2:
        if (radio.charAt(p) == '1')
          return analysis1(radio, p + 1, s + 1);
        else
          return analysis1(radio, p + 1, s);
      case 3:
        if (radio.charAt(p) == '1')
          return analysis1(radio, p + 1, s + 1);
        else {
          if ((p + 1 < radio.length()) && (radio.charAt(p + 1) == '1')) // 100101
            return analysis0(radio, p + 1);
          else
            return false;
        }
      case 4:
        if (radio.charAt(p) == '1')
          return analysis1(radio, p + 1, s);
        else {
          if ((p + 1 < radio.length()) && (radio.charAt(p + 1) == '0'))// 10011001
            return analysis1(radio, p + 2, 2);
          else if ((p + 1 < radio.length()) && (radio.charAt(p + 1) == '1')) // 1001101
            return analysis0(radio, p + 1);
          else if (p >= radio.length())
            return true;
          else
            return false;
        }
      default:
        throw new IllegalArgumentException("Invalid value for s: " + s);
    }
  }

  public static boolean analysis0(String radio, int p) {
    if ((p >= radio.length()) || ((radio.charAt(p) != '0') && (radio.charAt(p) != '1')))
      return false;
    if (radio.charAt(p) == '1') {
      if (p + 1 >= radio.length())
        return true;
      if ((p + 1 < radio.length()) && (radio.charAt(p + 1) == '1'))
        return analysis1(radio, p + 2, 0);
      else
        return analysis0(radio, p + 2);
    } else
      return false;
  }

  public static void main(String[] arg) {
    Scanner scanner = new Scanner(System.in);
    int test = scanner.nextInt();
    scanner.nextLine();
    boolean result;
    for (int t = 0; t < test; t++) {
      String radio = scanner.nextLine();
      if (radio.charAt(0) == '0')
        result = analysis0(radio, 1);
      else
        result = analysis1(radio, 1, 0);

      if (result)
        System.out.println("YES");
      else
        System.out.println("NO");
    }

    scanner.close();
  }
}