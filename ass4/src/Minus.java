// ID: 208387951

import java.util.Map;

/**
 * @author Raviv
 * The class receive two internal expressions and represents a subtraction operation action
 * The Minus class inherited from BinaryExpression.
 */

public class Minus extends BinaryExpression {

    private static final double ZERO = 0.0;

    /**
     * constructor with configurable firstExpression,secondExpression .
     *
     * @param firstExpression  the first expression.
     * @param secondExpression the second expression.
     */
    public Minus(Expression firstExpression, Expression secondExpression) {
        super(firstExpression, secondExpression);
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we Performs the subtraction operation.
     *
     * @param assignment the map
     * @return difference -the subtraction operation
     * @throws Exception the exceptions
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double difference = getFirstExpression().evaluate(assignment) - getSecondExpression().evaluate(assignment);
        return difference;
    }

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result.  in this case we Performs the subtraction operation.
     *
     * @return difference -the subtraction operation
     * @throws Exception the exceptions
     */
    public double evaluate() throws Exception {
        double difference = getFirstExpression().evaluate() - getSecondExpression().evaluate();
        return difference;
    }

    /**
     * currentSign -- Returns the sign of the current action.
     *
     * @return minus sign
     */
    @Override
    public String currentSign() {
        return " - ";
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
        Expression newFirstExpression = getFirstExpression().assign(var, expression);
        Expression newSecondExpression = getSecondExpression().assign(var, expression);
        //merging the two expressions
        Expression fullExpression = new Minus(newFirstExpression, newSecondExpression);
        return fullExpression;
    }

    /**
     * differentiate -- returns the expression tree resulting from differentiating the current
     * expression relative to variable `var`.
     *
     * @param var the var we want to differentiate expression relative to it
     * @return expression tree resulting from differentiating the expression
     */
    @Override
    public Expression differentiate(String var) {
        Expression firstDifferentiateExpression = getFirstExpression().differentiate(var);
        Expression secondDifferentiateExpression = getSecondExpression().differentiate(var);
        //merging the two expressions to one differentiate
        Expression fullDifferentiateExpression = new Minus(firstDifferentiateExpression, secondDifferentiateExpression);
        return fullDifferentiateExpression;
    }

    /**
     * simplify -- Returned a simplified version of the current expression.
     *
     * @return simplified version of the expression
     */
    @Override
    public Expression simplify() {
        //we want to support the simplification: 0 - X = -X
        if ((getFirstExpression().simplify().toString().equals("0.0"))
                && (!getSecondExpression().simplify().toString().equals("0.0"))) {
            Expression simplifyExpression = getSecondExpression().simplify();
            Expression negSimplifyExpression = new Neg(simplifyExpression);
            try {
                double tryNewMinus = negSimplifyExpression.evaluate();
                return new Num(tryNewMinus);
            } catch (Exception exception) {
                return negSimplifyExpression;
            }
        //we want to support the simplification: X - 0 = X
        } else if (getSecondExpression().simplify().toString().equals("0.0")) {
            Expression simplifyExpression = getFirstExpression().simplify();
            try {
                double tryNewMinus = simplifyExpression.evaluate();
                return new Num(tryNewMinus);
            } catch (Exception exception) {
                return simplifyExpression;
            }
        //we want to support the simplification: X - X = 0
        } else if (getFirstExpression().simplify().toString().equals(getSecondExpression().simplify().toString())) {
            Expression simplifyExpression = new Num(ZERO);
            return simplifyExpression;
        }
        //else we want to return the current expression with simplification on each expression.
        Expression firstSimplifyExpression = getFirstExpression().simplify();
        Expression secondSimplifyExpression = getSecondExpression().simplify();
        try {
            Expression simplifyExpression = new Minus(firstSimplifyExpression, secondSimplifyExpression);
            double tryNewMinus = simplifyExpression.evaluate();
            return new Num(tryNewMinus);
        } catch (Exception exception) {
            return new Minus(firstSimplifyExpression, secondSimplifyExpression);
        }
    }
}
