/**
 * Contains the percentage an assignment type makes up and the assignments for that type.
 */

package grades;

public abstract class AssignmentType
{ 
	private double percent;
	
	public AssignmentType(double percent)
	{
		this.percent = percent;
	}
	
	public double getPercent()
	{
		return percent;
	}
	
	public void setPercent(double percent)
	{
		this.percent = percent;
	}
	
	public abstract double getCurrentAverage();
	
	public abstract double getExpectedAverage();  
}