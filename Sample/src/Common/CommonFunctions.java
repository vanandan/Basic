package Common;

import java.util.ArrayList;

public class CommonFunctions
{
	public ArrayList<Integer> getIntegerArrayList(int inputNumber)
	{
		ArrayList<Integer> outputArrayList = new ArrayList<Integer>();
		for (int i = 0;; i++)
		{
			if (inputNumber < 10)
			{
				outputArrayList.add(inputNumber);
				break;
			}

			outputArrayList.add(inputNumber % 10);
			inputNumber = inputNumber / 10;
		}
		return outputArrayList;
	}

}
