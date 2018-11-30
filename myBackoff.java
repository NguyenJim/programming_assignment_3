import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class myBackoff {

    public static void linear_backoff()
        throws FileNotFoundException
    {
        PrintWriter ofile = new PrintWriter("linearLatency.txt");
        ofile.close();
    }

    public static void binary_exponential_backoff()
        throws FileNotFoundException
    {
        PrintWriter ofile = new PrintWriter("binaryLatency.txt");
        ofile.close();
    }

    public static void logarithmic_backoff()
        throws FileNotFoundException
    {
        PrintWriter ofile = new PrintWriter("logLatency.txt");
        ofile.close();
    }

    public static void main(String[] args)
    {
    }
}

