import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class StringFunctions
{
	public Boolean stringStrictPermutations(String firstString, String secondString)
	{
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		
		for(int i=0; i<firstString.length(); i++)
		{
			charMap.put(firstString.charAt(i), 1);
		}
		
		for(int j=0; j<secondString.length(); j++)
		{
			
			if(!charMap.containsKey(secondString.charAt(j)) || charMap.get(secondString.charAt(j)) != 1)
			{
				return false;
			}
			else
				charMap.put(secondString.charAt(j), charMap.get(secondString.charAt(j))+1);
		
		}
		return true;
	}
	
	public char[] stringSubstituteSpaces(char[] charArray, Integer charArraySize)
	{
		int insertIndex = charArray.length-1;
		boolean firstCharProcessed = false;
		int charCount = 0;
		
		if(charArray.length==charArraySize)
			return charArray;
		
		for(int i=charArray.length-1; (i>=0 || charCount<charArraySize); i--)
		{
			if(charArray[i]!=' ')
			{
				if(i==charArray.length-1) // In this iteration, the last character in the array is a letter. Hence, leave as is
				{
					// continue;
					// This is a case that should not occur, since the only way the end of the array has a letter is if there are no other blank spaces
					// in the array. If there are no other blank spaces in the array, the first condition, "charArray.length==charArraySize", should be
					// able to intercept that condition, and return.
				}
				else // This iteration finds a letter. Move it to the index to be inserted at
				{
					firstCharProcessed = true;
					charArray[insertIndex--] = charArray[i];
				}
				
//				insertIndex--;
				charCount++;
				
			}
			else if(charArray[i]==' ' && firstCharProcessed)
			{
				// In this iteration, the last letter in the array is a blank space. Hence, it should be part of the minimum 2 blank spaces
				// that should be at the end of the array in order to accommodate for blank spaces translating to "%20"
				if(i==charArray.length-1) 
				{
					i--; // Move the cursor, one character behind (since that is anyway going to have to be a blank space 
				}
				
				else
				{
					charArray[insertIndex--] = '0';
					charArray[insertIndex--] = '2';
					charArray[insertIndex--] = '%';
				}
				
			}
		}
		
		return charArray;
	}

	public char[] stringSubstituteSpaces(char[] inputCharArray)
	{
		
		for(int i=0, j=inputCharArray.length-1; i<=j; i++,j--)
		{
			if(inputCharArray[i] == inputCharArray[j])
				continue;
			else
			{
				char tempHolder = inputCharArray[i];
				inputCharArray[i] = inputCharArray[j];
				inputCharArray[j] = tempHolder;
			}
		}
		
		return inputCharArray;
	}

	public char[] stringCompress(char[] inputCharArray)
	{
		Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();
		boolean stringIsToBeCompressed = false;
		StringBuffer outputString = new StringBuffer();
//		char[] outputCharArray = null;
		
		for(char c : inputCharArray)
		{
			int charCount = (charMap.get(c) == null) ? 0:charMap.get(c);
			if(charCount>=1)
				stringIsToBeCompressed = true;
				
			charMap.put(c, ++charCount);			
		}
		
		for(Map.Entry<Character, Integer> entry : charMap.entrySet())
		{
			outputString.append(entry.getKey());
			outputString.append(entry.getValue());
		}
		
		if(stringIsToBeCompressed)
			return outputString.toString().toCharArray();
		else
			return inputCharArray;
		
	}

}
