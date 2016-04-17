import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Template {
  public static String solve(Scanner scn) {
    return null;
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