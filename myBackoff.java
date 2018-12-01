import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class myBackoff {

    public static void linear_backoff(int N)
    {
    }

    public static void binary_exponential_backoff(int N)
    {
    }

    public static void logarithmic_backoff(int N)
    {
    }

    public static void linear_test(PrintWriter ofile, int N)
    {
        // perform 10 trials and take average
        for (int trial = 0; trial < 10; trial++) {
            linear_backoff();
        }
        ofile.println(N);
    }

    public static void binary_test(PrintWriter ofile, int N)
    {
        // perform 10 trials and take average
        for (int trial = 0; trial < 10; trial++) {
            binary_exponential_backoff();
        }
        ofile.println(N);
    }

    public static void logarithmic_test(PrintWriter ofile, int N)
    {
        // perform 10 trials and take average
        for (int trial = 0; trial < 10; trial++) {
            logarithmic_backoff();
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
            linear_test(linear_of, N);
            binary_test(binary_of, N);
            logarithmic_test(log_of, N);
        }

        linear_of.close();
        binary_of.close();
        log_of.close();
    }
}

