package shivam;

import java.io.IOException;
import java.util.*;

public class Features {

	Scanner sc = new Scanner(System.in);
	CRUDoperations crud = new CRUDoperations();

	public void welcomeScreen() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("=================================WELCOME TO================================");
		System.out.println("================================LockedMe.com===============================");
		System.out.println("=================================CREATED BY================================");
		System.out.println("================================Shivam Verma===============================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		

	}

	public void options() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("==============================Main Menu====================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("***                    Select Options From Main Menu                    ***");
		System.out.println("***                          1- List All Files                          ***");
		System.out.println("***                          2- More Options                            ***");
		System.out.println("***                          3- Exit                                    ***");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("Enter your choice from the desired options:");
		

	}

	public void moreOPtions() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("==============================More Options=================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("***                    Select The Desired Options                       ***");
		System.out.println("***                          1- Add a File                              ***");
		System.out.println("***                          2- Delete a File                           ***");
		System.out.println("***                          3- Search for File                         ***");
		System.out.println("***                          4- Back to Main Menu                       ***");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("Enter your choice from the desired options:");
		

	}

	public void exitScreen() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("==============================Thank You!!!=================================");
		System.out.println("==================================For======================================");
		System.out.println("================================Visiting===================================");
		System.out.println("==============================LockedMe.com=================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		
	}

	public void mainMenu() {

		int ch = 0;

		do {
			options();

			try {
				ch = sc.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Input \nEnter Valid Input In Range 1-3");
				mainMenu();
			}

			switch (ch) {
			case 1:

				try {
					crud.listAllFiles(MainClass.path);

				} catch (NullPointerException e) {
					System.out.println("Null Pointer Exception");

				} catch (IllegalArgumentException e) {
					System.out.println("Illegal Argument Exception");

				} catch (Exception e) {
					System.out.println("Any Other Exception Occured");

				}

				break;

			case 2:
				System.out.println("***************************************************************************");
				subMenu();
				break;

			case 3:
				System.out.println("Are you sure you want to exit the screen");
				System.out.println(" (Y)===> Yes     (N)===> No ");
				char decision = 0;
				decision = sc.next().toUpperCase().charAt(0);
				if (decision == 'Y') {
					System.out.println("You have been Loged Out of the Application");
					System.out.println("***************************************************************************");
					exitScreen();
					System.exit(1);
				} else if (decision == 'N') {
					System.out.println("Please Continue!!!");
					System.out.println("***************************************************************************");
					mainMenu();
				} else {
					System.out.println("wrong choice. please enter (y) for yes and (n) for no. please try again!!!");
					System.out.println("***************************************************************************");
					mainMenu();
				}
			default:
				System.out.println("Invalid Choice \nPlease enter valid choice in range from 1-3");
				mainMenu();

			}

		} while (true);

	}

	public void subMenu() {
		int choice = 0;
		String file = null;
		String fileName = null;

		do {
			moreOPtions();

			try {
				choice = sc.nextInt();
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Input \nEnter Valid Input In Range 1-3");
				subMenu();
			}

			switch (choice) {

			case 1:
				System.out.println("-----Adding a File-----");
				System.out.println("Enter a file name to be created");
				file = sc.next().concat(".txt");
				fileName = file.trim();
				try {
					crud.createFile(MainClass.path, fileName);

				} catch (IOException e) {
					System.out.println("error occured while creating a file");

				} catch (NullPointerException e) {
					System.out.println("Null Pointer Exception");

				} catch (IllegalArgumentException e) {
					System.out.println("Illegal Argument Exception");

				} catch (Exception e) {
					System.out.println("Any Other Exception Occured");

				}

				break;
			case 2:
				System.out.println("-----Deleting a File-----");
				System.out.println("Enter a file name to be deleted");
				file = sc.next().concat(".txt");
				fileName = file.trim();
				try {
					crud.deleteFile(MainClass.path, fileName);

				} catch (IOException e) {
					System.out.println("error occured while creating a file");

				} catch (NullPointerException e) {
					System.out.println("Null Pointer Exception");

				} catch (IllegalArgumentException e) {
					System.out.println("Illegal Argument Exception");

				} catch (Exception e) {
					System.out.println("Any Other Exception Occured");

				}

				break;

			case 3:
				System.out.println("-----Searching File-----");
				System.out.println("Enter a file name to be searched");
				file = sc.next().concat(".txt");
				fileName = file.trim();

				try {
					crud.searchFile(MainClass.path, fileName);

				} catch (IOException e) {
					System.out.println("error occured while creating a file");

				} catch (NullPointerException e) {
					System.out.println("Null Pointer Exception");

				} catch (IllegalArgumentException e) {
					System.out.println("Illegal Argument Exception");

				} catch (Exception e) {
					System.out.println("Any Other Exception Occured");

				}
				break;

			case 4:
				System.out.println("***************************************************************************");

				mainMenu();

				break;

			default:
				System.out.println("invalid choice \n enter valid choice between 1-4");
				subMenu();

			}
			file = null;
			fileName = null;

		} while (true);
	}

}
