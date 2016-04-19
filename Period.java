public class Period
{
	private char day;
	private int timeSlot;

	public Period(char day, int timeSlot)
	{
		this.day = day;
		this.timeSlot = timeSlot;
	}

	public char getDay()
	{

		return this.day;
	}

	public int getTimeSlot()
	{
		return this.timeSlot;
	}

	public String toString()
	{
		return "" + this.day + this.timeSlot;
	}

	public int compareTo(Period other)
	{
		if(this.day == other.day && this.timeSlot == other.timeSlot)
		{
			return 0;
		}
		else if(dates(this.day) < dates(other.day))
		{
			return -1;
		}
		else if(dates(this.day) == dates(other.day))
		{
			if(this.timeSlot < other.timeSlot)
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
		else
		{
			return 1;
		}
	}

	public int dates(char day)
	{
		if(day == 'M')
		{
			return 0;
		}
		else if(day == 'T')
		{
			return 1;
		}
		else if(day == 'W')
		{
			return 2;
		}
		else if(day == 'H')
		{
			return 3;
		}
		else if(day == 'F')
		{
			return 4;
		}
		else if(day == 'S')
		{
			return 5;
		}

		return -1;

	}
}