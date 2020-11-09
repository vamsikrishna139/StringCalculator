package com.java.string.calculator;

public class StringCalculator {

	public int returnValue(String str)//method parses and returns the value of the current string
	{
		if(!str.isEmpty() && str.contains("\n"))//this snippet will handle the new line characters if any in the current string
		{
			String[] lines = str.split("\n");
			return calculateValue(lines);
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
		else if(numbers.indexOf("//") == 0)//this scenario handles the variable delimiter scenario
		{
			sum += variableDelimiter(numbers);
		}
		else if(numbers.indexOf(',') != -1)//this is for more than one number scenario
		{
			sum += calculateValue(numbers,",");
		}
		else//this is for single number scenario
		{
			return returnValue(numbers);
		}

		return sum;
	}

	public int calculateValue(String numbers, String delimiter) //utility method for various purposes
	{
		String[] strs = numbers.split(delimiter);
		return calculateValue(strs);
	}

	public int calculateValue(String[] numbers) //utility method for various purposes
	{
		int curr = 0;
		for(String s:numbers) 
		{
			curr += returnValue(s);
		}
		return curr;
	}

	private int variableDelimiter(String numbers)// this figures out the delimiter and then process the numbers string accordingly
	{
		String currDelimiter = numbers.substring(2,3);
		String[] splitLines = numbers.split("\n");
		int total = 0;

		for(int i=1;i<splitLines.length;i++)
		{
			String currLine = splitLines[i];
			if(!currLine.isEmpty())
			{
				if(currLine.contains(currDelimiter))
				{
					total = total + calculateValue(currLine,currDelimiter);
				}
				else//this means there's only one number in the current line of the string
				{
					total = total + Integer.parseInt(currLine);
				}
			}
		}

		return total;
	}
}