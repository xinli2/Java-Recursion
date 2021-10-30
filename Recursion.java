/*
 * There is no requirement for a file header comment for this 
 * assignment. Spend your time writing good testcases instead!
 */
import java.util.Queue;
import java.util.Stack;

public class Recursion {

	/**
	 * Write a recursive function that finds the index of s2 in s1. Do not use any
	 * string functions except for .length(), .equals(), and .substring(). Do not use
	 * any loops, or any data structures.
	 * @param s1
	 * @param s2
	 * @return Returns the index of the first time that
	 * 			s2 appears in s1 or -1 if s2 is not contained
	 * 			in s1.
	 */
	public static int indexOf(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0 ||
				s1.length() < s2.length()) {
			return -1;
		}
		else {
			String check = s1.substring(0, s2.length());
			if (check.equals(s2)) {
				return 0;
			}
			else if (indexOf(s1.substring(1), s2) != -1) {
				return 1 + indexOf(s1.substring(1), s2);
			}
		}
		return -1;
	}

	/**
	 * Write a recursive function that removes the first k even numbers
	 * from the stack. If there are less than k even elements in the stack,
	 * just remove all even elements. Do not use any loops or data structures
	 * other than the stack passed in as a parameter.
	 * @param stack
	 * @param k
	 * @return Returns the number of elements removed from the stack.
	 */
	public static int removeEvenNumbers(Stack<Integer> stack, int k) {
		if (stack.isEmpty() || k <= 0) {
			return 0;
		}
		else {
			if (stack.peek() % 2 == 0) {
				stack.pop();
				return 1 + removeEvenNumbers(stack, k - 1);
			}
			else {
				int temp = stack.pop();
				int count = removeEvenNumbers(stack, k);
				stack.push(temp);
				return count;
			}
		}
	}

	/**
	 * Write a recursive function that accepts an integer and
	 * returns a new number containing only the even digits, in the same
	 * order. If there are no even digits, return 0. Your function should
	 * work for positive or negative numbers. You are NOT allowed
	 * to use any data structures. You are not allowed to use Strings to
	 * solve this problem either.
	 * @param n
	 * @return The input with only the even digits remaining in the same
	 * order.
	 */
	public static int evenDigits(int n) {
		if (n < 0) {
			n = Math.abs(n);
		}
		if (n < 10) {
			if (n % 2 == 0) {
				return n;
			}
			else {
				return 0;
			}
		}
		else {
			int check = n % 10;
			if (check % 2 == 0) {
				return evenDigits(n / 10) * 10 + check;
			}
			else {
				return evenDigits(n / 10);
			}
		}
	}

	/**
	 * Write a recursive function that evaluates a Queue<Character> as a mathematical
	 * expression. This queue can have any of the following characters:
	 * { '(', ')', '+', '*'} or any single digit number. Evaluate this expression and
	 * return the result. For example, for the expression:
	 * "(((1+2)*(3+1))+(1*(2+2)))", each of these characters would be in the
	 * q. As you recursively evaluate characters from the expression, you will
	 * remove the characters from the q. After evaluating the above expression,
	 * you should return 16. You are guaranteed that there are NO two digit numbers,
	 * and that the expression is well formed (parenthesis match, etc...). Do not use any
	 * loops. Do not use any data structures besides the q passed in as a parameter.
	 * @param q
	 * @return The result of the mathematical expression.
	 */
	public static int evaluate(Queue<Character> q) {
		if (q.isEmpty()) {
			return 0;
		}
		else if ((int) q.peek() < 40 || (int) q.peek() > 57) {
			return 0;
		}
		else if (q.size() == 1) {
			if (Character.isDigit(q.peek())) {
				return Character.getNumericValue(q.remove());
			}
			else {
				return 0;
			}
		}
		else {
			if (q.peek() == '(') {
				q.remove();
				int left = evaluate(q);
				char operator = q.remove();
				int right = evaluate(q);
				q.remove();
				if (operator == '+') {
					return left + right;
				}
				else if (operator == '*') {
					return left * right;
				}
			}
			return Character.getNumericValue(q.remove());
		}
	}

	/**
	 * Write a recursive function that accepts a stack of integers and
	 * replaces each int with two copies of that integer. For example,
	 * calling repeatStack and passing in a stack of { 1, 2, 3} would change
	 * the stack to hold { 1, 1, 2, 2, 3, 3}. Do not use any loops. Do not use
	 * any data structures other than the stack passed in as a parameter.
	 * @param stack
	 */
	public static void repeatStack(Stack<Integer> stack) {
		if (!stack.empty()) {
			int temp = stack.pop();
			repeatStack(stack);
			stack.push(temp);
			stack.push(temp);
		}
	}

	/**
	 * Write a recursive function that accepts a Queue<Integer>. It
	 * should change every int in this queue to be double its original
	 * value. You may NOT use loops or any other data structures besides
	 * the queue passed in as a parameter. You may use a helper function.
	 * @param q
	 */
	public static void doubleElements(Queue<Integer> q) {
		if (!q.isEmpty()) {
			int length = q.size();
			doubleElementsHelper(q, length - 1);
		}
	}
	
	private static void doubleElementsHelper(Queue<Integer> q, int index) {
		if (index < 0) {
			return;
		}
		else {
			int doubleNum = q.remove() * 2;
			q.add(doubleNum);
			doubleElementsHelper(q, index - 1);
		}
	}

}
