// ID: 208387951

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Raviv
 * The class receive a var that Represents a standard variable
 * The Num class implementing the Expression interface.
 */
public class Var implements Expression {

    private static final double ZERO = 0.0;
    private static final double ONE = 1;
    private static final String E = "e";
    private static final String PAI = "Pi";
    private String var;

    /**
     * constructor with configurable var.
     *
     * @param var The current var.
     */
    public Var(String var) {
        this.var = var;
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we just want to return the current value for a given variable.
     *
     * @param assignment the current Map of the assignment.
     * @return var the current value for a given variable.
     * @throws Exception the exception
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        //if the key (var) is 'e' and it's variable (var) isn't exist in the assignment (map)
        // we want to enter the value of 'e'
        if (this.var.equals(E) && (!assignment.containsKey(var))) {
            return Math.E;
        }
        //if the key (var) is 'Pi' and it's variable (var) isn't exist in the assignment (map)
        // we want to enter the value of 'Pi'
        if (var.equals(PAI) && (!assignment.containsKey(var))) {
            return Math.PI;
        }
        //if the key (var) isn't exist in the assignment (map) we want to throw an exception
        if (!assignment.containsKey(var)) {
            throw new Exception("Exception - the var isn't exist in the map");
        //if the value for a given variable (var) isn't exist in the assignment (map) we want to throw an exception
        } else if (assignment.get(var) == null) {
            throw new Exception("Exception - the current value of this given variable isn't exist in the map");
        }
        //if the value is exist we want to return the value for a given variable (var)
        return assignment.get(var);
    }

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we just want to return the current value for a given variable.
     *
     * @return var the current value for a given variable.
     * @throws Exception the exception
     */
    public double evaluate() throws Exception {
        //if the key (var) is 'e' and it's variable (var) isn't exist in the assignment (map)
        // we want to enter the value of 'e'
        if (this.var.equals(E)) {
            return Math.E;
        }
        //if the key (var) is 'Pi' and it's variable (var) isn't exist in the assignment (map)
        // we want to enter the value of 'Pi'
        if (var.equals(PAI)) {
            return Math.PI;
        }
        throw new Exception("Exception - the var isn't exist in the map (there is no map)");
    }

    /**
     * getVariables -- Returns a list of the variables in the expression.
     *
     * @return list the list of all the variables.
     */
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        list.add(this.var);
        return list;
    }

    /**
     * toString -- Returns a nice string representation of the expression.
     *
     * @return the var as a string.
     */
    public String toString() {
        return this.var;
    }

    /**
     * assign -- Returns a new expression in which all occurrences of the variable var are replaced with the
     * provided expression (Does not modify the current expression).
     *
     * @param newVar        the var we want to replace with the provided expression
     * @param expression the provided expression
     * @return expression the new expression after
     */
    public Expression assign(String newVar, Expression expression) {
        // if the current val is the val that we want to replace we replace it with the provided expression
        if (newVar.equals(this.var)) {
            return expression;
        }
        //if it's not the val that we want to replaced we will return the current val as expression
        return new Var(this.var);
    }

    /**
     * differentiate -- returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param newVar the var we want to differentiate  expression relative to it
     * @return expression tree resulting from differentiating the expression
     */
    @Override
    public Expression differentiate(String newVar) {
        //if the value is equal to the value of the 'var' that we got we want to return 1.
        if (newVar.equals(this.var)) {
            return new Num(ONE);
        }
        //if the value isn't equal to the value of the 'var' that we got we want to return 0 because it is acting
        //like a num, and differentiate of every num is always 0.
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
        return new Var(this.var);
    }
}
