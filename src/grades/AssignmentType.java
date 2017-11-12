/**
 * Contains the percentage an assignment type makes up and the assignments for that type.
 */

package grades;

public abstract class AssignmentType
{ 
	private String name;
	private double percent;
	
	public AssignmentType(String name, double percent)
	{
		this.name = name;
		this.percent = percent;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public double getPercent()
	{
		return percent;
	}
	
	public void setPercent(double percent)
	{
		this.percent = percent;
	}
	
	public String toString()
	{
		return "Type: " + name + ", weight: " + percent;
	}
	
	public abstract double getCurrentAverage();
	
	public abstract double getExpectedAverage();  
}