package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Triangle;

class TriangleTest {

	//Three integers tests
	//SetCurrentType Tests
	
	// All three sides equal tests
	@Test
	@DisplayName("Triangle with 1cm on each side should be an Equilateral")
	void oneOneOneShouldReturnEquiltest() {
		Triangle triangle = new Triangle(1,1,1);
		assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
	}
	@Test
	@DisplayName("Triangle with 999cm on each side should be an Equilateral")
	void ninenundredninetynineThreeTimesShouldReturnEquiltest() {
		Triangle triangle = new Triangle(999,999,999);
		assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
	}
	
	// One side longer than the others combined tests
	@Test
	@DisplayName("3,1,1 isnt a trianle")
	void threeOneOneShouldReturnNull() {
		Triangle triangle = new Triangle(3,1,1);
		assertNull(triangle.getCurrent_type());
	}
	@Test
	void oneThreeOneShouldReturnNull() {
		Triangle triangle = new Triangle(1,3,1);
		assertNull(triangle.getCurrent_type());
	}
	@Test
	void oneOneThreeShouldReturnNull() {
		Triangle triangle = new Triangle(1,1,3);
		assertNull(triangle.getCurrent_type());
	}

	
	// One side equal to other sides combined tests
	@Test
	@DisplayName("1,2,3 isnt a trianle")
	void oneTwoThreeShouldReturnNull() {
		Triangle triangle = new Triangle(1,2,3);
		assertNull(triangle.getCurrent_type());
	}
	@Test
	void twoOneOneShouldReturnNull() {
		Triangle triangle = new Triangle(2,1,1);
		assertNull(triangle.getCurrent_type());
	}
	@Test
	void oneTwoOneShouldReturnNull() {
		Triangle triangle = new Triangle(1,2,1);
		assertNull(triangle.getCurrent_type());
	}
	@Test
	void oneOneTwoShouldReturnNull() {
		Triangle triangle = new Triangle(1,1,2);
		assertNull(triangle.getCurrent_type());
	}
	
	// One side equal zero tests
	@Test
	@DisplayName("1,0,1 isnt a trianle")
	void oneZeroOneShouldReturnNull() {
		Triangle triangle = new Triangle(1,0,1);
		assertNull(triangle.getCurrent_type());
	}
	@Test
	void ZeroOneOneShouldReturnNull() {
		Triangle triangle = new Triangle(0,1,1);
		assertNull(triangle.getCurrent_type());
	}
	@Test
	void oneOneZeroShouldReturnNull() {
		Triangle triangle = new Triangle(1,1,0);
		assertNull(triangle.getCurrent_type());
	}
	@Test
	void zeroZeroZeroShouldReturnNull() {
		Triangle triangle = new Triangle(0,0,0);
		assertNull(triangle.getCurrent_type());
	}
	
	// One side negative numbers tests
	@Test
	@DisplayName("-1,1,1 isnt a trianle")
	void minusOneOneOneShouldReturnNull() {
		Triangle triangle = new Triangle(-1,1,1);
		assertNull(triangle.getCurrent_type());
	}
	@Test
	void oneMinusOneOneShouldReturnNull() {
		Triangle triangle = new Triangle(1,-1,1);
		assertNull(triangle.getCurrent_type());
	}
	@Test
	void oneOneMinusOneShouldReturnNull() {
		Triangle triangle = new Triangle(1,1,-1);
		assertNull(triangle.getCurrent_type());
	}	
	@Test
	void minusMinusMinusShouldReturnNull() {
		Triangle triangle = new Triangle(-1,-1,-1);
		assertNull(triangle.getCurrent_type());
	}
	
	// No sides equal tests
	@Test
	@DisplayName("2,3,4 is a Scalene")
	void oneTwoThreeShouldReturnScaleneTest() {
		Triangle triangle = new Triangle(2,3,4);
		assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
	}
	@Test
	void onehundredFiveOnehundredfourShouldReturnScaleneTest() {
		Triangle triangle = new Triangle(100,5,104);
		assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
	}
	
	// Two sides equal test
	@Test
	@DisplayName("2,2,3 is a Isosceles")
	void twoTwoThreeShouldReturnIsoscelesTest() {
		Triangle triangle = new Triangle(2,2,3);
		assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
	}
	@Test
	void fourThreeThreeShouldReturnIsoscelesTest() {
		Triangle triangle = new Triangle(4,3,3);
		assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
	}
	@Test
	void twentyThirtyfourTwentyShouldReturnIsoscelesTest() {
		Triangle triangle = new Triangle(20,34,20);
		assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
	}
	
	//toString tests
	@Test
	@DisplayName("-1,-1,-1 to string test")
	void typeIsNullToStringTest() {
		Triangle triangle = new Triangle(-1,-1,-1);
		assertEquals("-1, -1, -1, This is not a triangle", triangle.toString());
	}
	@Test
	void typeIsEquilateralToStringTest() {
		Triangle triangle = new Triangle(3333,3333,3333);
		assertEquals("3333, 3333, 3333, This is a Equilateral triangle", triangle.toString());
	}
	@Test
	void typeIsScaleneToStringTest() {
		Triangle triangle = new Triangle(15,16,17);
		assertEquals("15, 16, 17, This is a Scalene triangle", triangle.toString());
	}
	@Test
	void typeIsIsoscelesToStringTest() {
		Triangle triangle = new Triangle(15,16,15);
		assertEquals("15, 16, 15, This is a Isosceles triangle", triangle.toString());
	}
	
	// String Array Tests
	
	// Successful states tests
	@Test 
	@DisplayName("12,12,12 is a Equilateral")
	void typeIsEquilateralArrayTest() {
		String[] in = {"12","12","12"};
		Triangle triangle = new Triangle(in);
		assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
	}
	@Test 
	void typeIsScaleneArrayTest() {
		String[] in = {"12","13","14"};
		Triangle triangle = new Triangle(in);
		assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
	}
	@Test 
	void typeIsIsoscelesArrayTest() {
		String[] in = {"12","14","14"};
		Triangle triangle = new Triangle(in);
		assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
	}
	@Test 
	void typeIsNullArrayTest() {
		String[] in = {"-14","-14","14"};
		Triangle triangle = new Triangle(in);
		assertNull(triangle.getCurrent_type());
	}
	
	// Array Length tests
	@Test 
	void arrayLengthIsThreeTest() {
		String[] in = {"12","13","14"};
		assertNotNull(new Triangle(in).getCurrent_type());
		assertDoesNotThrow(() -> new Triangle(in));
	}
	@Test 
	@DisplayName("12,12 isnt a trianle")
	void arrayLengthIsTwoTest() {
		String[] in = {"12","13"};
		Triangle triangle = new Triangle(in);
		assertNull(triangle.getCurrent_type());
		assertDoesNotThrow(() -> new Triangle(in));
	}
	@Test 
	void arrayLengthIsFourTest() {
		String[] in = {"12","13","14","15"};
		Triangle triangle = new Triangle(in);
		assertNull(triangle.getCurrent_type());
		assertDoesNotThrow(() -> new Triangle(in));
	}	
	
	// Array contains Wrong symbols
	@Test 
	@DisplayName("12,13,f isnt a trianle")
	void arrayContainsFTest() {
		String[] in = {"12","13","f"};
		assertThrows(NumberFormatException.class, () -> new Triangle(in));
	}	
	@Test 
	void arrayContainsSpaceTest() {
		String[] in = {"12","12"," 12"};
		assertThrows(NumberFormatException.class, () -> new Triangle(in));
	}	
	@Test 
	void arrayContainsSpaceTest2() {
		String[] in = {"12","12"," 12"};
		Triangle triangle = new Triangle(in);
		assertNotEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
	}	
	@Test
	void arrayContainsDecimalTest() {
		String[] in = {"12","13,5","12"};
		assertThrows(NumberFormatException.class, () -> new Triangle(in));
	}	
	@Test
	void arrayContainsAmericanDecimalTest() {
		String[] in = {"12","13.5","12"};
		assertThrows(NumberFormatException.class, () -> new Triangle(in));
	}	
	
	// Empty constructor test
	// getUserInput
	
	@Test
	void typeIsEquilateralUserInputTest() {
		String data = "1,1,1";
		Triangle triangle = new Triangle();
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		triangle.getUserInput();
		assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
	}
	@Test
	void typeIsScaleneUserInputTest() {
		String data = "100,101,59";
		Triangle triangle = new Triangle();
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		triangle.getUserInput();
		assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type());
	}
	@Test
	void typeIsIsoscelesUserInputTest() {
		String data = "59,101,59";
		Triangle triangle = new Triangle();
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		triangle.getUserInput();
		assertEquals(Triangle.TYPE.ISOSCELES, triangle.getCurrent_type());
	}
	@Test
	void typeIsNullUserInputTest() {
		String data = "59,200,59";
		Triangle triangle = new Triangle();
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		triangle.getUserInput();
		assertNull(triangle.getCurrent_type());
	}
	
	// User input contains wrong symbols
	@Test
	void userInputContainsGTest() {
		String data = "59,G,59";
		Triangle triangle = new Triangle();
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		assertThrows(NumberFormatException.class, ()-> triangle.getUserInput());
	}
	@Test
	void userInputContainsSpaceTest() {
		String data = "59, 59,59";
		Triangle triangle = new Triangle();
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		assertThrows(NumberFormatException.class, ()-> triangle.getUserInput());
	}
	@Test
	void userInputContainsSpaceTest2() {
		String data = "59, 59,59";
		Triangle triangle = new Triangle();
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		triangle.getUserInput();
		assertNotEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
	}
	@Test
	void userInputContainsAmericanDecimalTest() {
		String data = "3.3,3,3";
		Triangle triangle = new Triangle();
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		assertThrows(NumberFormatException.class, ()-> triangle.getUserInput());
	}
	
	// user input length tests
	@Test
	void userInputThreeCommasTest() {
		String data = "3,3,3,3";
		Triangle triangle = new Triangle();
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		assertDoesNotThrow(()-> triangle.getUserInput());
		assertNull(triangle.getCurrent_type());
		}
	@Test
	void userInputOneCommaTest() {
		String data = "59,59";
		Triangle triangle = new Triangle();
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		assertDoesNotThrow(()-> triangle.getUserInput());
		assertNull(triangle.getCurrent_type());
	}
	@Test
	void userInputFourCommasTest() {
		String data = "3,3,3,3,3";
		Triangle triangle = new Triangle();
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		Scanner scanner = new Scanner(System.in);
		assertDoesNotThrow(()-> triangle.getUserInput());
		assertNull(triangle.getCurrent_type());
		}

}