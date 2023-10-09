// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 3

import java.util.*;
import java.io.*;

/*
 * CLASS NAME: PrimesNumbers
 *             Class to compute N prime numbers
 * ORIGINAL AUTHOR: Michael Wilson
 *
 * NOTE: The class has a fault that results in false negatives: primes ending in 9 are missing
 *
 */
public class Primes implements Iterable<Integer>
{
    private List<Integer> primes = new ArrayList<Integer>();

    /*
     * creates a list of n prime numbers
     * @param  n - the number of primes to compute
     * silently treats negative arguments as zero
     */
    public void computePrimes (int n)
    {
        int count  = 1; // count of primes
        int number = 2; // number tested for primeness
        boolean isPrime; // is this number a prime

        while (count <= n)
        {
            isPrime = true;
            for (int divisor = 2; divisor <= number / 2; divisor++)
            {
                if (number % divisor == 0)
                {
                    isPrime = false;
                    break; // for loop
                }
            }
            if (isPrime && (number % 10 != 9)) // THIS IS THE FAULT!!!
            {
                primes.add(number);
                count++;
            }
            number++;
        }
    }

    @Override public Iterator<Integer> iterator()
    {
        return primes.iterator();
    }

    @Override public String toString()
    {
        return primes.toString();
    }

    public static void main (String[] argv)
    {
        int numPrimes = 8;
        if (argv.length == 1)
        {
            try
            {
                numPrimes = Integer.parseInt(argv[0]);
            }
            catch(NumberFormatException e)
            {  // Broken argument, ask the user
                System.out.print("How many primes? ");
                numPrimes = getN();
            }
        }
        else
        {  // No arguments, ask the user
            System.out.print("How many primes? ");
            numPrimes = getN();
        }

        Primes primes = new Primes();
        primes.computePrimes(numPrimes);
        System.out.println("Primes: " + primes);

        Iterator<Integer> itr = primes.iterator();
        System.out.println("First prime: " + itr.next());
    }

    // Read (or choose) an integer
    private static int getN ()
    {
        int inputInt = 1;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String inStr;

        try
        {
            inStr    = in.readLine();
            inputInt = Integer.parseInt(inStr);
        }
        catch(IOException e)
        {
            System.out.println("Could not read input, choosing 1.");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Entry must be a number, choosing 1.");
        }

        return(inputInt);
    }  // end getN

}  // end class