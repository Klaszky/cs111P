public class Course
{
	private int department;
	private int courseNum;
	private String name;
	private Period period;
	private int credits;
	private Student[] roster = new Student[20];

	public Course(int department, int courseNum, String name, char day, int timeSlot, int credits)
	{
		this.department = department;
		this.courseNum = courseNum;
		this.name = name;
		this.period = new Period(day, timeSlot);
		this.credits = credits;
	}

	public int getDepartment()
	{
		return this.department;
	}

	public int getCourseNumber()
	{
		return this.courseNum;
	}

	public String getName()
	{
		return this.name;
	}

	public Period getPeriod()
	{
		return this.period;
	}

	public int getCredits()
	{
		return this.credits;
	}

	public Student[] getRoster()
	{
		return this.roster;
	}

	public String toString()
	{
		return "" + this.department + ":" + this.courseNum + " [" + this.name + "] " + this.period + " credits:" + this.credits;
	}

	public boolean equals(Course other)
	{
		if(this.department == other.department && this.courseNum == other.courseNum)
		{
			return true;
		}

		return false;
	}

}