package uvg.edu.gt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListStackTest {

    @Test
    public void testPush() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, stack.peek());
    }

    @Test
    public void testPop() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        stack.push(1);
        assertEquals(1, stack.peek());
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    public void testIsEmpty() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    public void testPopEmptyStack() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        Exception exception = assertThrows(IllegalStateException.class, stack::pop);
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    public void testPeekEmptyStack() {
        ArrayListStack<Integer> stack = new ArrayListStack<>();
        Exception exception = assertThrows(IllegalStateException.class, stack::peek);
        assertEquals("Stack is empty", exception.getMessage());
    }
}