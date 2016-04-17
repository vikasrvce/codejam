import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RevengeOfPancakes {
  public static Integer solve(char[] input) {
    if(input.length == 1) {
      if(input[0] == '+')
        return 0;
      else
        return 1;
    }

    int N = input.length;
    int i = 0;
    int count = 0;
    while(i < N) {
      if(input[i] == '-') {
        while(i < N && input[i] == '-') i++;
        count++;
      } else {
        while(i < N && input[i] == '+') i++;
        if(i < N)
          count++;
      }
    }

    return count;
  }

  public static String solve(Scanner scn) {
    String s = scn.next();
    return solve(s.toCharArray()).toString();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn;
    PrintStream out;
    if(args.length != 1) {
      scn = new Scanner(System.in);
      out = System.out;
    } else {
      String fileName = args[0];
      int pos = fileName.lastIndexOf(".");
      String outFileName = fileName.substring(0, pos) + ".out";
      scn = new Scanner(new File(args[0]));
      out = new PrintStream(new FileOutputStream(outFileName, false));
    }

    int T = scn.nextInt();

    for(int i = 0; i < T; i++) {
      out.println("Case #" + (i+1) + ": " + solve(scn));
    }

    scn.close();
    out.close();
  }
}
