package grades;

public class SingleType extends AssignmentType
{
	private Assignment a;
	
	public SingleType(String name, double percent)
	{
		super(name, percent);
	}
	
	public SingleType(String name, double percent, Assignment a)
	{
		super(name, percent);
		this.a = a;
	}
	
	public void setAssignment(Assignment a)
	{
		this.a = a;
	}
	
	public Assignment getAssignment()
	{
		return a;
	}
	
	@Override
	public double getCurrentAverage()
	{
		if(a == null) return Integer.MIN_VALUE;
		if(a.getTaken()) return a.getScore();
		else return Integer.MIN_VALUE;
	}

	@Override
	public double getExpectedAverage()
	{
		if(a == null) return Integer.MIN_VALUE;
		if(a.getTaken()) return Integer.MIN_VALUE;
		else return a.getScore();
	}
}