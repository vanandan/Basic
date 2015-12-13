public class Factorial
{
	int factNum;
	
	public Factorial(int inputNum)
	{
		factNum = inputNum;
	}
	
	public Integer getFactorial()
	{
		if(factNum == 0 || factNum == 1)
			return 1;
		
		int factTotal = 1;
		for(int i=factNum; i>1; i--)
		{
			factTotal = factTotal * i;
		}
		return factTotal;
	}
	
	public Integer getFactorialRecursion(int factTotal)
	{
		if(factTotal == 1)
			return 1;
		else 
			return factTotal * getFactorialRecursion(factTotal-1);
	}

}
