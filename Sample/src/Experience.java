import java.util.Scanner;

import Common.GetUserInput;
import CustomException.InvalidEntryException;

public class Experience
{
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{

		// System.out.println("Hello World!");
		// new CollectionTesting();

		String toContinue = "y";
		// int userPrime;

		// int userNaturalNumEntry;
		int userProgramChoice;

		
		while (toContinue.equalsIgnoreCase("y"))
		{


			try
			{
				userProgramChoice = new GetUserInput()
				.getNaturalNumberInput(""
						+ "What would you like to test? Type the Option Number"
						+ "\n 1. Check for Prime \n 2. Check for number Palindrome"
						+ "\n 3. Check if Armstrong number "
						+ "\n 4. Factorial - Regular \n 5. Factorial - Recursion "
						+ "\n 6. Fibonacci - Regular \n 7. Fibonacci - Recursion "
						+ "\n 8. String permutation \n 9. String substitute blank spaces"
						+ "\n 10. String reverse \n 11. String compression"
						+ "\n 12. Linked List functions  "
						);

				switch (userProgramChoice)
				{
					case 1:
					{
						prime();
						break;
					}
	
					case 2:
					{
						palindromeNumber();
						break;
					}
					case 3:
					{
						armstrongNumber();
						break;
					}
					case 4:
					{
						factorialRegular();
						break;
					}
					case 5:
					{
						factorialRecursion();
						break;
					}
					case 6:
					{
						fibonacciRegular();
						break;
					}
					case 7:
					{
						fibonacciRecursion();
						break;
					}
					case 8:
					{
						stringPermutation();
						break;
					}
					case 9:
					{
						stringSubBlankSpaces();
						break;
					}
					case 10:
					{
						stringReverse();
						break;
					}
					case 11:
					{
						stringCompress();
						break;
					}
					case 12:
					{
						linkedList();
						break;
					}
					default:
					{
						System.out.println("Please enter a valid option.");
					}
				}
			}
			catch (InvalidEntryException e)
			{
				System.out.println("You STUPID! Invalid entry: " + e.getEntry());
				e.printStackTrace();
			}

			toContinue = new GetUserInput()
					.getStringInput("Do you want to continue? (Y/N)");
		}

		System.out.println("You typed " + toContinue + ". Program exits.");
	}
		


	private static void linkedList() throws InvalidEntryException
	{
		LinkedListVA ll = new LinkedListVA();
		String continueLLOps = "y";
		int userChoice;
		do
		{
			userChoice = new GetUserInput()
			.getNaturalNumberInput(""
					+ "What would you like to do? Type the Option Number"
					+ "\n 1. Add to LL \n 2. Add to LL at index pos"
					+ "\n 3. Delete Node (tail) \n 4. Delete Node at index position "
					+ "\n 5. Remove Duplicates v1 \n 6. Remove Duplicates v2 "
					+ "\n 7. Remove Duplicates v3 \n 8. Display List "
					);

			switch (userChoice)
			{
				case 1:
				{
					int listValue;
					System.out.println("Please enter the number to be added to the tail");
					
					Scanner sc = new Scanner(System.in);
					listValue = sc.nextInt();
					
					ll.addNode(listValue);
					break;
				}
				case 2:
				{
					int listValue;
					int listIndex;
					
					System.out.println("Please enter the number to be added");
					Scanner sc = new Scanner(System.in);
					listValue = sc.nextInt();
					
					System.out.println("Please enter the index position");
//					Scanner sc = new Scanner(System.in);
					listIndex = sc.nextInt();
					
					ll.addNode(listIndex, listValue);
					break;
				}
				case 3:
				{
					System.out.println("Deleting tail node");
					ll.deleteNode();
					break;
				}
				case 4:
				{
					int listIndex;
					
					System.out.println("Please enter the index position");
					Scanner sc = new Scanner(System.in);
					listIndex = sc.nextInt();
					
					ll.deleteNode(listIndex);
					break;
				}
				case 5:
				{
					ll.removeDuplicatesV1();
					break;
				}
				case 6:
				{
					ll.removeDuplicatesV2();
					break;
				}
				case 7:
				{
					ll.removeDuplicatesV3();
					break;
				}
				case 8:
				{
					ll.printList();
					break;
				}

			}
			
			continueLLOps = new GetUserInput()
			.getStringInput("Do you want to continue? ('N' to exit)");
			
		}while(!continueLLOps.equalsIgnoreCase("n"));
		
		System.out.println("You requested to exit. Back to Main Menu");
		System.out.println("testing GIT");
		System.out.println("Testing GIT from home laptop");
		
	}



	private static void stringCompress()
	{
		char[] inputCharArray;
		System.out.println("Please the character array: ");
		Scanner sc = new Scanner(System.in);
		inputCharArray = sc.nextLine().toString().toCharArray();
		
		StringFunctions sf = new StringFunctions();
		System.out.println(sf.stringCompress(inputCharArray));
		
	}



	private static void stringReverse()
	{
		char[] inputCharArray;
		System.out.println("Please the character array, with blanks spaces: ");
		Scanner sc = new Scanner(System.in);
		inputCharArray = sc.nextLine().toString().toCharArray();
		
		StringFunctions sf = new StringFunctions();
		System.out.println(sf.stringSubstituteSpaces(inputCharArray));
	}



	private static void stringSubBlankSpaces()
	{
		char[] inputCharArray;
		char[] outputCharArray;
		System.out.println("Please the character array, with blanks spaces: ");
		Scanner sc = new Scanner(System.in);
		inputCharArray = sc.nextLine().toString().toCharArray();
		System.out.println("Please enter the number of non blank space letters in the array: ");

		StringFunctions sf = new StringFunctions();

		outputCharArray = sf.stringSubstituteSpaces(inputCharArray, sc.nextInt());
		System.out.println(outputCharArray);
		
	}



	private static void stringPermutation()
	{
		String s1, s2 = "";
		System.out.println("Please enter the first string: ");
		Scanner sc = new Scanner(System.in);
		s1 = sc.next().toString().toLowerCase();
		
		System.out.println("Please enter the second string: ");
		s2 = sc.next().toString().toLowerCase();
		
		StringFunctions sf = new StringFunctions();
		
		if(s1.length() != s2.length())
		{
			System.out.println("Not a permutation");
			return;
		}

		if(sf.stringStrictPermutations(s1, s2))
			System.out.println("Strings are permutations of each other");
		else
			System.out.println("Not a permutation");
		
	}



	private static void fibonacciRecursion() throws InvalidEntryException
	{
		int fibNum;
		try
		{
			fibNum = new GetUserInput().getNaturalNumberInput("7. Fibonacci - Recursion. Please enter a Positive Integer:");
			FibonacciSeries fib = new FibonacciSeries();
			System.out.println("The Fibonacci Series of " + fibNum + " is " + fib.getFibonacciRecursion(fibNum).toString());
		}
		catch (InvalidEntryException e)
		{
			throw e;
		}
		
	}



	private static void fibonacciRegular() throws InvalidEntryException
	{
		int fibNum;
		try
		{
			fibNum = new GetUserInput().getNaturalNumberInput("6. Fibonacci - Regular. Please enter a Positive Integer:");
			FibonacciSeries fib = new FibonacciSeries();
			System.out.println("The Fibonacci Series of " + fibNum + " is " + fib.getFibonacci(fibNum).toString());
		}
		catch (InvalidEntryException e)
		{
			throw e;
		}
		
	}



	private static void factorialRecursion() throws InvalidEntryException
	{
		int factNum;
		try
		{
			factNum = new GetUserInput().getNaturalNumberInput("5. Factorial - Recursion. Please enter a Natural Number (integer):");
			Factorial fact = new Factorial(factNum);
			System.out.println("The Factorial of " + factNum + " is " + fact.getFactorialRecursion(factNum));
		}
		catch (InvalidEntryException e)
		{
			throw e;
		}
	}



	private static void factorialRegular() throws InvalidEntryException
	{
		int factNum;
		try
		{
			factNum = new GetUserInput().getNaturalNumberInput("4. Factorial - Regular. Please enter a Natural Number (integer):");
			Factorial fact = new Factorial(factNum);
			System.out.println("The Factorial of " + factNum + " is " + fact.getFactorial());
		}
		catch (InvalidEntryException e)
		{
			throw e;
		}

	}



	private static void armstrongNumber() throws InvalidEntryException
	{
		int armstrongNum;
		try
		{
			armstrongNum = new GetUserInput()
					.getNaturalNumberInput("3. Check if Armstrong number. Please enter a Natural Number (integer):");
			ArmstrongNumber arm = new ArmstrongNumber(armstrongNum);
			if (arm.isArmstrong())
				System.out.println("The number is Armstrong.");
			else
				System.out.println("The number is not Armstrong.");

		}
		catch (InvalidEntryException e)
		{
			// e.printStackTrace();
			throw e;
		}

		return;

	}

	private static void palindromeNumber() throws InvalidEntryException
	{
		int userPalinNum;
		try
		{
			userPalinNum = new GetUserInput()
					.getNaturalNumberInput("2. Check for number Palindrome. Please enter a Natural Number (integer):");
			PalindromeNumber pal = new PalindromeNumber(userPalinNum);
			if (pal.checkIfPalindrome())
				System.out.println("The number is a Palindrome.");
			else
				System.out.println("The number is not a Palindrome.");

		}
		catch (InvalidEntryException e)
		{
			// e.printStackTrace();
			throw e;
		}

		return;
	}

	private static void prime() throws InvalidEntryException
	{

		int userPrime;
		try
		{
			userPrime = new GetUserInput()
					.getNaturalNumberInput("1. Check for Prime. Please enter a Natural Number (integer):");

			PrimeNumber p = new PrimeNumber(userPrime);
			if (p.checkIfPrime())
				System.out.println("The number " + userPrime + " is Prime.");
			else
				System.out.println("The number " + userPrime + " is not Prime.");
		}
		catch (InvalidEntryException e)
		{
			// e.printStackTrace();
			throw e;
		}

	}

}
