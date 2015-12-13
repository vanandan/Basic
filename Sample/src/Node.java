
public class Node
{
	int value;
	Node nextNode;
	
	public Node(int inputValue)
	{
		value = inputValue;
	}
	
	public void setValue(int inputValue)
	{
		value = inputValue;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setNext(Node inputNextNode)
	{
		nextNode = inputNextNode;
	}
	
	public Node getNext()
	{
		return nextNode;
	}

}
