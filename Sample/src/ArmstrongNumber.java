import java.util.ArrayList;

import Common.CommonFunctions;

public class ArmstrongNumber
{
	int threeDigitNum;

	public ArmstrongNumber(int userInput)
	{
		threeDigitNum = userInput;
	}
	
	public boolean isArmstrong()
	{
		if(threeDigitNum<100 || threeDigitNum>999)
			return false;
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		CommonFunctions cf = new CommonFunctions();
		
		arr = cf.getIntegerArrayList(threeDigitNum);
		
		if((int)(Math.pow(arr.get(0), 3) + Math.pow(arr.get(1), 3) + Math.pow(arr.get(2), 3)) == threeDigitNum)
			return true;
		else
			return false;
	}

}
