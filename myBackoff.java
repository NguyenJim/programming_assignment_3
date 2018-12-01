import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class myBackoff {

    public static void linear_backoff(PrintWriter ofile, int N)
    {
        for (int trial = 0; trial < 10; trial++) {
            // perform trials
        }
        ofile.println(N);
    }

    public static void binary_exponential_backoff(PrintWriter ofile, int N)
    {
        for (int trial = 0; trial < 10; trial++) {
            // perform trials
        }
        ofile.println(N);
    }

    public static void logarithmic_backoff(PrintWriter ofile, int N)
    {
        for (int trial = 0; trial < 10; trial++) {
            // perform trials
        }
        ofile.println(N);
    }

    public static void main(String[] args)
        throws FileNotFoundException
    {
        PrintWriter linear_of = new PrintWriter("linearLatency.txt");
        PrintWriter binary_of = new PrintWriter("binaryLatency.txt");
        PrintWriter log_of = new PrintWriter("logLatency.txt");

        for (int N = 100; N <= 60000; N += 100) {
            linear_backoff(linear_of, N);
        }

        for (int N = 100; N <= 60000; N += 100) {
            binary_exponential_backoff(binary_of, N);
        }

        for (int N = 100; N <= 60000; N += 100) {
            logarithmic_backoff(log_of, N);
        }

        linear_of.close();
        binary_of.close();
        log_of.close();
    }
}

