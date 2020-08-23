import Exceptions.VariableHasNotValue;
import Expressions.Base.Expression;
import Expressions.Functions.Cos;
import Expressions.Functions.Ln;
import Expressions.Functions.Power;
import Expressions.Functions.Sin;
import Expressions.Primitives.BinaryOperations.Add;
import Expressions.Primitives.BinaryOperations.Div;
import Expressions.Primitives.BinaryOperations.Multiply;
import Expressions.Primitives.BinaryOperations.Sub;
import Expressions.Primitives.Variable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EvaluatesTest {

    private Variable x;
    private Variable y;
    private Variable z;

    @Before
    public void setup() {
        this.x = new Variable("x");
        this.y = new Variable("y");
        this.z = new Variable("z");
    }

    @Test(expected = VariableHasNotValue.class)
    public void When_VarNotSet_Except_VariableHasNotValueException() throws VariableHasNotValue {
        Expression simple = new Variable("simple");
        simple.eval();
    }


    @Test
    public void When_UsePrimitiveExpression_Except_CorrectValue() throws VariableHasNotValue {
        // (x-y) + (x-z)
        Expression addSub = new Add(new Sub(x, y), new Sub(x, z));
        x.setValue(1);
        y.setValue(2);
        z.setValue(3);
        Assert.assertEquals(-3, addSub.eval(), 1e-5);
        z.setValue(0);
        Assert.assertEquals(0, addSub.eval(), 1e-5);

        // (x-y) / ((x-z) * (z ^ 4))
        Expression complicated =  new Div(new Sub(x, y), new Multiply(new Sub(x, z), new Power(z, 4)));
        x.setValue(1);
        y.setValue(2);
        z.setValue(2);
        double res = 0.0625;
        Assert.assertEquals(res, complicated.eval(), 1e-5);

    }


    @Test
    public void When_Cos2PlusSin2_Except_One() throws VariableHasNotValue {

        Expression cos = new Cos(x);
        x.setValue(Math.PI / 2);
        Assert.assertEquals(cos.eval(), 0, 1e-5);

        Expression sin = new Sin(x);
        Assert.assertEquals(sin.eval(), 1, 1e-5);

        x.setValue(0.2);
        Assert.assertEquals(Math.pow(cos.eval(), 2) + Math.pow(sin.eval(), 2), 1, 1e-5);
    }

    @Test
    public void When_PowerOfLn() throws VariableHasNotValue{
        // ln(x ^ 4) ^ 3
        Expression lnExpr = new Power(new Ln(new Power(x, 4)), 3);
        x.setValue(Math.E);
        Assert.assertEquals(64, lnExpr.eval(), 1e-5);
    }
}
