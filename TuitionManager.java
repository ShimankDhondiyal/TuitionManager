package Assignment3;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Handles interaction with user (console I/O) Process commands (add, remove,
 * print, quit) and outputs to console
 *
 * @author Shimank Dhondiyal
 * @author Michael Cardoso
 */
public class TuitionManager {
	private static int INTERNATIONAL_CREDIT_MIN = 9;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentList list = new StudentList();
		System.out.println("enter:\n" + "<command> <fname> <lname> <credit> <type-specific data>");
		while (true) {
			StringTokenizer input = new StringTokenizer(scanner.nextLine(), " ");
			// read input (command)
			String command = null;
			try {
				command = input.nextToken();
			} catch (Exception e) {
				// System.out.println("enter a command:");
				continue;
			}
			String fname;
			String lname;
			int credit;
			switch (command) {
			// ADD Instate
			case "I":
				// TODO: check if students exists in list
				fname = input.nextToken();
				lname = input.nextToken();
				credit = Integer.parseInt(input.nextToken());
				if (credit <= 0) {
					break;
				}
				int funding = Integer.parseInt(input.nextToken());
				Instate inStudent = new Instate(fname, lname, credit, funding);
				list.add(inStudent);
				break;
			// ADD Out of state
			case "O":
				// TODO: check if students exists in list
				fname = input.nextToken();
				lname = input.nextToken();
				credit = Integer.parseInt(input.nextToken());

				if (credit <= 0) {
					break;
				}
				boolean outStatus = false;
				if (input.nextToken().equals("T")) {
					outStatus = true;
				} else {
					outStatus = false;
				}
				Outstate outStudent = new Outstate(fname, lname, credit, outStatus);
				list.add(outStudent);
				break;
			// ADD International
			case "N":
				// TODO: check if students exists in list
				fname = input.nextToken();
				lname = input.nextToken();
				credit = Integer.parseInt(input.nextToken());

				if (credit < INTERNATIONAL_CREDIT_MIN) {
					break;
				}
				boolean interStatus = false;
				if (input.nextToken().equals("T")) {
					interStatus = true;
				} else {
					interStatus = false;
				}
				International interStudent = new International(fname, lname, credit, interStatus);
				list.add(interStudent);
				break;
			// REMOVE
			case "R":
				fname = input.nextToken();
				lname = input.nextToken();
				Student removal = new Instate(fname, lname, 1, 0);
				list.remove(removal);
				break;
			// PRINT
			case "P":
				list.print();
				break;
			// QUIT
			case "Q":
				System.out.println("Program terminated");
				System.exit(0);
			default:
				//System.out.println("Command '" + command + "' not supported!");
				continue;
			}
		}
	}
}
