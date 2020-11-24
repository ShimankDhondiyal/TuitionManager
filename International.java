package Assignment3;

/**
 * International Student. Must enroll in at least 9 credit hours. If exchange
 * student, only pay full-time University fee and International fee
 *
 * @author Shimank Dhondiyal
 * @author Michael Cardoso
 */
public class International extends Student
{
	private boolean exchange;
	private int INTERNATIONAL_STUDENT_FEE = 350;
  
	/**
	 * Constructor including exchange status
	 */
	public International(String fname, String lname, int credit, boolean status)
  {
		super(fname, lname, credit);
		this.exchange = status;
		if (this.credit < Student.CREDIT_FULL_TIME)
    {
			Student.FULL_TIME = false;
		}
    else
			Student.FULL_TIME = true;
	}

	/**
	 * Calculates tuition due for International student
	 *
	 * @return integer value of tuition due
	 */
	@Override
	public int tuitionDue()
  {
		// exchange studene: pay university fee and international fee only
		if (this.exchange)
    {
			return Student.UNIVERSITY_FEE_FULL_TIME + this.INTERNATIONAL_STUDENT_FEE;
		}
		// not exchange, full time
		else if (Student.FULL_TIME)
    {
			// full time > 15 credits
			if (this.credit > Student.CREDIT_LIMIT)
      {
				return (Student.TUITION_INTERNATIONAL * Student.CREDIT_LIMIT) + Student.UNIVERSITY_FEE_FULL_TIME
						+ this.INTERNATIONAL_STUDENT_FEE;
			}
			// full time, < 15 credits
			else
      {
				return (Student.TUITION_INTERNATIONAL * this.credit) + Student.UNIVERSITY_FEE_FULL_TIME + this.INTERNATIONAL_STUDENT_FEE;
			}
		}
		// student is part time (< 12)
		else
			return (Student.TUITION_INTERNATIONAL * this.credit) + Student.UNIVERSITY_FEE_PART_TIME + this.INTERNATIONAL_STUDENT_FEE;
	}

	/**
	 * toString() calls toString() method from Student class Does not perform any
	 * I/O
	 *
	 * @return String representation of International student
	 */
	@Override
	public String toString()
  {
		return super.toString() + " " + String.valueOf(this.exchange);
	}

  /**
   * testbed main to check methods in this class
   *
   */
   public static void main(String[] args)
   {
    //test constructor:
    International testStudentPartTime = new International("firstName", "lastName", 10, false);
    International testStudentPartTimeX = new International("firstName", "lastName", 10, true);
    International testStudentFullTime = new International("firstName", "lastName", 10, false);
    International testStudentFullTimeX = new International("firstName", "lastName", 10, true);

    //test tuitionDue() method
    System.out.println(testStudentPartTime.tuitionDue());
    System.out.println(testStudentPartTimeX.tuitionDue());
    System.out.println(testStudentFullTime.tuitionDue());
    System.out.println(testStudentFullTimeX.tuitionDue());

    //test toString() method
    System.out.println(testStudentPartTime.toString());
    System.out.println(testStudentPartTimeX.toString());
    System.out.println(testStudentFullTime.toString());
    System.out.println(testStudentFullTimeX.toString());
   }

}
