package arraystack;

import java.util.EmptyStackException;

/**
 * Testing the ArrayBasedStack
 * 
 * @author AnthonyMerlin
 * @version 9.26.2022
 */
public class ArrayBasedStackTest extends student.TestCase {

    private ArrayBasedStack empty;
    private ArrayBasedStack stack1;
    private ArrayBasedStack stack2;
    private ArrayBasedStack stack3;
    private ArrayBasedStack stack4;
    private ArrayBasedStack not;


    /**
     * Set up test methods
     */
    public void setUp() {
        this.empty = new ArrayBasedStack<Integer>();
        this.stack1 = new ArrayBasedStack<Integer>();
        this.stack2 = new ArrayBasedStack<Integer>(10);
        this.stack3 = new ArrayBasedStack<Integer>();
        this.stack4 = new ArrayBasedStack<Integer>();
        this.not = null;
        for (int i = 0; i < 10; i++) {
            this.stack1.push(i);
            this.stack2.push(i);
            this.stack3.push(i * 2);
        }
        for (int i = 9; i >= 0; i--) {
            this.stack4.push(i);
        }

    }


    /**
     * Test ArrayBasedStack's isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(this.empty.isEmpty());
        assertEquals(this.empty.size(), 0, 0.01);
        this.empty.push(1);
        assertFalse(this.empty.isEmpty());
        assertEquals(this.empty.size(), 1, 0.01);
    }


    /**
     * Test ArrayBasedStack's peek method
     */
    public void testPeek() {
        assertTrue(this.stack1.peek().equals(9));
        this.stack1.pop();
        assertTrue(this.stack1.peek().equals(8));

        Exception thrown = null;
        try {
            this.empty.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * Test ArrayBasedStack's pop method
     */
    public void testPop() {
        assertEquals(this.stack1.size(), 10, 0.01);
        this.stack1.pop();
        assertEquals(this.stack1.size(), 9, 0.01);

        Exception thrown = null;
        try {
            this.empty.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * Test ArrayBasedStack's push method
     */
    public void testPush() {
        boolean notAdded = false;
        assertEquals(this.empty.size(), 0, 0.01);
        this.empty.push(null);
        if (this.empty.size() == 0) {
            notAdded = true;
        }
        assertTrue(notAdded);

        assertEquals(this.stack2.size(), 10, 0.01);
        this.stack2.push(10);
        assertEquals(this.stack2.size(), 11, 0.01);
    }


    /**
     * Test ArrayBasedStack's contains method
     */
    public void testContains() {
        this.empty.push(1);
        assertTrue(this.empty.contains(1));
        assertFalse(this.empty.contains(2));
        assertFalse(this.empty.contains(null));
    }


    /**
     * Test ArrayBasedStack's size method
     */
    public void testSize() {
        assertEquals(this.empty.size(), 0, 0.01);
        assertEquals(this.stack1.size(), 10, 0.01);
        this.empty.push(1);
        assertEquals(this.empty.size(), 1, 0.01);
    }


    /**
     * Test ArrayBasedStack's clear method
     */
    public void testClear() {
        assertEquals(this.stack1.size(), 10, 0.01);
        this.stack1.clear();
        assertEquals(this.stack1.size(), 0, 0.01);
        Exception thrown = null;
        try {
            this.stack1.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }


    /**
     * Test ArrayBasedStack's toArray method
     */
    public void testToArray() {
        int[] vals = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Object[] stackVals = stack1.toArray();
        assertEquals(vals.length, stackVals.length, 0.01);
        for (int i = 0; i < vals.length; i++) {
            assertEquals(vals[i], stackVals[i]);
        }
    }


    /**
     * Test ArrayBasedStack's toString method
     */
    public void testToString() {
        String strVal = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]";
        String stackVal = stack1.toString();
        assertEquals(strVal, stackVal);
        assertEquals(empty.toString(), "[]");
    }


    /**
     * Test ArrayBasedStack's equals method
     */
    public void testEquals() {
        assertTrue(this.stack1.equals(this.stack1));
        assertFalse(this.stack1.equals(not));
        assertFalse(this.stack1.equals(""));
        // If the size() of the stacks are different
        assertFalse(this.stack1.equals(this.empty));
        // If the size() of the stacks are same, but the elements are different,
        assertFalse(this.stack3.equals(this.stack1));
        // If the size() of the stacks are same and they have same elements, but
        // the order of the elements are different
        assertFalse(this.stack4.equals(this.stack1));
        // Comparing to an object which is equal, return true
        assertTrue(this.stack1.equals(this.stack2));

    }


    public void testDebuggerViews()

    {

        // Put a breakpoint on the line below

        ArrayBasedStack<String> testStack = new ArrayBasedStack<String>();

        // Put a breakpoint on the line below. Use Step Over to see each push.

        testStack.push("blizzard");

        testStack.push("barrage");

        testStack.push("deadeye");

        testStack.push("resurrect");

        assertTrue(testStack.toString().equals(
            "[blizzard, barrage, deadeye, resurrect]"));
        

        // Put a breakpoint on the line below. Hit Step Over once to watch the
        // pop.

        testStack.pop();

        assertTrue(testStack.toString().equals("[blizzard, barrage, deadeye]"));

        Object[] toArrayResult = testStack.toArray();

        // Drop a breakpoint on the line below.

        // Use the debugger mode to compare toArrayResult to testStack.

        assertTrue(toArrayResult[0].toString().equals("blizzard"));

        assertEquals(toArrayResult.length, 3);

        // The following test fails because the stack still has entries in it.
        // However,

        // "expected <true> but was: <false>" is not very helpful.

        // Drop a breakpoint on the line below to see what the toString SHOULD
        // look like.

        assertTrue(testStack.toString().equals("[]"));

    }

}

    