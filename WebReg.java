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
		int total = 0;

		for(Course c : s.getSchedule())
		{
			if(c != null)
				total += c.getCredits();
		}

		return total;
	}

	public static boolean addCourse(Student s, Course c)
	{
		if(isFullS(s) || isFullR(c))
			
	}

	public static boolean dropCourse(Student s, Course c)
	{
		return true; 
	}

	public static boolean isFullS(Student s)
	{
		for(Course c : s.getSchedule())
		{
			if(c == null)
			{
				return false;
			}
		}

		return true;
	}

	public static boolean isFullR(Course c)
	{
		for(Student s : c.getRoster())
		{
			if(s == null)
			{
				return false;
			}
		}

		return true;
	}
}