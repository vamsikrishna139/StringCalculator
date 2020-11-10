package com.java.string.calculator.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.java.string.calculator.StringCalculator;

import junit.framework.Assert;

public class StringCalculatorTest
{
	public static int currCount = 0;
	public StringCalculator calculator;

	@Before
	public void getInstance()
	{
		calculator = new StringCalculator();
	}

	@After
	public void incremetCounter()
	{
		currCount = currCount + calculator.getCalledCount();
	}

	@Test
	public void testEmptyString()
	{
		int result = calculator.add("");
		Assert.assertEquals(0, result);
	}
	@Test
	public void testSimpleNumbers()
	{
		int result = calculator.add("1,2");
		Assert.assertEquals(3, result);
	}

	@Test
	public void testSingleNumber()
	{
		int result = calculator.add("1");
		Assert.assertEquals(1, result);
	}

	@Test
	public void testCommaSeperatedString()
	{
		int result = calculator.add("1,2,3");
		Assert.assertEquals(6, result);
	}

	@Test
	public void testCommaSeperatedStringWithEmptySpacesTest1()
	{
		int result = calculator.add("1,,3");
		Assert.assertEquals(4, result);
	}

	@Test
	public void testCommaSeperatedStringWithEmptySpacesTest2()
	{
		int result = calculator.add("1,");
		Assert.assertEquals(1, result);
	}

	@Test
	public void testCommaSeperatedStringWithEmptySpacesTest3()
	{
		int result = calculator.add(",3");
		Assert.assertEquals(3, result);
	}

	@Test
	public void testCommaSeperatedWithNewLineTest()
	{
		int result = calculator.add("1\n2,3");
		Assert.assertEquals(6, result);
	}

	@Test
	public void testCommaSeperatedWithNewLineTest1()
	{
		int result = calculator.add("1\n2,3\n4,5,6\n7,9");
		Assert.assertEquals(37, result);
	}

	@Test
	public void testCommaSeperatedWithNewLineTest2()
	{
		int result = calculator.add("10\n,3\n5,6");
		Assert.assertEquals(24, result);
	}

	@Test
	public void testCommaSeperatedWithNewLineTest3()
	{
		int result = calculator.add("10\n,3\n5,");
		Assert.assertEquals(18, result);
	}

	@Test
	public void testCommaSeperatedWithNewLineTest4()
	{
		int result = calculator.add("10\n3\n5");
		Assert.assertEquals(18, result);
	}

	@Test
	public void testVariableDelimiterTest1()
	{
		int result = calculator.add("//:\n1:2:4:5");
		Assert.assertEquals(12, result);
	}

	@Test
	public void testVariableDelimiterTest2()
	{
		int result = calculator.add("//:\n1:2:4:5\n6:7:");
		Assert.assertEquals(25, result);
	}

	@Test
	public void testVariableDelimiterTest3()
	{
		int result = calculator.add("//:\n1:2::5\n6:7:");
		Assert.assertEquals(21, result);
	}

	@Test
	public void testVariableDelimiterTest4()
	{
		int result = calculator.add("//;\n1;2;;5\n6;7;");
		Assert.assertEquals(21, result);
	}

	@Test
	public void testNegativeNumberTest()
	{
		int result = calculator.add("//;\n1;2;4;-5\n6;7;8;0\n9");
		Assert.assertEquals(32, result);
	}

	@Test
	public void testNegativeNumberTest1()
	{
		int result = calculator.add("//;\n1;2;4;\n5\n6;7;8;0\n9;-10");
		Assert.assertEquals(32, result);
	}

	@Test
	public void testMultipleNegativeNumbersTest()
	{
		int result = calculator.add("//;\n1;2;4;\n5\n6;-7;8;0\n9;-10");
		Assert.assertEquals(18, result);
	}

	@Test
	public void testMultipleNegativeNumbersTest1()
	{
		int result = calculator.add("-1\n2,-3\n4");
		Assert.assertEquals(2, result);
	}

	@Test
	public void testMultipleNegativeNumbersTest2()
	{
		int result = calculator.add("//;\n1;2;-4;5\n6;-7;8;0\n-9");
		Assert.assertEquals(2, result);
	}

	@Test
	public void testIgnoreNumberGreaterThan1000()
	{
		int result = calculator.add("1,1000,3");
		Assert.assertEquals(4, result);
	}

	@Test
	public void testVariableDelimiterLengthTest()
	{
		int result = calculator.add("//[*]\n1*2**3***4****5");
		Assert.assertEquals(15, result);
	}
	
	@Test
	public void testVariableDelimiterLengthTest1()
	{
		int result = calculator.add("//[*]\n1*2**3***4****-5");
		Assert.assertEquals(5, result);
	}
	
	@Test
	public void testVariableDelimiterLengthTest2()
	{
		int result = calculator.add("//[*]\n1*2**3***4****-5**1000*");
		Assert.assertEquals(5, result);
	}
	
	@AfterClass
	public static void testCountInvocations()
	{
		int result = currCount;
		Assert.assertEquals(25, result);
	}

}
