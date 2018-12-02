import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class myBackoff {

    public static int rand_int(int min, int max)
    {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    public static int linear_backoff(int num_devices)
    {
        int num_slots = 2;
        int latency = num_slots;
        int[] slots = new int[num_slots];

        while (num_devices > 0) {
            // tally which slots each device goes in
            for (int dev = 0; dev < num_devices; dev++) {
                // pick a random slot and inc
                int rand_slot = rand_int(0, num_slots - 1);
                slots[rand_slot]++;
            }

            // check for sucessful transmissions
            for (int i = 0; i < slots.length; i++) {
                if (slots[i] == 1) {
                    // transmission was successful
                    num_devices--;
                }
            }

            // see if we need to increase the window
            if (num_devices > 0) {
                num_slots += 1;
                slots = new int[num_slots];
                latency += num_slots;
            } else {
                for (int i = num_slots - 1; i > 0; i--){
                    // start at the end and check for the last 1
                    if (slots[i] == 1) {
                        // need to +1 since this is basing off the index
                        latency += i + 1;
                        break;
                    }
                }
            }
        }

        return latency;
    }

    public static int binary_exponential_backoff(int num_devices)
    {
        return 0;
    }

    public static int logarithmic_backoff(int num_devices)
    {
        return 0;
    }

    public static void linear_test(PrintWriter ofile, int num_devices)
    {
        // perform 10 trials and take average
        for (int trial = 0; trial < 10; trial++) {
            linear_backoff(num_devices);
        }
        // ofile.println(N);
    }

    public static void binary_test(PrintWriter ofile, int num_devices)
    {
        // perform 10 trials and take average
        for (int trial = 0; trial < 10; trial++) {
            binary_exponential_backoff(num_devices);
        }
        // ofile.println(N);
    }

    public static void logarithmic_test(PrintWriter ofile, int num_devices)
    {
        // perform 10 trials and take average
        for (int trial = 0; trial < 10; trial++) {
            logarithmic_backoff(num_devices);
        }
        // ofile.println(N);
    }

    public static void main(String[] args)
        throws FileNotFoundException
    {
        System.out.println(linear_backoff(100));
        // PrintWriter linear_of = new PrintWriter("linearLatency.txt");
        // PrintWriter binary_of = new PrintWriter("binaryLatency.txt");
        // PrintWriter log_of = new PrintWriter("logLatency.txt");

        // for (int N = 100; N <= 6000; N += 100) {
        //     linear_test(linear_of, N);
        //     binary_test(binary_of, N);
        //     logarithmic_test(log_of, N);
        // }

        // linear_of.close();
        // binary_of.close();
        // log_of.close();
    }
}

