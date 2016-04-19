public class Student
{
	private String firstName;
	private String lastName;
	private int id;
	private int gradYear;
	private Course[] schedule = new Course[6];

	public Student(String firstName, String lastName, int id, int gradYear)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.gradYear = gradYear;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public int getId()
	{
		return this.id;
	}

	public int getGradYear()
	{
		return this.gradYear;
	}

	public Course[] getSchedule()
	{
		return this.schedule;
	}

	public String toString()
	{
		return "" + this.id + ": " + this.lastName + ", " + this.firstName + " - " + this.gradYear;
	}

	public boolean equals(Student other)
	{
		if(this.id == other.id)
		{
			return true;
		}

		return false;
	}
}