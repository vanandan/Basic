import java.util.ArrayList;
import java.util.Iterator;

public class FibonacciSeries
{
	ArrayList<Integer> outputArray;

	public FibonacciSeries()
	{
		outputArray = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getFibonacci(int fibNum)
	{

		outputArray.add(0);
		if (fibNum == 0)
			return outputArray;

		outputArray.add(1);
		if (fibNum == 1)
			return outputArray;

		for (int i = 2; i < fibNum; i++)
		{
			outputArray.add(outputArray.get(i - 2) + outputArray.get(i - 1));
		}

		return outputArray;
	}

	public ArrayList<Integer> getFibonacciRecursion(int fibNum)
	{

		if (fibNum == 0)
		{
			this.outputArray.add(0);
			return this.outputArray;
		}

		if (fibNum == 1)
		{
			this.outputArray.add(0);
			this.outputArray.add(1);
			return this.outputArray;
		}

		this.outputArray.add(getFibRec(fibNum - 2) + getFibRec(fibNum - 1));

		return this.outputArray;
	}

	private int getFibRec(int fibNum)
	{
		if (fibNum == 1)
			return 1;

		if (fibNum == 0)
			return 0;

		return getFibRec(fibNum - 2) + getFibRec(fibNum - 1);
	}

	public String toString()
	{
		String outputStr = null;
		for (Integer i : outputArray)
		{
			outputStr = outputStr + i + " ";
		}
		return outputStr;

	}

}
