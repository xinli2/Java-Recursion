/*
 * This file will hold all of your testcases. Remember, to run all
 * of your tests, right-click on 'RunTests.java' and select 'Run As' ->
 * JUnit Test.
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class RecursionTestClass {
	
	/*
	 * Here I have provided an example of one of the tests that I
	 * would write. For each of your tests, leave a brief comment
	 * above the test specifying its purpose. For example, for this
	 * test, I might write, "indexOf_test1 tests when s2 is not a 
	 * substring of s1. This should return -1."
	 */
    @Test
    public void test_indexOf_test1() {
        int result = Recursion.indexOf("Hello", "World");
        System.out.println("indexOf(Hello, World), got " + result);
        assertEquals(-1, result);
    }
    //test when s1 is empty
    @Test
    public void test_indexOf_test2() {
        int result = Recursion.indexOf("", "World");
        System.out.println("indexOf(, World), got " + result);
        assertEquals(-1, result);
    }
    //test when s2 is empty
    @Test
    public void test_indexOf_test3() {
        int result = Recursion.indexOf("Hello", "");
        System.out.println("indexOf(Hello, ), got " + result);
        assertEquals(-1, result);
    }
    //test when both are empty
    @Test
    public void test_indexOf_test4() {
        int result = Recursion.indexOf("", "");
        System.out.println("indexOf(, ), got " + result);
        assertEquals(-1, result);
    }
    //test when s2 longer than s1
    @Test
    public void test_indexOf_test5() {
        int result = Recursion.indexOf("Hello", "HelloWorld");
        System.out.println("indexOf(Hello, HelloWorld), got " + result);
        assertEquals(-1, result);
    }
    //test when s1 == s2
    @Test
    public void test_indexOf_test6() {
        int result = Recursion.indexOf("Hello", "Hello");
        System.out.println("indexOf(Hello, Hello), got " + result);
        assertEquals(0, result);
    }
    //test when s1 contains s2
    @Test
    public void test_indexOf_test7() {
        int result = Recursion.indexOf("HelloWorld", "World");
        System.out.println("indexOf(HelloWorld, World), got " + result);
        assertEquals(5, result);
    }
    
    //test when k < 0
    @Test
    public void test_removeEvenNumbers_test1() {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(1); stack.push(2); stack.push(2); stack.push(1); stack.push(2);
        int result = Recursion.removeEvenNumbers(stack, -1);
        System.out.println("removeEvenNumbers([1,2,2,1,2], -1), got " + result);
        System.out.println("Current stack: " + stack);
        assertEquals(0, result);
    }
    //test remove 1 even number
    @Test
    public void test_removeEvenNumbers_test2() {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(1); stack.push(2); stack.push(2); stack.push(1); stack.push(2);
        int result = Recursion.removeEvenNumbers(stack, 1);
        System.out.println("removeEvenNumbers([1,2,2,1,2], 1), got " + result);
        System.out.println("Current stack: " + stack);
        assertEquals(1, result);
    }
    //test remove 4 even numbers when there's only 3 even numbers
    @Test
    public void test_removeEvenNumbers_test3() {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(1); stack.push(2); stack.push(2); stack.push(1); stack.push(2);
        int result = Recursion.removeEvenNumbers(stack, 4);
        System.out.println("removeEvenNumbers([1,2,2,1,2], 4), got " + result);
        System.out.println("Current stack: " + stack);
        assertEquals(3, result);
    }
    //test empty stack
    @Test
    public void test_removeEvenNumbers_test4() {
    	Stack<Integer> stack = new Stack<Integer>();
        int result = Recursion.removeEvenNumbers(stack, 10);
        System.out.println("removeEvenNumbers([], 10), got " + result);
        System.out.println("Current stack: " + stack);
        assertEquals(0, result);
    }
    
    //test input only contains 1s and 0s
    @Test
    public void test_evenDigits_test1() {
        int result = Recursion.evenDigits(101010);
        System.out.println("evenDigits(101010), got " + result);
        assertEquals(0, result);
    }
    //test input is negative
    @Test
    public void test_evenDigits_test2() {
        int result = Recursion.evenDigits(-246);
        System.out.println("evenDigits(-246), got " + result);
        assertEquals(246, result);
    }
    //test input is positive
    @Test
    public void test_evenDigits_test3() {
        int result = Recursion.evenDigits(123456);
        System.out.println("evenDigits(123456), got " + result);
        assertEquals(246, result);
    }
    //test input is 0
    @Test
    public void test_evenDigits_test4() {
        int result = Recursion.evenDigits(0);
        System.out.println("evenDigits(0), got " + result);
        assertEquals(0, result);
    }
    
    //test empty queue
    @Test
    public void test_evaluate_test1() {
    	Queue<Character> queue = new LinkedList<Character>();
        int result = Recursion.evaluate(queue);
        System.out.println("evaluate([]), got " + result);
        System.out.println("Current queue: " + queue);
        assertEquals(0, result);
    }
    //test queue contains other characters
    @Test
    public void test_evaluate_test2() {
    	Queue<Character> queue = new LinkedList<Character>();
    	queue.add('a'); queue.add('b'); queue.add('c');
        int result = Recursion.evaluate(queue);
        System.out.println("evaluate([a,b,c]), got " + result);
        System.out.println("Current queue: " + queue);
        assertEquals(0, result);
    }
    //test queue only contains operators
    @Test
    public void test_evaluate_test3() {
    	Queue<Character> queue = new LinkedList<Character>();
    	queue.add('+');
        int result = Recursion.evaluate(queue);
        System.out.println("evaluate([+]), got " + result);
        System.out.println("Current queue: " + queue);
        assertEquals(0, result);
    }
    //test queue only contains number
    @Test
    public void test_evaluate_test4() {
    	Queue<Character> queue = new LinkedList<Character>();
    	queue.add('3');
        int result = Recursion.evaluate(queue);
        System.out.println("evaluate([3]), got " + result);
        System.out.println("Current queue: " + queue);
        assertEquals(3, result);
    }
    //test given example
    @Test
    public void test_evaluate_test5() {
    	Queue<Character> queue = new LinkedList<Character>();
    	String testcase = "(((1+2)*(3+1))+(1*(2+2)))";
    	for (int i = 0; i < testcase.length(); i++) {
    		queue.add(testcase.charAt(i));
    	}
        int result = Recursion.evaluate(queue);
        System.out.println("evaluate([(((1+2)*(3+1))+(1*(2+2)))]), got " + result);
        System.out.println("Current queue: " + queue);
        assertEquals(16, result);
    }
    
    //test empty stack
    @Test
    public void test_repeatStack_test1() {
    	Stack<Integer> stack = new Stack<Integer>();
        Recursion.repeatStack(stack);
        System.out.println("repeatStack([]), got " + stack);
        assertEquals(0, stack.size());
    }
    //normal test
    @Test
    public void test_repeatStack_test2() {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(1); stack.push(2); stack.push(3);
        Recursion.repeatStack(stack);
        System.out.println("repeatStack([1,2,3]), got " + stack);
        assertEquals(6, stack.size());
    }
    
    //normal test
    @Test
    public void test_doubleElements_test1() {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(1); queue.add(2); queue.add(3);
        Recursion.doubleElements(queue);
        System.out.println("doubleElements([1,2,3]), got " + queue);
        assertEquals(3, queue.size());
    }
    //test empty queue
    @Test
    public void test_doubleElements_test2() {
    	Queue<Integer> queue = new LinkedList<Integer>();
        Recursion.doubleElements(queue);
        System.out.println("doubleElements([]), got " + queue);
        assertEquals(0, queue.size());
    }
    //test queue only contains 0s and 1s
    @Test
    public void test_doubleElements_test3() {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(0); queue.add(0); queue.add(1); queue.add(1);
        Recursion.doubleElements(queue);
        System.out.println("doubleElements([0,0,1,1]), got " + queue);
        assertEquals(4, queue.size());
    }
}
