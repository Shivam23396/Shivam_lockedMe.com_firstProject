package shivam;

import java.io.IOException;
import java.util.*;

public class Features {

	Scanner sc = new Scanner(System.in);
	CRUDoperations crud = new CRUDoperations(); //object crud is created for CRUDoperations Class.
	
	//welcomeScreen() method is created for giving appearance to welcome screen through different print statements.

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
	
	//options() method is created for giving appearance to Main Menu through different print statements.


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
	
	//moreOPtions() method is created for giving appearance to More Options through different print statements.

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
	
	//exitScreen() method is created for giving appearance to exit screen through different print statements.

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
	
	//mainMenu() method is created to select different options from main menu.
	//1.list all files or folders in a directory.
	//2.For more options.
	//3.Exit from the screen.
	//default: for wrong choice

	public void mainMenu() {

		int ch = 0;

		do {
			options();//directly goes to options method to line no.33.

			try {
				ch = sc.nextInt();// takes input from the user to select options from main menu.
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Input \nEnter Valid Input In Range 1-3");
				mainMenu();
			}

			switch (ch) {
			case 1://this case is used to list all files or folder in a directory.

				try {
					crud.listAllFiles(MainClass.path);//list all files from listAllFiles method which is created in CRUDoperations class.

				} catch (NullPointerException e) {//catch statement is used to catch the exceptions and print the message.
					System.out.println("Null Pointer Exception");

				} catch (IllegalArgumentException e) {
					System.out.println("Illegal Argument Exception");

				} catch (Exception e) {
					System.out.println("Any Other Exception Occured");

				}

				break;

			case 2://this case is used to select more options from main menu.
				System.out.println("***************************************************************************");
				subMenu();
				break;

			case 3://this case is used to exit from the screen.
				System.out.println("Are you sure you want to exit the screen");
				System.out.println(" (Y)===> Yes     (N)===> No ");
				char decision = 0;
				decision = sc.next().toUpperCase().charAt(0);//decision variable takes input from the user and toUppercase method is used to convert it in upper case and charAt(0) takes only single character at 0 position.
				if (decision == 'Y') {
					System.out.println("You have been Loged Out of the Application");
					System.out.println("***************************************************************************");
					exitScreen();//this method only shows the appearance of exit screen.
					System.exit(1);//this method is used to exits currently program by terminating running java virtual machine.
				} else if (decision == 'N') {
					System.out.println("Please Continue!!!");
					System.out.println("***************************************************************************");
					mainMenu();
				} else {
					System.out.println("wrong choice. please enter (y) for yes and (n) for no. please try again!!!");
					System.out.println("***************************************************************************");
					mainMenu();
				}
			default://for any other input entered by the user it will print the the message below.
				System.out.println("Invalid Choice \nPlease enter valid choice in range from 1-3");
				mainMenu();

			}

		} while (true);

	}
	
	//subMenu() method is created to select different options from main options.
	//1.Adding a file.
	//2.Deleting a file.
	//3.Searching a file.
	//4.Back to main menu
	//default: for wrong choice

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

			case 1://
				System.out.println("-----Adding a File-----");
				System.out.println("Enter a file name to be created");
				file = sc.next().concat(".txt");//.concat() method is used add the .txt in the file name.
				fileName = file.trim();//.trim() method will delete the the blank spaces from front and end in the file name.
				try {
					crud.createFile(MainClass.path, fileName);//create a file from createFile() method which is created in CRUDoperations class.


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
					crud.deleteFile(MainClass.path, fileName);//delete a file from deleteFile() method which is created in CRUDoperations class.


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
			
					crud.searchFile(MainClass.path, fileName.toLowerCase());////search a file or folder  from serchFile() method which is created in CRUDoperations class.


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

				mainMenu();//this method directly goes to mainMenu() method created in this class.

				break;

			default:
				System.out.println("invalid choice \n enter valid choice between 1-4");
				subMenu();//this method directly goes to subMenu() method created in this class.


			}
			file = null;
			fileName = null;

		} while (true);
	}

}
