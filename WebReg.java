public class WebReg
{
	public static Course lookupCourseByName(Course[] catalog, String courseName)
	{
		for(Course c : catalog)
		{
			if(c.getName().equalsIgnoreCase(courseName))
			{
				return c;
			}
		}

		return null;
	}

	public static Course[] lookupCoursesByDept(Course[] catalog, int department)
	{
		int counter = 0;
		Course[] toReturn;
		for(Course c : catalog)
		{
			if(c.getDepartment() == department)
			{
				counter++;
			}
		}

		if(counter == 0)
		{
			return null;
		}

		toReturn = new Course[counter];

		counter = 0;

		for(Course c : catalog)
		{
			if(c.getDepartment() == department)
			{
				toReturn[counter] = c;
				counter++;
			}
		}

		return toReturn;
	}

	public static int countCredits(Student s)
	{
		return 0;
	}

	public static boolean addCourse(Student s, Course c)
	{
		return true;
	}

	public static boolean dropCourse(Student s, Course c)
	{
		return true; 
	}
}