/**
 * Contains information about a single assignment.
 */

package grades;

public class Assignment
{
	private String name;
	private double score;
	private boolean taken;
	
	public Assignment(String name, double score, boolean taken)
	{
		this.name = name;
		this.score = score;
		this.taken = taken;
	}
	
	public Assignment(String name, double score)
	{
		this.name = name;
		this.score = score;
		this.taken = true;
	}
	
	public Assignment(double score, boolean taken)
	{
		this.score = score;
		this.taken = taken;
	}
	
	public Assignment(double score)
	{
		this.name = "";
		this.score = score;
		this.taken = true;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getScore()
	{
		return score;
	}
	
	public boolean getTaken()
	{
		return taken;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setScore(double score)
	{
		this.score = score;
	}
	
	public void setTaken(boolean taken)
	{
		this.taken = taken;
	}
	
	public void take(double score)
	{
		this.score = score;
		taken = true;
	}
	
	public String toString()
	{
		return "Assignment: " + name + ", score: " + score + " " + (taken ? "T" : "NT");
	}
}