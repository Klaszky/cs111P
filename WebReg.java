public class WebReg
{
//////////////////////////////////////////////////////////
	//  Main Methods
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
		if(isFullS(s) || isFullR(c) || sameTime(s, c) || duplicateCourse(s, c))
		{
			return false;
		}

		for(int i = 0; i < s.getSchedule().length; i++)
		{
			if(s.getSchedule()[i] == null)
			{
				s.getSchedule()[i] = c;
				break;
			}
		}
		for(int i = 0; i < c.getRoster().length; i++)
		{
			if(c.getRoster()[i] == null)
			{
				c.getRoster()[i] = s;
				break;
			}
		}

		return true;
	}

	public static boolean dropCourse(Student s, Course c)
	{
		int counter = 0;
		for(Course current : s.getSchedule())
		{
			if(current != null)
			{
				if(current.equals(c))
				{
					s.getSchedule()[counter] = null;
					cleanArray(s);
					removeStudent(s, c);
					return true;
				}
				counter++;
			}
		}

		return false;
	}

//////////////////////////////////////////////////////////
	//  Sorting Methods

//////////////////////////////////////////////////////////
	//  Helper Methods

	// Checks to see if a students schedule is full
	public static boolean isFullS(Student s)
	{
		if(s != null)
		{
			for(Course c : s.getSchedule())
			{
				if(c == null)
				{
					return false;
				}
			}
		}
		return true;
	}


	// Checks to see if a class is full
	public static boolean isFullR(Course c)
	{
		if(c != null)
		{
			for(Student s : c.getRoster())
			{
				if(s == null)
				{
					return false;
				}
			}
		}
		return true;
	}

	// goes through a student's entire schedule to see if the
	// supplied course is at the same time as another class
	// in said schedule
	public static boolean sameTime(Student s, Course c)
	{
		// this whole long chain of ifs are here for the sole
		// purpose of avoid a null pointer exception
		if(s.getSchedule() != null)
		{		
			if(c.getRoster() != null)
			{	
				for(Course current : s.getSchedule())
				{
					if(current != null)
					{
						if(current.getPeriod().toString().equals(c.getPeriod().toString()))
						{
							return true;
						}
					}	
				}
			}
		}
		return false;
	}

	// makes sure a student isn't register for the same class twice
	// which in theory would be possible is they were at two different
	// times
	public static boolean duplicateCourse(Student s, Course c)
	{
		if(s.getSchedule() != null)
		{
			for(Course current : s.getSchedule())
			{
				if(current != null)
				{
					if(current.equals(c))
					{
						return true;
					}
				}
			}
		}

		return false;
	}

	// cleans up an array and gets rid of any gaps
	public static void cleanArray(Student s)
	{
		for(int i = 0; i < s.getSchedule().length; i++)
		{
			if(s.getSchedule()[i] == null)
			{
				for(int j = i; j < s.getSchedule().length; j++)
				{
					if(s.getSchedule()[j] != null)
					{
						s.getSchedule()[i] = s.getSchedule()[j];
						s.getSchedule()[j] = null;
						break;
					}
				}
			}
		}
	}

	public static void cleanArray(Course c)
	{
		for(int i = 0; i < c.getRoster().length; i++)
		{
			if(c.getRoster()[i] == null)
			{
				for(int j = i; j < c.getRoster().length; j++)
				{
					if(c.getRoster()[j] != null)
					{
						c.getRoster()[i] = c.getRoster()[j];
						c.getRoster()[j] = null;
						break;
					}
				}
			}
		}
	}


	// removes a student from the roster
	public static void removeStudent(Student s, Course c)
	{
		for(int i = 0; i < c.getRoster().length; i++)
		{
			if(c.getRoster()[i] != null)
			{
				if(c.getRoster()[i].equals(s))
				{
					c.getRoster()[i] = null;
					cleanArray(c);
					break;
				}
			}
		}
	}

}