package com.java.string.calculator;

import java.util.ArrayList;
import java.util.List;

import com.java.string.calculator.exception.NegativeNumberException;

public class StringCalculator {

	public List<Integer> negatives = new ArrayList<Integer>();

	public boolean isNegatives = false;

	public int convertStringToInteger(String str)//method parses and returns the value of the current string
	{
		int currValue = 0;
		if(!str.isEmpty() && str.contains("\n"))//this snippet will handle the new line characters if any in the current string
		{
			String[] lines = str.split("\n");
			return calculateTotalValue(lines);
		}

		if(!str.isEmpty())
		{
			currValue = Integer.parseInt(str);
			if(currValue < 0)//if the current number is negative, add them to the list, which will be handled later
			{
				isNegatives = true;
				negatives.add(currValue);
			}
		}
		return currValue;//returns 0 for an empty string
	}

	public int processString(String numbers)
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
			sum =  convertStringToInteger(numbers);
		}

		return sum;
	}
	public int add(String numbers)
	{
		int sum = 0;
		sum = processString(numbers);

		if(isNegatives)
		{
			try
			{
				throw new NegativeNumberException("negatives not allowed:" + negatives.toString());
			} 
			catch (NegativeNumberException e) 
			{
				e.printStackTrace();
				isNegatives = false;// resetting th values once the exception is thrown
				negatives.clear();
			}
		}

		return sum;
	}

	public int calculateValue(String numbers, String delimiter) //utility method for various purposes
	{
		String[] strs = numbers.split(delimiter);
		return calculateTotalValue(strs);
	}

	public int calculateTotalValue(String[] numbers) //utility method for various purposes
	{
		int curr = 0;
		for(String s:numbers) 
		{
			curr += convertStringToInteger(s);
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
					total = total + convertStringToInteger(currLine);
				}
			}
		}

		return total;
	}
}