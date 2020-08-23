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
import Expressions.Primitives.Const;
import Expressions.Primitives.Variable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegrationTest {

    private Variable x;
    private Variable y;
    private Variable z;

    @Before
    public void setup() {
        this.x = new Variable("x");
        this.y = new Variable("y");
        this.z = new Variable("z");
    }

    @Test
    public void integrationTest1() throws VariableHasNotValue {
        // (Cos(x) - 1) / y
        Expression expression = new Div(new Sub(new Cos(x), new Const(1)), y);

        y.setValue(2);
        Expression dx = expression.deriv(x);
        x.setValue(0);
        Assert.assertEquals(0, dx.eval(), 1e-5);
        x.setValue(Math.PI/2);
        Assert.assertEquals(-.5, dx.eval(), 1e-5);

        Expression dy = expression.deriv(y);
        x.setValue(Math.PI/2);
        y.setValue(4);
        Assert.assertEquals(0.0625, dy.eval(), 1e-5);
    }

    @Test
    public void integrationTest2() throws VariableHasNotValue {
        // tan(x) + sin(x/y)^3 + cos(z) * sin(x)
        Expression tan = new Div(new Sin(x), new Cos(x));
        Expression expression = new Add(tan, new Add(
                new Power(new Sin(new Div(x, y)), 3),
                new Multiply(new Cos(z), new Sin(x))
        ));

        Expression dx = expression.deriv(x);
        //Should be:  (1/cos(x))^2 + (3 *(sin(x/y) ^ 2) * cos(x/y)) / y + cos(z)*cos(x)
        x.setValue(1);
        y.setValue(2);
        z.setValue(3);
        Assert.assertEquals(3.193190, dx.eval(), 1e-5);
    }

    @Test
    public void integrationTest3() throws VariableHasNotValue {
        // ln( (x+y) ^ 3 / (cos x + sin (x/y) )
        Expression expression = new Ln(new Div(
                new Power(new Add(x, y), 3),
                new Add(new Cos(x), new Sin(new Div(x, y)))
        ));

        Expression dx = expression.deriv(x);
        // Should be: (y(x+y)sin(x) + 3y*sin(x/y) + 3y*cos(x) - (x+y)*cos(x/y)) / (y(x+y)(sin(x/y) + cos(x)))
        x.setValue(2);
        y.setValue(4);
        Assert.assertEquals(11.402590, dx.eval(), 1e-5);


        Expression dy = expression.deriv(y);
        // Should be: (3(y^2)(sin(x/y) + cos(x)) + x*cos(x/y)(x+y)) / ((y^2)(x+y)(sin(x/y) + cos(x)))
        x.setValue(12);
        y.setValue(10);
        Assert.assertEquals(0.1608487, dy.eval(), 1e-5);
    }
}
