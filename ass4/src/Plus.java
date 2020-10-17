// ID: 208387951

import java.util.Map;

/**
 * @author Raviv
 * The class receive two internal expressions and represents a connection action
 * The Plus class inherited from BinaryExpression.
 */
public class Plus extends BinaryExpression {

    private static final double ZERO = 0.0;
    private static final double TWO = 2;

    /**
     * constructor with configurable firstExpression,secondExpression .
     *
     * @param firstExpression  the first expression.
     * @param secondExpression the second expression.
     */
    public Plus(Expression firstExpression, Expression secondExpression) {
        super(firstExpression, secondExpression);
    }

    /**
     * evaluate -- Evaluate the expression using the variable values provided in the assignment,
     * and return the result. in this case we Performs the connection operation
     *
     * @param assignment the map
     * @return sum -the connection operation
     * @throws Exception the exception
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        double sum = getFirstExpression().evaluate(assignment) + getSecondExpression().evaluate(assignment);
        return sum;
    }

    /**
     * evaluate -- A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * Evaluate the expression using the variable values provided in the assignment,
     * and return the result.  in this case we Performs the connection operation.
     *
     * @return sum -the connection operation
     * @throws Exception the exception
     */
    @Override
    public double evaluate() throws Exception {
        double sum = getFirstExpression().evaluate() + getSecondExpression().evaluate();
        return sum;
    }

    /**
     * currentSign -- Returns the sign of the current action.
     *
     * @return connection sign
     */
    @Override
    public String currentSign() {
        return " + ";
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
        Expression fullExpression = new Plus(newFirstExpression, newSecondExpression);
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
        //merging the two expressions to one differentiate
        Expression fullDifferentiateExpression = new Plus(firstDifferentiateExpression, secondDifferentiateExpression);
        return fullDifferentiateExpression;
    }

    /**
     * simplify -- Returned a simplified version of the current expression.
     *
     * @return simplified version of the expression
     */
    @Override
    public Expression simplify() {
        //we want to support the simplification: (-x) + (x) = 0
        if ((new Neg(getFirstExpression().simplify())).toString().equals(getSecondExpression().simplify().toString())) {
            Expression simplifyExpression = new Num(ZERO);
            return simplifyExpression;
        }
        //we want to support the simplification: (x) + (-x) = 0
        if ((new Neg(getSecondExpression().simplify())).toString().equals(getFirstExpression().simplify().toString())) {
            Expression simplifyExpression = new Num(ZERO);
            return simplifyExpression;
        }
        //we want to support the simplification: 0 + x = x
        if (getFirstExpression().simplify().toString().equals("0.0")) {
            Expression simplifyExpression = getSecondExpression().simplify();
            try {
                double tryNewPlus = simplifyExpression.evaluate();
                return new Num(tryNewPlus);
            } catch (Exception exception) {
                return simplifyExpression;
            }

            //we want to support the simplification: x + 0 = x
        } else if (getSecondExpression().simplify().toString().equals("0.0")) {
            Expression simplifyExpression = getFirstExpression().simplify();
            try {
                double tryNewPlus = simplifyExpression.evaluate();
                return new Num(tryNewPlus);
            } catch (Exception exception) {
                return simplifyExpression;
            }
        }
        //else we want to return the current expression with simplification on each expression.
        Expression firstSimplifyExpression = getFirstExpression().simplify();
        Expression secondSimplifyExpression = getSecondExpression().simplify();
        try {
            Expression simplifyExpression = new Plus(firstSimplifyExpression, secondSimplifyExpression);
            double tryNewPlus = simplifyExpression.evaluate();
            return new Num(tryNewPlus);
        } catch (Exception exception) {
            return new Plus(firstSimplifyExpression, secondSimplifyExpression);
        }
    }
}
