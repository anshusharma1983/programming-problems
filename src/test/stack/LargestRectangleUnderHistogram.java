package test.stack;

import java.util.Stack;

/*
 http://www.geeksforgeeks.org/largest-rectangle-under-histogram/

 Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. 
 For simplicity, assume that all bars have same width and the width is 1 unit.

 For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 2, 6}. 
 The largest possible rectangle possible is 12 (see the below figure, the max area rectangle is highlighted in red)

 1) Create an empty stack.

 2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
 ...a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
 ...b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let the removed bar be hist[tp]. 
 Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).

 3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.


 */
public class LargestRectangleUnderHistogram {

	public static void main(String[] args) {
		int hist[] = {6, 2, 5, 4, 5, 1, 6};
		System.out.println(largestRectangle(hist));
	}

	public static int largestRectangle(int[] hist) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = -1, area = -1;
		int stackTop = -1;
		int i = 0;
		while (i < hist.length) {
			if (stack.isEmpty() || hist[i] >= stack.peek()) {
				// 2a
				stack.push(i++);
			}else {
				// 2b
				while(stack.peek() > hist[i]) {
					stackTop = stack.peek();
					area = hist[stackTop] * (i - stackTop);
					maxArea = (area > maxArea) ? area : maxArea; 
				}
			}
		}
		
		while (!stack.isEmpty()) {
			while(stack.peek() > hist[i]) {
				stackTop = stack.peek();
				area = hist[stackTop] * (i - stackTop);
				maxArea = (area > maxArea) ? area : maxArea; 
			}
		}
		return maxArea;
	}

}
