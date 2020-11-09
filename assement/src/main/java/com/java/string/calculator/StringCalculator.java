package com.java.string.calculator;

/**
 * Hello world!
 *
 */
public class StringCalculator 
{
	public int returnValue(String str)//method parses and returns the value of the current string
	{
		if(!str.isEmpty() && str.contains("\n"))//this snippet will handle the new line characters if any in the current string
		{
			int curr = 0;
			String[] lines = str.split("\n");
			for(String s:lines) 
			{
				curr += returnValue(s);
			}
			return curr;
		}
		return str.isEmpty()?0:Integer.parseInt(str);
	}

	public int add(String numbers)
	{
		int sum = 0;
		if(numbers.isEmpty())
		{
			return sum;
		}
		else if(numbers.indexOf(',') != -1)//this is for more than one number scenario
		{
			String[] strs = numbers.split(",");
			for(String s:strs) 
			{
				sum += returnValue(s);
			}
		}
		else//this is for single number scenario
		{
			return returnValue(numbers);
		}

		return sum;
	}
}
