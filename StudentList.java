package Assignment3;

/**
 * Array-based growable StudentList class
 *
 */
public class StudentList {
	private Student[] studentList;
	private int GROW_SIZE = 4;
	private int NUM_STUDENTS;

	/**
	 * Adding Students to array of Students
	 *
	 */
	public void add(Student s) {
		// if array is empty, create array, add Student, end method
		if (studentList == null) {
			studentList = new Student[GROW_SIZE];
			int START_INDEX = 0;
			studentList[START_INDEX] = s;
			NUM_STUDENTS++;
			return;
		}
		// if the array is full, grow, continue
		if (studentList.length - 1 == NUM_STUDENTS) {
			grow();
		}
		//iterate through array and chewck to see if Student already exists
		for(Student index : studentList)
		{
			if(index.compareTo(s) == 0)
				return;
		}
		// if there is room for the array to grow, add Student
		if (studentList[NUM_STUDENTS] == null) {
			studentList[NUM_STUDENTS] = s;
			NUM_STUDENTS++;
		}
	}

	/**
	 * Remove Student if one exists in array with matching fName, lName
	 *
	 */
	public void remove(Student s) {
		// if no students in list, do nothing, end method
		if (studentList == null)
			return;
		// iterate through student array, keep track of count
		int COUNT = 0;
		for (Student index : studentList) {
			if (index == null)
				return;
			// if match found, replace this student with last student in list, end loop
			if (index.compareTo(s) == 0) {
				studentList[COUNT] = studentList[studentList.length - 1];
				studentList[studentList.length - 1] = null;
				NUM_STUDENTS--;
				break;
			}
			if (index.compareTo(s) == Student.NULL_VALUE || index.compareTo(s) == 1 || index.compareTo(s) == -1) {
				continue;
			}
			COUNT++;
		}
	}

	/**
	 * Print all stored student objects
	 *
	 */
	public void print() {
		if(studentList == null)
			return;
		for (Student index : studentList) {
			// if we reach point in array with no students, stop printing
			if (index == null)
				break;
			System.out.println(index.toString() + "\t$" + index.tuitionDue());
		}
	}

	/**
	 * Grow size of StudentList if the array is too small to add another Student
	 *
	 */
	private void grow() {
		// create new array with more capacity
		Student[] newStudentList = new Student[studentList.length + GROW_SIZE];
		// copy data from old studentList to newStudentList
		int LIST_INDEX = 0;
		while (LIST_INDEX < NUM_STUDENTS) {
			newStudentList[LIST_INDEX] = studentList[LIST_INDEX];
			LIST_INDEX++;
		}
		// reinitialize studentList and copy original data back
		studentList = new Student[newStudentList.length];
		for (LIST_INDEX = 0; LIST_INDEX < studentList.length; LIST_INDEX++) {
			studentList[LIST_INDEX] = newStudentList[LIST_INDEX];
		}
	}
}
