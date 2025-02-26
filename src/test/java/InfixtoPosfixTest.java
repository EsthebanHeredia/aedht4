package uvg.edu.gt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InfixtoPosfixTest {

    @Test
    public void testSimpleAddition() {
        IStack<Character> stack = new ArrayListStack<>();
        InfixtoPosfix converter = new InfixtoPosfix(stack);
        String result = converter.convert("3+4");
        assertEquals("3 4 +", result);
    }

    @Test
    public void testSimpleSubtraction() {
        IStack<Character> stack = new ArrayListStack<>();
        InfixtoPosfix converter = new InfixtoPosfix(stack);
        String result = converter.convert("10-5");
        assertEquals("10 5 -", result);
    }

    @Test
    public void testSimpleMultiplication() {
        IStack<Character> stack = new ArrayListStack<>();
        InfixtoPosfix converter = new InfixtoPosfix(stack);
        String result = converter.convert("2*3");
        assertEquals("2 3 *", result);
    }

    @Test
    public void testSimpleDivision() {
        IStack<Character> stack = new ArrayListStack<>();
        InfixtoPosfix converter = new InfixtoPosfix(stack);
        String result = converter.convert("8/2");
        assertEquals("8 2 /", result);
    }

    @Test
    public void testMixedOperators() {
        IStack<Character> stack = new ArrayListStack<>();
        InfixtoPosfix converter = new InfixtoPosfix(stack);
        String result = converter.convert("3+4*2");
        assertEquals("3 4 2 * +", result);
    }

    @Test
    public void testParentheses() {
        IStack<Character> stack = new ArrayListStack<>();
        InfixtoPosfix converter = new InfixtoPosfix(stack);
        String result = converter.convert("(3+4)*2");
        assertEquals("3 4 + 2 *", result);
    }

    @Test
    public void testNestedParentheses() {
        IStack<Character> stack = new ArrayListStack<>();
        InfixtoPosfix converter = new InfixtoPosfix(stack);
        String result = converter.convert("((3+4)*2)/5");
        assertEquals("3 4 + 2 * 5 /", result);
    }

    @Test
    public void testInvalidExpression() {
        IStack<Character> stack = new ArrayListStack<>();
        InfixtoPosfix converter = new InfixtoPosfix(stack);
        String result = converter.convert("(3+4");
        assertEquals("Invalid Expression", result);
    }

    @Test
    public void testExponentiation() {
        IStack<Character> stack = new ArrayListStack<>();
        InfixtoPosfix converter = new InfixtoPosfix(stack);
        String result = converter.convert("2^3");
        assertEquals("2 3 ^", result);
    }

    @Test
    public void testComplexExpression() {
        IStack<Character> stack = new ArrayListStack<>();
        InfixtoPosfix converter = new InfixtoPosfix(stack);
        String result = converter.convert("3+(4*5-2)/7");
        assertEquals("3 4 5 * 2 - 7 / +", result);
    }
}