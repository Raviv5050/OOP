// ID: 208387951

import java.util.Map;

/**
 * @author Raviv
 * The class receive an internal expressions and represents a cosine operation action
 * The Cos class inherited from UnaryExpression.
 */

public class Cos extends UnaryExpression {

    /**
     * constructor with configurable expression.
     *
     * @param expression the current expression.
     */
    public Cos(Expression expression) {
        super(expression);
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment
     * , and return the result. in this case we Performs the cosine operation.
     *
     *  @param assignment the map with the variables.
     * @return cosine -the cosine operation.
     * @throws Exception return exception.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double cosine = Math.cos(Math.toRadians(getExpression().evaluate(assignment)));
        return cosine;
    }

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result.  in this case we Performs the cosine operation.
     *
     * @return cosine -the cosine operation
     * @throws Exception return exception.
     */
    @Override
    public double evaluate() throws Exception {
        double cosine = Math.cos(Math.toRadians(getExpression().evaluate()));
        return cosine;
    }

    /**
     * currentSign -- Returns the sign of the current action.
     *
     * @return cosine sign
     */
    @Override
    public String currentSign() {
        return "cos";
    }

    /**
     * assign -- Returns a new expression in which all occurrences of the variable var are replaced with the
     * provided expression (Does not modify the current expression).
     *
     * @param var        the var we want to replace with the provided expression
     * @param expression the provided expression
     * @return expression the new expression after
     */
    @Override
    public Expression assign(String var, Expression expression) {
        Expression newExpression = getExpression().assign(var, expression);
        Expression fullExpression = new Cos(newExpression);
        return fullExpression;
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
        Expression sinExpression = new Sin(getExpression());
        Expression differentiateExpression = getExpression().differentiate(var);
        //calculating the multiplication
        Expression multExpression = new Mult(differentiateExpression, sinExpression);
        //calculating the negative of the expressions
        Expression fullDifferentiateExpression = new Neg(multExpression);
        return fullDifferentiateExpression;
    }

    /**
     * simplify -- Returned a simplified version of the current expression.
     *
     * @return simplified version of the expression
     */
    @Override
    public Expression simplify() {
        //we want to return the current expression with simplification on the expression.
        Expression simplifyExpression = getExpression().simplify();
        try {
            Expression cosSimplifyExpression = new Cos(simplifyExpression);
            double tryNewCos = cosSimplifyExpression.evaluate();
            return new Num(tryNewCos);
        } catch (Exception exception) {
            return new Cos(simplifyExpression);
        }
    }
}
