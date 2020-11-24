package Assignment3;

/**
 * Out-of-State Student. If full-time and fro tri-state area, discount $200/cr
 *
 * @author Shimank Dhondiyal
 * @author Michael Cardoso
 */
public class Outstate extends Student
{
	private boolean tristate;
	private int DISCOUNT = 200;

	/**
	 * Constructor including Status
	 */
	public Outstate(String fname, String lname, int credit, boolean status)
  {
		super(fname, lname, credit);
		this.tristate = status;
		if (this.credit < Student.CREDIT_FULL_TIME)
    {
			Student.FULL_TIME = false;
		}
    else
			Student.FULL_TIME = true;
	}

	/**
	 * Calculates tuition due for Out-of-State student
	 *
	 * @return integer value of tuition due
	 */
	@Override
	public int tuitionDue()
  {
		// if full time
		if (Student.FULL_TIME)
    {
			// if tristate, more than 15 credits
			if (this.tristate && this.credit > Student.CREDIT_LIMIT)
      {
				return ((Student.TUITION_OUT_STATE - this.DISCOUNT) * Student.CREDIT_LIMIT) + Student.UNIVERSITY_FEE_FULL_TIME;
			}
			// if tristate, between 12 and 15 credits
			else if (this.tristate) {
				return ((Student.TUITION_OUT_STATE - this.DISCOUNT) * this.credit) + Student.UNIVERSITY_FEE_FULL_TIME;
			}
			// not tristate, over 15 credits
			else if (this.credit > Student.CREDIT_LIMIT)
      {
				return (Student.TUITION_OUT_STATE * Student.CREDIT_LIMIT) + Student.UNIVERSITY_FEE_FULL_TIME;
			}
			// not tristate, between 12 and 15 credits
			else
      {
				return (Student.TUITION_OUT_STATE * this.credit) + Student.UNIVERSITY_FEE_FULL_TIME;
			}
		}
		// part time tristate or not
		else
    {
			return (Student.TUITION_OUT_STATE * this.credit) + Student.UNIVERSITY_FEE_PART_TIME;
		}
	}

	/**
	 * toString() calls toString() method from Student class Does not perform any
	 * I/O
	 *
	 * @return String representation of Out-of-State student
	 */
	@Override
	public String toString()
  {
		return super.toString() + " " + String.valueOf(this.tristate);
	}

  /**
   * testbed main to check methods in this class
   *
   */
   public static void main(String[] args)
   {
    //test constructor:
    Outstate testStudentFullTime = new Outstate("firstName", "lastName", 19, true);
    Outstate testStudentPartTime = new Outstate("firstNameAlt", "lastNameAlt", 10, false);

    //test tuitionDue() method
    System.out.println(testStudentPartTime.tuitionDue());
    System.out.println(testStudentFullTime.tuitionDue());

    //test toString() method
    System.out.println(testStudentPartTime.toString());
    System.out.println(testStudentFullTime.toString());
   }

}
