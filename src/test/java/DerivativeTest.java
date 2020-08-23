import Expressions.Base.Expression;
import Expressions.Functions.Cos;
import Expressions.Functions.Ln;
import Expressions.Functions.Power;
import Expressions.Functions.Sin;
import Expressions.Primitives.BinaryOperations.Div;
import Expressions.Primitives.Variable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


public class DerivativeTest {

    private Variable x;
    private Variable y;

    @Before
    public void setup() {
        this.x = new Variable("x");
        this.y = new Variable("y");
    }

    @Test
    public void When_DerivativeOfCos_Expect_MinusSin() {
        Expression cosExpr = new Cos(x);
        Assert.assertEquals("((-1.0 * sin(x)) * 1.0)", cosExpr.deriv(x).toString());
    }

    @Test
    public void When_DerivativeOfSin_Except_Cos() {
        Expression sinExpr = new Sin(x);
        Assert.assertEquals("(cos(x) * 1.0)", sinExpr.deriv(x).toString());
    }

    @Test
    public void When_DerivativeOfLn_Except_1divx() {
        Expression lnExpr = new Ln(x);
        Assert.assertEquals("((1.0 / x) * 1.0)", lnExpr.deriv(x).toString());
    }

    @Test
    public void When_DerivativeOfPower_Except_PowerMinus() {
        Expression powerExpr = new Power(x, 3);
        Assert.assertEquals("((3.0 * (x) ^ 2.0) * 1.0)", powerExpr.deriv(x).toString());
    }

    @Test
    public void When_DerivativeOfDivision() {
        Expression divExpr = new Div(x, y);
        Assert.assertEquals("(((1.0 * y) - (x * 0.0)) / (y * y))", divExpr.deriv(x).toString());
        Assert.assertEquals("(((0.0 * y) - (x * 1.0)) / (y * y))", divExpr.deriv(y).toString());
    }



}
