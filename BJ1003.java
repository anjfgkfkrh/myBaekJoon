import java.util.Scanner;

public class Main {
    private int[] list = new int[41];
    private int n;

    public Main() {
        list[1] = 1;
    }

    public void setn(int n) {
        this.n = n;
    }

    public int fastfibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (list[n] != 0) {
            return list[n];
        } else {
            list[n] = fastfibonacci(n - 1) + fastfibonacci(n - 2);
            return list[n];
        }
    }

    public void print() {
        if (n == 0)
            System.out.println(1 + " " + 0);
        else
            System.out.println(list[n - 1] + " " + list[n]);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Main m = new Main();
        int test;
        int n;
        test = scanner.nextInt();
        for (int i = 0; i < test; i++) {
            n = scanner.nextInt();
            m.setn(n);
            m.fastfibonacci(n);
            m.print();
        }
        scanner.close();

    }
}
// 0 1 1 2 3 5 8 13 21 34 55 89 144 233
