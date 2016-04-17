import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import java.util.HashSet;
import java.util.Set;

public class CountingSheep {
  public static void getDigits(int N, Set<Character> s) {
    while(N != 0) {
      s.add((char) (N%10));
      if(s.size() == 10)
        break;

      N = N / 10;
    }
  }

  public static Integer count(int N) {
    Set<Character> s = new HashSet<>();
    int i = 1;
    while(true) {
      getDigits(N * i, s);
      if(s.size() == 10)
        break;
      i++;
    }

    return N * i;
  }

  public static String solve(Scanner scn) {
    int N = scn.nextInt();
    if(N == 0) {
      return "INSOMNIA";
    } else {
      return count(N).toString();
    }
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
