import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.lang.Math;
import java.util.EmptyStackException;

/**
* Clac interpreter
* @author Max Liu
* @version 1.0
*/
public class Clac{
	/**
	* This method checks if the string is a number so we can use Integer.parseInt()
	* @param s The string that is checked
	* @return true if s is a number, false otherwise.
	*/
	public static boolean isNumber(String s){
		if(s.length() == 0){
			return false;
		}
		for(int i = 0; i < s.length(); i++){
			if(i == 0 && (int)s.charAt(i) == 45){
				i++;
			}
			char x = s.charAt(i);
			int val = (int)x;
			if(x < 48 || x > 57){
				return false;
			}
		}
		return true;
	}
	/**
	* This method creates a deep copy of a queue.
	* @param q The queue that is copied.
	* @return A deep copy of the queue.
	*/
	public static Queue<String> copyQueue(Queue<String> q){
		Queue<String> tokenQueue = new LinkedList<String>();
		Queue<String> tokenQueue2 = new LinkedList<String>();
		while(q.peek() != null){
			String s = q.poll();
			tokenQueue.add(s);
			tokenQueue2.add(s);
		}
		while(tokenQueue2.peek() != null){
			q.add(tokenQueue2.poll());
		}
		return tokenQueue;
	}
	/**
	* This method transfers the elements of one queue to another queue.
	* @param q The queue whose elements are transferred.
	* @param other The queue where the elements are transferred.
	*/
	public static void transferQueue(Queue<String> q, Queue<String> other){
		while(q.peek() != null){
			other.add(q.poll());
		}
	}
	/**
	* This method evaluates what should be done based on the tokens in the tokenQueue.
	* @param tokenQueue The queue with tokens.
	* @param stack The stack of integers that are operated on.
	* @param state The stack of queues that need to be executed.
	* @param dict The map for function definitions.
	* @return true if the clac should continue, false if the user inputs "quit".
	*/
	public static boolean evaluate(Queue<String> tokenQueue, Stack<Integer> stack, Stack<Queue<String>> state, Map<String, Queue<String>> dict) {
		while(tokenQueue.peek() != null){
			String val = tokenQueue.poll();
			if(isNumber(val)){
				stack.push(Integer.parseInt(val));
			}
			else if(val.equals("+")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int a = stack.pop();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int b = stack.pop();
				stack.push(b+a);
			}
			else if(val.equals("*")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int a = stack.pop();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int b = stack.pop();
				stack.push(b*a);
			}
			else if(val.equals("-")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int a = stack.pop();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int b = stack.pop();
				stack.push(b-a);
			}
			else if(val.equals("/")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int a = stack.pop();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int b = stack.pop();
				stack.push(b/a);
			}
			else if(val.equals("%")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int a = stack.pop();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int b = stack.pop();
				stack.push(b%a);
			}
			else if(val.equals("**")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int a = stack.pop();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int b = stack.pop();
				stack.push((int)Math.pow(b,a));
			}
			else if(val.equals("<")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int a = stack.pop();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int b = stack.pop();
				if(a < b){
					stack.push(1);
				}
				else{
					stack.push(0);
				}
			}
			else if(val.equals("=")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int a = stack.pop();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int b = stack.pop();
				if(a == b){
					stack.push(1);
				}
				else{
					stack.push(0);
				}
			}
			else if(val.equals("drop")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				stack.pop();
			}
			else if(val.equals("swap")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int a = stack.pop();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int b = stack.pop();
				stack.push(a);
				stack.push(b);
			}
			else if(val.equals("rot")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int a = stack.pop();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int b = stack.pop();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int c = stack.pop();
				stack.push(b);
				stack.push(a);
				stack.push(c);
			}
			else if(val.equals("if")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int a = stack.pop();
				if(a == 0){
					tokenQueue.poll();
					tokenQueue.poll();
					tokenQueue.poll();
				}
			}
			else if(val.equals("pick")){
				Stack<Integer> s = new Stack();
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int n = stack.pop();
				if(n < 0){
					throw new IndexOutOfBoundsException();
				}
				for(int i = 0; i < n; i++){
					if(stack.empty()){
						throw new EmptyStackException();
					}
					s.push(stack.pop());
				}
				int a = s.peek();
				for(int j = 0; j < n; j++){
					stack.push(s.pop());
				}
				stack.push(a);
			}
			else if(val.equals("skip")){
				if(stack.empty()){
					throw new EmptyStackException();
				}
				int n = stack.pop();
				if(n < 0){
					throw new IndexOutOfBoundsException();
				}
				for(int i = 0; i < n; i++){
					tokenQueue.poll();
				}
			}
			else if(val.equals("quit")){
				return false;
			}
			else if(val.equals("print")){
				System.out.println(stack.peek());
			}
			else if(val.equals(":")){
				Queue<String> q = new LinkedList<String>();
				if(tokenQueue.peek() == null){
					throw new NullPointerException("No semicolon found");
				}
				String name = tokenQueue.poll();
				while(!tokenQueue.peek().equals(";")){
					if(tokenQueue.peek() == null){
						throw new NullPointerException("No semicolon found");
					}
					q.add(tokenQueue.poll());
				}
				dict.put(name, q);
			}
			else if(dict.containsKey(val)){
				Queue<String> q = new LinkedList<String>();
				if(tokenQueue.peek() != null){
					transferQueue(tokenQueue, q);
					state.push(q);
				}
				Queue<String> q2 = copyQueue(dict.get(val));
				transferQueue(q2, tokenQueue);
			}
			if(!state.empty()){
				Queue<String> x = state.pop();
				transferQueue(x, tokenQueue);
			}
		}
		return true;
	}

}
