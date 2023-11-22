import java.util.Scanner;

public class Main {

   static void front(int n, int[][] tree) {
      System.out.printf("%c", n + 'A');
      if (tree[n][0] != '.' - 'A')
         front(tree[n][0], tree);
      if (tree[n][1] != '.' - 'A')
         front(tree[n][1], tree);
   }

   static void middle(int n, int[][] tree) {
      if (tree[n][0] != '.' - 'A')
         middle(tree[n][0], tree);
      System.out.printf("%c", n + 'A');
      if (tree[n][1] != '.' - 'A')
         middle(tree[n][1], tree);
   }

   static void back(int n, int[][] tree) {
      if (tree[n][0] != '.' - 'A')
         back(tree[n][0], tree);
      if (tree[n][1] != '.' - 'A')
         back(tree[n][1], tree);
      System.out.printf("%c", n + 'A');
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int nodeNum = scanner.nextInt();
      scanner.nextLine();

      int[][] tree = new int[nodeNum][2];
      String buffer;

      for (int i = 0; i < nodeNum; i++) {
         buffer = scanner.nextLine();
         tree[buffer.charAt(0) - 'A'][0] = buffer.charAt(2) - 'A';
         tree[buffer.charAt(0) - 'A'][1] = buffer.charAt(4) - 'A';
      }

      front(0, tree);
      System.out.println();
      middle(0, tree);
      System.out.println();
      back(0, tree);
      System.out.println();

      scanner.close();
   }
}
