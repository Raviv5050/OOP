// ID: 208387951

/**
 *This program receives an Integer argument.
 *The program calculate and prints out the average of all prime numbers between 2 and n including them.
 */
public class AveragePrimes {
    /**
     *calculate and prints the average of all prime numbers between 2 and n.
     * @param args integer n as an argument from command line.
     */
    public static void main(String[] args) {
        // an integer n as an argument
        int n = Integer.parseInt(args[0]);
        // variable of the average of all the prime numbers between 2 and n
        double average = 0;
        // variable to sum up all the prime numbers between 2 and n
        int sum = 0;
        // variable that count the number of the prime numbers between 2 and n
        int count = 0;
        //variable that sign if the number is a prime number or not
        boolean isPrimeNumber = true;
        //if the number is 1 or smaller then 1 the program should print "Invalid value"
        if (n <= 1) { System.out.println("Invalid value"); }
        //if the number is 2 the program should print 2
        if (n == 2) {
            System.out.println(n);
            //if the number is 3 or bigger we want to check how many number from 2 to this number are prime numbers
        } else {
            //this for loop check all the odd numbers from 2 to the integer n (even numbers aren't prime numbers)
            for (int j = 3; j <= n; j = j + 2) {
                //this for loop try dividing j by all the odd numbers from 2 to the radical of j
                for (int i = 3; i <= Math.sqrt(j); i = i + 2) {
                    //try dividing j by all the odd numbers from 2 to the radical of j
                    if (j % i == 0) {
                        //if the number isn't divides only by 1 and by itself it is not a prime number
                        isPrimeNumber = false;
                        break;
                    }
                }
                //if the number is a prime number we want to add the number to the sum and add one to the counter
                if (isPrimeNumber) {
                    sum = sum + j;
                    count++;
                 //initialize the boolean value "isPrimeNumber"
                } else { isPrimeNumber = true; }
            }
            //2 is a prime number so we want to add it to the sum
            sum = sum  + 2;
            count = count + 1;
            //calculate the average
            average = (double) sum / count;
            //printing the average
            System.out.println(average);
        }
    }
}
