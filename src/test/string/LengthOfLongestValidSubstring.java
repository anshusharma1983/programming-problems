package test.string;

import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/length-of-the-longest-valid-substring. <br>
 * Given a string consisting of opening and closing parenthesis, find length of
 * the longest valid parenthesis substring.<br>
 * 
 * Input : ((() Output : 2 Explanation : ()
 * 
 * Input: )()()) Output : 4 Explanation: ()()
 * 
 * Input: ()(())))) Output: 6 Explanation: ()(()))
 * 
 * @author hix-test
 * 
 * 
 */
public class LengthOfLongestValidSubstring {
	public static void main(String[] args) {
		System.out.println(longValidSubstring("((()".toCharArray()));
		System.out.println(longValidSubstring(")()())".toCharArray()));
		System.out.println(longValidSubstring("()(()))))".toCharArray()));
		System.out.println(longValidSubstring("()(()".toCharArray()));

	}

	// incorrect
	public static int longValidSubstring(char[] str) {
		int maxlen = 0;
		int idx = -1; // current valid string index
		int stack = 0;
		for (int i = 0; i < str.length; i++) {
			char c = str[i];
			if (c == '(') {
				if (stack == 0 && idx == -1) {
					idx = i;
				}
				stack++;
			} else if (c == ')'){
				if (stack > 0) {
					stack--;
					if (stack == 0) {
						if ((i - idx) > maxlen)
							maxlen = (i - idx) + 1;
					}
				} else
					idx = -1;
			}
		}
		return maxlen;
	}

	public static int longValidSubstring1(char[] str) {

		/**
		 * 1) Create an empty stack and push -1 to it. The first element of
		 * stack is used to provide base for next valid string.
		 * 
		 * 2) Initialize result as 0.
		 * 
		 * 3) If the character is '(' i.e. str[i] == '('), push index 'i' to the
		 * stack.
		 * 
		 * 2) Else (if the character is ')') <br>
		 * a) Pop an item from stack (Most of the time an opening bracket) <br>
		 * b) If stack is not empty, then find length of current valid substring
		 * by taking difference between current index and top of the stack. If
		 * current length is more than result, then update the result. <br>
		 * c) If stack is empty, push current index as base for next valid
		 * substring.
		 * 
		 * 3) Return result.
		 */
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int maxlen = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (!stack.isEmpty()) {
					int len = i - stack.peek();
					if (len > maxlen) {
						maxlen = len;
					}
				} else {
					stack.push(i);
				}
			}
		}

		return maxlen;

	}
}
