package grades;

import java.util.ArrayList;

public class MultipleType extends AssignmentType
{
	private ArrayList<Assignment> assignments;
	
	public MultipleType(double percent)
	{
		super(percent);
		assignments = new ArrayList<Assignment>();
	}
	
	public MultipleType(double percent, ArrayList<Assignment> assignments)
	{
		super(percent);
		this.assignments = assignments;
	}
	
	public void addAssignment()
	
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
			if(!a.getTaken())
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
	
	public 
}