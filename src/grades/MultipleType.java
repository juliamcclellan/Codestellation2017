package grades;

import java.util.ArrayList;

public class MultipleType extends AssignmentType
{
	private ArrayList<Assignment> assignments;
	
	public MultipleType(String name, double percent)
	{
		super(name, percent);
		assignments = new ArrayList<Assignment>();
	}
	
	public MultipleType(String name, double percent, ArrayList<Assignment> assignments)
	{
		super(name, percent);
		this.assignments = assignments;
	}
	
	public void addAssignment(Assignment a)
	{
		assignments.add(a);
	}
	
	public ArrayList<Assignment> getAssignments()
	{
		return assignments;
	}
	
	@Override
	public double getCurrentAverage()
	{
		double total = 0;
		int number = 0;
		for(Assignment a: assignments)
		{
			if(a.getTaken())
			{
				total += a.getScore();
				number++;
			}
		}
		if(number != 0)
		{
			return total / number;
		}
		else
		{
			return Integer.MIN_VALUE;
		}
	}

	@Override
	public double getExpectedAverage()
	{
		double total = 0;
		int number = 0;
		for(Assignment a: assignments)
		{
			total += a.getScore();
			number++;
		}
		if(number != 0)
		{
			return total / number;
		}
		else
		{
			return Integer.MIN_VALUE;
		}
	}
	
	public String toString()
	{
		return super.toString() + " => " + assignments;
	}
}