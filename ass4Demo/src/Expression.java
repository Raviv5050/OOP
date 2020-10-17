// ID: 208387951

import java.util.List;
import java.util.Map;

/**
 * @author Raviv
 * The interface
 */
public interface Expression {

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result. If the expression contains a variable which is not in the assignment,
     * an exception is thrown.
     *
     * @param assignment the current Map of the assignment.
     * @return evaluate the expression return the result.
     * * @throws Exception ""
     */
    double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return evaluate the expression return the result.
     * @throws Exception ""
     */
    double evaluate() throws Exception;

    /**
     * getVariables -- Returns a list of the variables in the expression.
     *
     * @return list an empty list of variables.
     */
    List<String> getVariables();

    /**
     * toString -- Returns a nice string representation of the expression.
     *
     * @return a string representation of the expression.
     */
    String toString();

    /**
     * assign -- Returns a new expression in which all occurrences of the variable var are replaced with the
     * provided expression (Does not modify the current expression).
     *
     * @param var        the var we want to replace with the provided expression
     * @param expression the provided expression
     * @return the new expression after
     */
    Expression assign(String var, Expression expression);

    /**
     * differentiate -- returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param var the var we want to differentiate  expression relative to it
     * @return expression tree resulting from differentiating the expression
     */
    Expression differentiate(String var);

    /**
     * simplify -- Returned a simplified version of the current expression.
     *
     * @return simplified version of the expression
     */
    Expression simplify();
}