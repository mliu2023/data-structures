import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class ClacTests {
	Queue<String> tokenQueue;
	Stack<Integer> stack;
	Stack<Queue<String>> state;
	Stack<Integer> resultStack;
	Map<String, Queue<String>> dict;

	@Before // run before every test is called
	public void setup() {
		stack = new Stack<Integer>();
		state = new Stack<Queue<String>>();
		dict = new HashMap<String, Queue<String>>();
	}

	/* **************************** */
	/* ARITHMETIC EXPRESSIONS TESTS */
	/* **************************** */

  // EXAMPLE TEST 1 – Normal
	@Test
	public void a_testAddition_0() {
		// 1 -2 + 3 +
		// 2
		Logger.addTask(1, "(arithmetic expression)");
		Logger.addTest("addition-0");
		Logger.expectSuccess();

		// preparing the known test result
		tokenQueue = buildQueue("1 -2 + 3 +");
		resultStack = buildStack("2");

		// testing clac
		Clac.evaluate(tokenQueue, stack, state, dict);

		if(stack.equals(resultStack)) {
			// test succeeded
			Logger.pass();
			assertTrue(true);
		} else {
			Logger.wrongValue();
			assertTrue(false);
		}
	}

  // Think – what else might we need to test for addition?
  // Negative numbers? Multiple addition requests in one token queue?

  // EXAMPLE TEST 2 – Exception
  @Test
  public void a_testAddition_1() {
		// 2 +
		Logger.addTest("addition-1");
		Logger.expectException();

		tokenQueue = buildQueue("2 +");
		// no result stack, expecting exception

		boolean thrown = false;
		try {
			// statements
			Clac.evaluate(tokenQueue, stack, state, dict);
			Logger.noException();
		} catch (EmptyStackException e) {
			Logger.pass();
			thrown = true;
			// handle excepion
		}

		assertTrue(thrown);
  }
	// EXAMPLE TEST 3 – rotate and if
	@Test
	public void a_testRotate_0() {
		Logger.addTask(2, "(rotate, if)");
		Logger.addTest("Rotate & if-0");
		Logger.expectSuccess();

		// preparing the known test result
		tokenQueue = buildQueue("0 1 2 rot if 7 8 9 10 if");
		resultStack = buildStack("1 2");

		// testing clac
		Clac.evaluate(tokenQueue, stack, state, dict);

		if(stack.equals(resultStack)) {
			// test succeeded
			Logger.pass();
			assertTrue(true);
		} else {
			Logger.wrongValue();
			assertTrue(false);
		}
	}
	// EXAMPLE TEST 4 – skip and **
	@Test
	public void a_testSkip_0() {
		Logger.addTask(3, "(skip, **)");
		Logger.addTest("Skip and **-0");
		Logger.expectSuccess();

		// preparing the known test result
		tokenQueue = buildQueue("0 skip 2 skip 3 4 5 2 **");
		resultStack = buildStack("25");

		// testing clac
		Clac.evaluate(tokenQueue, stack, state, dict);

		if(stack.equals(resultStack)) {
			// test succeeded
			Logger.pass();
			assertTrue(true);
		} else {
			Logger.wrongValue();
			assertTrue(false);
		}
	}
	// EXAMPLE TEST 5 – Exception
  @Test
  public void a_Pick_0() {
		Logger.addTask(5, "(Pick)");
		Logger.addTest("Pick-0");
		Logger.expectException();

		tokenQueue = buildQueue("1 2 3 0 pick");
		// no result stack, expecting exception

		boolean thrown = false;
		try {
			// statements
			Clac.evaluate(tokenQueue, stack, state, dict);
			Logger.noException();
		} catch (EmptyStackException e) {
			Logger.pass();
			thrown = true;
			// handle excepion
		}

		assertTrue(thrown);
  }
	// EXAMPLE TEST 6 – Functions
	@Test
	public void a_testFunction_0() {
		Logger.addTask(4, "(Functions)");
		Logger.addTest("Functions-0");
		Logger.expectSuccess();

		// preparing the known test result
		tokenQueue = buildQueue(": convert 1 pick 2 / dec2bin 10 * swap 2 % + ; : dec2bin 1 pick if convert ; 37 dec2bin");
		resultStack = buildStack("100101");

		// testing clac
		Clac.evaluate(tokenQueue, stack, state, dict);

		if(stack.equals(resultStack)) {
			// test succeeded
			Logger.pass();
			assertTrue(true);
		} else {
			Logger.wrongValue();
			assertTrue(false);
		}
	}

	private static Queue<String> buildQueue(String code) {
		Queue<String> tokenQueue = new LinkedList<String>();

		for (String tok : code.split(" ")) {
			tokenQueue.offer(tok);
		}

		return tokenQueue;
	}

	private static Stack<Integer> buildStack(String stackString) {
		Stack<Integer> stack = new Stack<Integer>();

		for (String tok : stackString.split(" ")) {
			stack.push(Integer.parseInt(tok));
		}

		return stack;
	}
}
