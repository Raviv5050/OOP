// ID: 208387951

/**
 * @author Raviv
 * An abstract base class, the classes:  Plus, Minus, Mult, Div, Pow, Log are all inherited from this class.
 * * The BinaryExpression class inherited from UnaryExpression class.
 */

public abstract class BinaryExpression extends BaseExpression {

    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    /**
     * constructor with configurable firstExpression,secondExpression .
     *
     * @param firstExpression  the first expression.
     * @param secondExpression the second expression.
     */
    public BinaryExpression(Expression firstExpression, Expression secondExpression) {
        super(new Expression[]{firstExpression, secondExpression});
    }

    /**
     * getFirstExpression -- return the first expression.
     *
     * @return the first expression
     */
    public Expression getFirstExpression() {
        return getExpressionByIndex(FIRST_INDEX);
    }

    /**
     * getSecondExpression -- return the second expression.
     *
     * @return the second expression
     */
    public Expression getSecondExpression() {
        return getExpressionByIndex(SECOND_INDEX);
    }

    /**
     * toString -- Returns a string representation of the expression.
     *
     * @return the string representation.
     */
    public String toString() {
        //merging the strings with the current sing operator between them.
        String string = "(" + getFirstExpression().toString() + currentSign()
                + getSecondExpression().toString() + ")";
        return string;
    }
}
