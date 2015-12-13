import java.util.ArrayList;

import Common.CommonFunctions;

public class PalindromeNumber
{
	int positiveNumber;

	public PalindromeNumber(int userInput)
	{
		positiveNumber = userInput;
	}

	public boolean checkIfPalindrome()
	{
		
		if(positiveNumber<10)
			return true;
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		CommonFunctions cf = new CommonFunctions();
		arr = cf.getIntegerArrayList(positiveNumber);

		int numOfDigits = arr.size(); 
		
		for(int i = 0; i<numOfDigits/2; i++)
		{
			if(!arr.get(i).equals(arr.get((numOfDigits-i)-1)))
				return false;
		}

		return true;
	}

}
