package com.java.string.calculator;

/**
 * Hello world!
 *
 */
public class StringCalculator 
{
	public int add(String numbers)
	{
		int sum = 0;
		if(numbers.isEmpty())
		{
			return 0;
		}
		else if(numbers.indexOf(',') != -1)
		{
			String[] strs = numbers.split(",");
			for(String s:strs)
			{
				sum = sum + Integer.parseInt(s);
			}
		}
		else
		{
			sum = Integer.parseInt(numbers);
			return sum;
		}

		return sum;
	}
}
