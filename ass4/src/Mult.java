// ID: 208387951

import java.util.Map;

/**
 * @author Raviv
 * The class receive two internal expressions and represents a multiplication operation action
 * The Mult class inherited from BinaryExpression.
 */

public class Mult extends BinaryExpression {
    private static final double ONE = 1;
    private static final double ZERO = 0.0;

    /**
     * constructor with configurable firstExpression,secondExpression .
     *
     * @param firstExpression  the first expression.
     * @param secondExpression the second expression.
     */
    public Mult(Expression firstExpression, Expression secondExpression) {
        super(firstExpression, secondExpression);
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we Performs the multiplication operation
     *
     * @param assignment - the map with all the vars.
     * @return multiplication -the multiplication operation
     * @throws Exception the exception
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double multiplication = getFirstExpression().evaluate(assignment) * getSecondExpression().evaluate(assignment);
        return multiplication;
    }

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result.  in this case we Performs the connection operation.
     *
     * @return multiplication -the multiplication operation.
     * @throws Exception the exception.
     */
    @Override
    public double evaluate() throws Exception {
        double multiplication = getFirstExpression().evaluate() * getSecondExpression().evaluate();
        return multiplication;
    }

    /**
     * currentSign -- Returns the sign of the current action.
     *
     * @return multiplication sign
     */
    @Override
    public String currentSign() {
        return " * ";
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
        Expression fullExpression = new Mult(newFirstExpression, newSecondExpression);
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
        Expression firstDifferentiateExpression = getFirstExpression().differentiate(var);
        Expression secondDifferentiateExpression = getSecondExpression().differentiate(var);
        //calculating each side of the multiplication.
        Expression firstMultDifferentiate = new Mult(firstDifferentiateExpression, getSecondExpression());
        Expression secondMultDifferentiate = new Mult(getFirstExpression(), secondDifferentiateExpression);
        //merging the two expressions to one differentiate
        Expression fullDifferentiateExpression = new Plus(firstMultDifferentiate, secondMultDifferentiate);
        return fullDifferentiateExpression;
    }

    /**
     * simplify -- Returned a simplified version of the current expression.
     *
     * @return simplified version of the expression
     */
    @SuppressWarnings("checkstyle:RightCurly")
    @Override
    public Expression simplify() {
        //we want to support the simplification: 1 * x = x
        if (getFirstExpression().simplify().toString().equals("1.0")) {
            Expression simplifyExpression = getSecondExpression().simplify();
            try {
                double tryNewMult = simplifyExpression.evaluate();
                return new Num(tryNewMult);

            } catch (Exception exception) {
                return simplifyExpression;
            }
            //we want to support the simplification: x * 1 = x
        } else if (getSecondExpression().simplify().toString().equals("1.0")) {
            Expression simplifyExpression = getFirstExpression().simplify();
            try {
                double tryNewMult = simplifyExpression.evaluate();
                return new Num(tryNewMult);
            } catch (Exception exception) {
                return simplifyExpression;
            }
        }
        //we want to support the simplification: x * x = x^2
        if (getFirstExpression().simplify().toString().equals(getSecondExpression().simplify().toString())) {
            Expression simplifyExpression = getSecondExpression().simplify();
            Expression powExpression = new Pow(simplifyExpression, new Num(2));
            try {
                double tryNewMult = powExpression.evaluate();
                return new Num(tryNewMult);

            } catch (Exception exception) {
                return powExpression;
            }
            //we want to support the simplification: x * 0 = 0  or  0 * x = 0
        } else if ((getFirstExpression().simplify().toString().equals("0.0"))
                || (getSecondExpression().simplify().toString().equals("0.0"))) {
            Expression simplifyExpression = new Num(ZERO);
            return simplifyExpression;
        }
        //else we want to return the current expression with simplification on each expression.
        Expression firstSimplifyExpression = getFirstExpression().simplify();
        Expression secondSimplifyExpression = getSecondExpression().simplify();
        try {
            Expression simplifyExpression = new Mult(firstSimplifyExpression, secondSimplifyExpression);
            double tryNewMult = simplifyExpression.evaluate();
            return new Num(tryNewMult);

        } catch (Exception exception) {
            return new Mult(firstSimplifyExpression, secondSimplifyExpression);
        }
    }
}
