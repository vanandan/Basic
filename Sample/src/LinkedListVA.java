import java.util.HashMap;
import java.util.Map;


public class LinkedListVA
{
	Node head = null;
	Node tail;
	int listLength = 0;
	
	public void autoAdd()
	{
		head = new Node(1);
		listLength++;
		Node currNode = head;
		for(int i = 1; i<=3; i++)
		{
			currNode.nextNode = new Node(head.value + i*2);
			currNode = currNode.nextNode;
			listLength++;
		}
		currNode.nextNode = new Node(head.value);
		listLength++;
		printList();
	}
	
	public void autoAdd2()
	{
		head = new Node(1);
		listLength++;
		Node currNode = head;
		
		currNode.nextNode = new Node(4);
		currNode = currNode.nextNode;
		listLength++;
		
		currNode.nextNode = new Node(3);
		currNode = currNode.nextNode;
		listLength++;
		
		currNode.nextNode = new Node(2);
		currNode = currNode.nextNode;
		listLength++;
		
		currNode.nextNode = new Node(5);
		currNode = currNode.nextNode;
		listLength++;
		
		printList();
	}

	public void addNode(int value)
	{
		Node newNode = new Node(value);
		newNode.nextNode = null;
		
		if(listLength==0)
			head = newNode;
		else
		{
			Node currNode = getNode(listLength-1);
			currNode.nextNode = newNode;
		}
		
		listLength++;
		System.out.println("Len: " + listLength);
		printList();
	}
	
	private Node getNode(int index) // index values are from 0 to listLength-1
	{
		Node currNode = null;
		for(int i=0; i<=index; i++)
		{
			if(i==0)
			{
				currNode = head;
			}
			else
			{
				currNode = currNode.nextNode;
			}
		}
		
		return currNode;
	}
	
	public void addNode(int index, int value) // Index can be from 0 to (listLength) i.e. Array index value 
	{
		Node newNode = new Node(value);
		
		if(index==0) // Add to Head
		{
			if(listLength==0) // List is empty
				newNode.nextNode = null;
			else
				newNode.nextNode = head;
			
			head = newNode;
			listLength++;
			printList();
		}
		else if(index==listLength) // Add to Tail
		{
			addNode(value);
		}
		else if(index>0 && index<listLength) // Add in between existing values
		{
			Node currNode = getNode(index-1);
			newNode.nextNode = currNode.nextNode;
			currNode.nextNode = newNode;
			listLength++;
			printList();
		}
		else 
		{
			System.out.println("Index is Out of Bounds");
		}	
	}
	
	public void deleteNode()
	{
		if(listLength==0)
		{
			System.out.println("List is empty");
		}
		else if(listLength==1)
		{
			System.out.println("Deleting value: " + head.value);
			head = null;
			listLength--;
			printList();
		}
		else
		{
			Node prevNodeToBeDel = getNode(listLength-2);
			System.out.println("Deleting value: " + prevNodeToBeDel.nextNode.value);
			prevNodeToBeDel.nextNode = null;
			listLength--;
			printList();
		}
		
	}
	
	public void deleteNode(int index)
	{
		if(listLength==0)
		{
			System.out.println("List is empty");
		}
		else if(index>listLength-1 || index<0)
		{
			System.out.println("Index out of bounds");
		}
		else if(listLength==1 && index==0) // delete the head node, which also happens to be the only node
		{
			System.out.println("Deleting value: " + head.value);
			head = null;
			listLength--;
			printList();
		}
		else if (index==0 && listLength>1) // delete the head node
		{
			System.out.println("Deleting value: " + head.value);
			head = head.nextNode;
			listLength--;
			printList();

		}
		else if(index>0 && index<listLength)
		{
			Node prevNodeToBeDel = getNode(index-1);
			System.out.println("Deleting value: " + prevNodeToBeDel.nextNode.value);
			
			if(index==listLength-1) // tail node
				prevNodeToBeDel.nextNode = null;
			else // not tail node
				prevNodeToBeDel.nextNode = prevNodeToBeDel.nextNode.nextNode;
			
			listLength--;
			
			printList();
		}
	}
	
	public void printList()
	{
		if(listLength==0)
			System.out.println("List is empty");
		else
		{
			Node currNode = head;
			for(int i=0; i<listLength; i++)
			{
				System.out.print(currNode.value);
				currNode = currNode.nextNode;
				System.out.print(" -> ");
			}
			System.out.println(" NULL ");
		}
		
	}

	public void removeDuplicatesV1()
	{
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		Node currNode = head;
		Node prevNode = head;

		if(currNode==null)
		{
			System.out.println("The list is empty");
			return;
		}
		
		// For the first iteration. The prevNode is still in head. The currentNode is now the node in index position 1.
		hash.put(currNode.value, 1);
		currNode = currNode.nextNode; 
		
		while(currNode!=null)
		{
			if(hash.get(currNode.value)==null) // Current node's value has not been "seen" before
			{
				hash.put(currNode.value, 1);
				prevNode = currNode;
				currNode = currNode.nextNode;
				
			}
			else // the currNode.value already exists in the hashmap.
			{
				prevNode.nextNode = currNode.nextNode;
				listLength--;
				prevNode = currNode;
				currNode=currNode.nextNode;
			}
		}
		
		
		printList();
	}
	
	public void removeDuplicatesV2()
	{
		Node currNode = head;
		if(currNode==null)
		{
			System.out.println("List is empty");
			return;
		}
		
		while(currNode.nextNode!=null)
		{
			Node iterCurrNode = currNode.nextNode;
			Node iterPrevNode = currNode;
			
			while(iterCurrNode!=null)
			{
				if(currNode.value == iterCurrNode.value)
				{
					iterPrevNode.nextNode = iterCurrNode.nextNode;
					listLength--;
				}
				
				iterPrevNode = iterCurrNode;
				iterCurrNode = iterCurrNode.nextNode;
			}
						
			currNode = currNode.nextNode;
			if(currNode==null)
			{
				break;
			}
		}
		
		printList();
	}

	public void removeDuplicatesV3()
	{
		if(head==null)
		{
			System.out.println("The list is empty.");
			return;
		}
		
		removeDuplicatesRecursive(head);
		
		printList();
	}
	
	private void removeDuplicatesRecursive(Node headNode)
	{
		if(headNode.nextNode != null)
			removeDuplicatesRecursive(headNode.nextNode);
		
		if(headNode==null)
			return;
		
		if(headNode.value == headNode.nextNode.value)
		{
			headNode.nextNode = headNode.nextNode.nextNode;
			listLength--;
		}
	}
	
	public void findKthLastElementV1(int k)
	{
		findKthLastElementRecursive(k, head);
	}
	
	public void findKthLastElementV2(int k)
	{
		if(head==null)
		{
			System.out.println("List is empty");
			return;
		}
		
		Node advancedNode = head;
		
		for(int i=1; i<k; i++)
		{
			if(advancedNode.nextNode==null)
			{
				System.out.println("List does not have as many as " + k + " elements");
				return;
			}
			advancedNode = advancedNode.nextNode;
		}
		
		Node curNode = head;
		
		for(int i=0; ; i++)
		{
			if(advancedNode.nextNode==null)
			{
				break;
			}
			curNode = curNode.nextNode;
			advancedNode = advancedNode.nextNode;
		}
		
		System.out.println("Kth element is: " + curNode.value);				
	}
	
	private int findKthLastElementRecursive(int k, Node head)
	{
		int currElementNum = 0;
		if(head.nextNode==null)
		{
			if(k==1)
				System.out.println("Kth element is: " + head.value);

			return 1;
		}
		
		if(head.nextNode!=null)
		{
			currElementNum = 1 + findKthLastElementRecursive(k, head.nextNode);
		}
		
		if(currElementNum==k)
			System.out.println("Kth element is: " + head.value);
		
		return currElementNum;
	}

	public void sortListAroundPivot(int pivotValue)
	{
		LinkedListVA lessThanList = new LinkedListVA();
		LinkedListVA equalToList = new LinkedListVA();
		LinkedListVA greaterThanList = new LinkedListVA();
		LinkedListVA finalList = new LinkedListVA();
		Node currNode = head;
		
		if(head==null)
		{
			System.out.println("List is empty");
			return;
		}
		
		while(currNode!=null)
		{
		
			if(currNode.value<pivotValue)
			{
				lessThanList.addNode(0, currNode.value);
			}
			else if(currNode.value==pivotValue)
			{
				equalToList.addNode(0, currNode.value);
			}
			else if (currNode.value>pivotValue)
			{
				greaterThanList.addNode(0, currNode.value);
			}
			
			currNode = currNode.nextNode;
		}
		
		Node lastNode = null; 
		// Node toBeDel = null;
		
		if(lessThanList.listLength>0)
		{
			finalList = lessThanList;
			// finalList.listLength--; // += (lessThanList.listLength-1);
			lastNode = finalList.getNode(finalList.listLength-1);
		}
		
		if(equalToList.listLength>0)
		{
			if(lastNode!=null)
			{
				lastNode.nextNode = equalToList.getNode(0);
			}
			else // If lastNode is null, it means that the lessThanList was NULL.
			{
				finalList = equalToList;
			}
			
			finalList.listLength += equalToList.listLength;
			lastNode = finalList.getNode(finalList.listLength-1);
		}
		
		if(greaterThanList.listLength>0)
		{
			if(lastNode!=null)
				lastNode.nextNode = greaterThanList.getNode(0);
			else  // If lastNode is null, it means that the lessThanList AND equalToList were both NULL.
				finalList = greaterThanList;
			
			finalList.listLength += greaterThanList.listLength;
		}
		
		finalList.printList();
	}
}
