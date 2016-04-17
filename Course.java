public class Course
{
	private int department;
	private int courseNum;
	private String name;
	private char day;
	private int timeSlot;
	private int credits;
	private Student[] roster;

	public Course(int department, int courseNum, String name, char day, int timeSlot, int credits)
	{
		this.department = department;
		this.courseNum = courseNum;
		this.name = name;
		this.day = day;
		this.timeSlot = timeSlot;
		this.credits = credits;
	}

	public int getDepartment()
	{}

	public int getCourseNumber()
	{}

	public String getName()
	{}

	public Period getPeriod()
	{}

	public int getCredits()
	{}

	public Student[] getRoster()
	{}

	public String toString()
	{}

	public boolean equals(Course other)
	{}

}