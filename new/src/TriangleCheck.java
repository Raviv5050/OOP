// ID: 208387951

/**
 *The program get three decimal numbers as arguments.
 *The program check if the 3 numbers represent the lengths of edges of a triangle and check if one of the
 *angels in this triangle is 90 degrees.the program print “Invalid input" If the input has less than 3 values
 *or if one of the values is 0 or less
 */
public class TriangleCheck {
    /**
     *check if the 3 numbers can represent the lengths of edges of a triangle and check if one of the
     *angels in this triangle is 90 degrees.
     * @param args a,b,c- three decimal numbers as arguments from command line
     */
    public static void main(String[] args) {
        // A variable that save a very low number
        double epsilon = Math.pow(10, -15);
        double a;
        double b;
        double c;
        //we want to print “Invalid input" If the input has less than 3 values and exit from the program
        if (args.length <= 2) {
            System.out.println("Invalid input");
            System.exit(0);
        }
        a = Double.parseDouble(args[0]);
        b = Double.parseDouble(args[1]);
        c = Double.parseDouble(args[2]);
        //we want to print “Invalid input" if one of the values is 0 or less and exit from the program
        if (((a <= 0) || (b <= 0)) || (c <= 0)) {
            System.out.println("Invalid input");
            System.exit(0);
        }
        //check if every pair of ribs in the triangle is larger than the rest so it can be a triangle
        if ((((a + b) > c) && ((a + c) > b)) && ((c + b) > a)) {
            System.out.println("triangle!");
            //if Pitagoras sentence existing(Including Epsilon difference) in one of the cases then it's a right angled
            if (Math.abs(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) - c) < epsilon) {
                System.out.println("right angled!");
            } else if (Math.abs(Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2)) - b) < epsilon) {
                System.out.println("right angled!");
            } else if (Math.abs(Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2)) - a) < epsilon) {
                System.out.println("right angled!");
            }
            //after that case we want to exit from the program.
            System.exit(0);
        }
        //if nothing success it's not a triangle.
        System.out.println("not triangle");
    }
}
