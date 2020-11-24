package Assignment3;


/**
 * Manages student information
 *
 * @author Shimank Dhondiyal
 * @author Michael Cardoso
 */
public abstract class Student implements Comparable
{
	private String fname;
	private String lname;
	protected int credit;
	protected static final int UNIVERSITY_FEE_PART_TIME = 846;
	protected static final int UNIVERSITY_FEE_FULL_TIME = 1441;
	protected static int CREDIT_FULL_TIME = 12;
	protected static int CREDIT_LIMIT = 15;
	protected static boolean FULL_TIME = true;
  protected static int NULL_VALUE = 10;
  protected static int TUITION_IN_STATE = 433;
  protected static int TUITION_OUT_STATE = 756;
  protected static int TUITION_INTERNATIONAL = 945;

	/**
	 * Constructor. Creates student object given first/last names, credit
	 */
	public Student(String fname, String lname, int credit)
  {
		this.fname = fname;
		this.lname = lname;
		this.credit = credit;
	}

	/**
	 * Implements Comparable interface to compare student with Object
	 *
	 * @return 0 if fname, lname matches obj.fname, obj.lname
	 * @return -1 if fname, lname < obj.fname, obj.lname
	 * @return 1 if fname, lname > obj.fname, obj.lname
	 */
	public int compareTo(Object obj)
  {
		String personAFName;
		String personALName;
		String personBFName;
		String personBLName;
		if (!(obj instanceof Student))
    {
			return NULL_VALUE;
		}
		personAFName = this.fname;
		personALName = this.lname;
		Student objStudent = (Student) obj;
		personBFName = objStudent.fname;
		personBLName = objStudent.lname;
		// CASE 1: first names match:
		if (personAFName.compareToIgnoreCase(personBFName) == 0)
    {
			// same person
			if (personALName.compareToIgnoreCase(personBLName) == 0)
      {
				return 0;
			}
			// not same person
			else if (personALName.compareToIgnoreCase(personBLName) < 0)
      {
				return -1;
			}
			// not same person
			else
				return 1;
		}
		// CASE 2: first names do not match, no need to check last name
		else
    {
			if (personAFName.compareToIgnoreCase(personBFName) > 0)
				return 1;
			else
				return -1;
		}
	}

	/**
	 * toString method
	 *
	 * @return String with fname, lname, credit hours
	 */
	public String toString()
  {
		return this.fname + " " + this.lname + " " + this.credit;
	}

	/**
	 * Compute tuition due. Abstract method so no body in this class
	 *
	 * @return amount of tuition due
	 */
	public abstract int tuitionDue();
}
