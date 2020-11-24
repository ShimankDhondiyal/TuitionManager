package Assignment3;


/**
 * In-state Student. Recieves various amount of funds if full-time (>= 12cr)
 *
 * @author Shimank Dhondiyal
 * @author Michael Cardoso
 */
public class Instate extends Student
{
	private int funds;

	/**
	 * Constructor including funding
	 */
	public Instate(String fname, String lname, int credit, int funding)
  {
		super(fname, lname, credit);
		this.funds = funding;
		if (this.credit < Student.CREDIT_FULL_TIME)
    {
			Student.FULL_TIME = false;
		}
    else
			Student.FULL_TIME = true;

	}

	/**
	 * Calculates tuition due for In-state student
	 *
	 * @return integer value of tuition due
	 */
	@Override
	public int tuitionDue()
  {
		if ((Student.FULL_TIME) && (this.credit > Student.CREDIT_LIMIT))
		{
      // more than 15 credits, only pay for 15. By default full-time
			return (Student.TUITION_IN_STATE * Student.CREDIT_LIMIT) + Student.UNIVERSITY_FEE_FULL_TIME - this.funds;
		}
    else if (Student.FULL_TIME)
		{
      // if student is full time only [12, 15], funding permitted
			return (Student.TUITION_IN_STATE * this.credit) + Student.UNIVERSITY_FEE_FULL_TIME - this.funds;
		}
		else
      // student is part time (< 12), no funding permitted
			return (Student.TUITION_IN_STATE * this.credit) + Student.UNIVERSITY_FEE_PART_TIME;
	}

	/**
	 * toString() calls toString() method from Student class Does not perform any
	 * I/O
	 *
	 * @return String representation of In-state student
	 */
	@Override
	public String toString()
  {
    return super.toString() + " " + this.funds;
	}

  /**
   * testbed main to check methods in this class
   *
   */
  public static void main(String[] args)
  {
    //test constructor:
    Instate testStudentFullTime = new Instate("firstName", "lastName", 20, 300);
    Instate testStudentPartTime = new Instate("firstName", "lastName", 8, 600);

    //test tuitionDue() method
    System.out.println(testStudentFullTime.tuitionDue());
    System.out.println(testStudentPartTime.tuitionDue());

    //test toString() method
    System.out.println(testStudentFullTime.toString());
    System.out.println(testStudentPartTime.toString());
  }
}
