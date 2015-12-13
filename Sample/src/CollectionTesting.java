import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class CollectionTesting
{
	public CollectionTesting()
	{
		List<String> l1 = new ArrayList<String>();
		Map<Integer, String> m1 = new HashMap<Integer, String>();
		Set<String> s1 = new TreeSet<String>();
		
		collectionListTesting(l1);
		collectionMapTesting(m1);
		collectionSetTesting(s1);
		
		// collectionIteratorTesting(l1);
		
		// collectionComparisonTesting(l1, m1);
	}
	
	public void collectionSetTesting(Set<String> s)
	{
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("a");
				
		System.out.println("The size of the set: " + s.size());
		System.out.println("Set contains d? " + s.contains("d"));
		System.out.println(s);
	}

	public void collectionListTesting(List<String> l)
	{
		l.add("Vikram");
		l.add("B");
		l.add("C");
		l.add(1, "D");
		l.add(1, "C");
		System.out.println(l);
		System.out.println(l.get(0));
	}
	
	public void collectionMapTesting(Map<Integer, String> m)
	{
		m.put(1, "Vikram");
		m.put(2, "Anandan");
		System.out.println(m);
		System.out.println(m.get(1));
	}
	
	public void collectionIteratorTesting(List<String> l)
	{
		System.out.println("Iterator in for:");
		for(Iterator<String> iter = l.listIterator(); iter.hasNext(); )
		{
			String listStr = iter.next();
			System.out.println(listStr);
		}
		
		System.out.println("For each:");
		for(String s: l)
		{
			System.out.println(s);
		}
	}
	
	public void collectionComparisonTesting(List<String> l, Map<Integer, String> m)
	{
		if(l.get(0).equals(m.get(1)))
		{
			System.out.println("Successfully compared objects from ArrayList and Hashmap");
		}
		else
		{
			System.out.println("They are not equal");
		}
	}

}
