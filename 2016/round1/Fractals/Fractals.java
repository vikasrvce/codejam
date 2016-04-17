import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Fractals {

  public static long pow (long a, int b)
  {
    if ( b == 0)        return 1;
    if ( b == 1)        return a;
    if ( b % 2 == 0)    return     pow ( a * a, b/2); //even a=(a^2)^b/2
    else                return a * pow ( a * a, b/2); //odd  a=a*(a^2)^b/2

  }

  public static String solve(int K, int C, int S) {
    StringBuilder sb = new StringBuilder();
    if( S >= (K+C-1) / C) {
      long dig = 0;
      for(; dig < K;) {
        long val = 0;
        for(int i = Math.min(K,C)-1; i >=0 && dig < K; i--) {
          val += pow(K, i) * dig;
          dig++;
        }
        sb.append((val+1) + " ");
      }

      String res = sb.toString();
      return res.trim();
    } else {
       return "IMPOSSIBLE";
    }
  }

  public static String solve(Scanner scn) {
    int K = scn.nextInt();
    int C = scn.nextInt();
    int S = scn.nextInt();

    return solve(K, C, S);
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
