// ID: 208387951

/**
 * @author Raviv
 * An abstract base class, the classes:  Sin, Cos, Neg are all inherited from this class.
 * The UnaryExpression class inherited from UnaryExpression class.
 */

public abstract class UnaryExpression extends BaseExpression {

    private static final int FIRST_INDEX = 0;

    /**
     * constructor with configurable expression.
     *
     * @param expression the current expression.
     */
    public UnaryExpression(Expression expression) {
        super(new Expression[]{expression});
    }

    /**
     * getExpression -- return the current expression.
     *
     * @return the current expression
     */
    public Expression getExpression() {
        return getExpressionByIndex(FIRST_INDEX);
    }

    /**
     * toString -- Returns a string representation of the expression.
     *
     * @return the string representation.
     */
    public String toString() {
        //put the current sign before the string.
        String string = currentSign() + "(" + getExpression().toString() + ")";
        return string;
    }
}
