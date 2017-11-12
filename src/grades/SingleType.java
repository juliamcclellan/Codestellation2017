package grades;

public class SingleType extends AssignmentType
{
	private double score;
	private boolean taken;
	
	public SingleType(double percent)
	{
		super(percent);
	}

	@Override
	public double getCurrentAverage()
	{
		if(taken) return score;
		else return Integer.MIN_VALUE;
	}

	@Override
	public double getExpectedAverage()
	{
		if(taken) return Integer.MIN_VALUE;
		else return score;
	}
}