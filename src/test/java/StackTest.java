package uvg.edu.gt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());
    }

    @Test
    public void testPop() {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        assertEquals(1, stack.peek());
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    public void testIsEmpty() {
        Stack<Integer> stack = new Stack<>(5);
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        Stack<Integer> stack = new Stack<>(5);
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    public void testPushFullStack() {
        Stack<Integer> stack = new Stack<>(2);
        stack.push(1);
        stack.push(2);
        StackOverflowError exception = assertThrows(StackOverflowError.class, () -> {
            stack.push(3);
        });
        assertEquals("Stack is full", exception.getMessage());
    }

    @Test
    public void testPopEmptyStack() {
        Stack<Integer> stack = new Stack<>(5);
        IllegalStateException exception = assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    public void testPeekEmptyStack() {
        Stack<Integer> stack = new Stack<>(5);
        IllegalStateException exception = assertThrows(IllegalStateException.class, stack::peek);
        assertEquals("Stack is empty", exception.getMessage());
    }
}