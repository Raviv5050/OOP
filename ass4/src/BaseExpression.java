// ID: 208387951

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author Raviv
 * An abstract base class, the classes:  UnaryExpression and BinaryExpression are all inherited from this class.
 * The BaseExpression class implementing the Expression interface.
 */

public abstract class BaseExpression implements Expression {

    private Expression[] expressionsArray;

    /**
     * constructor with configurable of expressions array.
     *
     * @param array the current expressions array.
     */
    public BaseExpression(Expression[] array) {
        this.expressionsArray = array;
    }

    /**
     * getExpressionByIndex -- return the specific expression from the current expressions array.
     *
     * @param index the index of the current expression in the array
     * @return the specific expression
     */
    public Expression getExpressionByIndex(int index) {
        return this.expressionsArray[index];
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result.
     *
     * @param assignment the map with the values.
     * @return the result of the calculation
     * @throws Exception when it can't calculate the function
     */
    public abstract double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result.
     *
     * @return the result of the calculation
     * @throws Exception when it can't calculate the function
     */
    public abstract double evaluate() throws Exception;

    /**
     * getVariables -- Returns a list of the variables in the expression.
     *
     * @return list the list of all the variables.
     */
    public List<String> getVariables() {
        HashSet<String> hashset = new HashSet<String>();
        for (int i = 0; i < expressionsArray.length; i++) {
            //adding the list of the expression to the new hashset
            hashset.addAll(expressionsArray[i].getVariables());
        }
        List<String> list = new ArrayList<String>(hashset);
        return list;
    }

    /**
     * currentSign -- Returns the sign of the current action.
     *
     * @return sign
     */
    public abstract String currentSign();

    /**
     * toString -- Returns a string representation of the expression.
     *
     * @return the string representation.
     */
    public abstract String toString();

    /**
     * assign -- Returns a new expression in which all occurrences of the variable var are replaced with the
     * provided expression (Does not modify the current expression).
     *
     * @param var        the var we want to replace with the provided expression
     * @param expression the provided expression
     * @return expression the new expression after
     */
    public abstract Expression assign(String var, Expression expression);
}
