// ID: 208387951

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Raviv
 * The class receive a number that represents a regular number.
 * The Num class implementing the Expression interface.
 */
public class Num implements Expression {

    private static final double ZERO = 0.0;
    private double num;

    /**
     * constructor with configurable num.
     *
     * @param num The current num.
     */
    public Num(double num) {
        this.num = num;
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we just want to return the num.
     *
     * @param assignment the map with the variables
     * @return num the current num
     * @throws Exception the exception
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.num;
    }

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we just want to return the num.
     *
     * @return num the current num
     * @throws Exception the exception
     */
    public double evaluate() throws Exception {
        return this.num;
    }

    /**
     * getVariables -- Returns a list of the variables in the expression.
     *
     * @return list an empty list of variables.
     */
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        return list;
    }

    /**
     * toString -- Returns a nice string representation of the expression.
     *
     * @return numAsString return the number as a string.
     */
    public String toString() {
        String numAsString = new String(String.valueOf(this.num));
        return numAsString;
    }

    /**
     * assign -- Returns the current expression.
     *
     * @param var        the var we want to replace with the provided expression
     * @param expression the provided expression
     * @return expression the same expression
     */
    public Expression assign(String var, Expression expression) {
        return new Num(this.num);
    }

    /**
     * differentiate -- returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param var the var we want to differentiate  expression relative to it
     * @return expression tree resulting from differentiating the expression
     */
    @Override
    public Expression differentiate(String var) {
        //if the value is a num we want to return 0 because the differentiate of every num is always 0.
        return new Num(ZERO);
    }

    /**
     * simplify -- Returned a simplified version of the current expression.
     *
     * @return simplified version of the expression
     */
    @Override
    public Expression simplify() {
        //we want to return the current expression without any simplification.
        return new Num(this.num);
    }
}
