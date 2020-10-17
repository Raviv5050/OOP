// ID: 208387951

/**
 *The program receives a number of words and one char as the last arguments.
 *The program check if the char appears in each word and print two groups of words in the order that they
 *were recieved:
 * first the words in which the char appears , and then the rest of the words.
 */
public class CharCount {
    /**
     *check if the char appears in each word and print first the words in which the char appears , and then
     * the rest of the words.
     * @param args a string array that is a number of words and one char as the last arguments.
     */
    public static void main(String[] args) {
        //lastStr is the char- the last argument
        String lastStr = new String(args[(args.length) - 1]);
        String str = new String();
        //If the last input is not a char or if there are less then 2 inputs the program prints 'Invalid input'
        if ((args.length < 2) || lastStr.length() > 1) {
            System.out.println("Invalid input");
            //in this case we want to exist from the program after the printing
            System.exit(0);
        }
        //for loop that run over all the strings until the char that in the last argument
        for (int i = 0; i < (args.length) - 1; i++) {
            //str value is the current string from the args
            str = args[i];
            //for that run through the chars of each string
            for (int j = 0; j < str.length(); j++) {
                //if the char is equal to "lastStr" char we want to print this string
                if (str.charAt(j) == lastStr.charAt(0)) {
                    System.out.println(str);
                    break;
                }
            }
        }
        //for loop that run over all the strings until the char that in the last argument
        for (int i = 0; i < (args.length) - 1; i++) {
            //str value is the current string from the args
                str = args[i];
            //for that run through the chars of each string
                for (int j = 0; j < str.length(); j++) {
                    //if the char is equal to "lastStr" char we want to check the next string
                    if (str.charAt(j) == lastStr.charAt(0)) {
                        break;
                    }
                    //if the char is the last char of the word we want to print this string
                    if (j == (str.length()) - 1) {
                        System.out.println(str);
                    }
                }
            }
        }
    }
