package com.java.string.calculator.test;

import org.junit.Before;
import org.junit.Test;
import com.java.string.calculator.StringCalculator;
import junit.framework.Assert;

public class StringCalculatorTest
{
	private StringCalculator calculator;

	@Before
	public void getInstance()
	{
		calculator = new StringCalculator();
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

}
