package shivam;

public class MainClass {

	public static final String path = "C:\\Users\\Shivam\\Desktop\\New folder";

	public static void main(String[] args) {

		Features features = new Features(); //object of Features Class created
		System.out.println("***************************************************************************");
		features.welcomeScreen();//welcomeScreen function is called trough features object
		System.out.println("***************************************************************************");
		features.mainMenu();//mainMenu function is called trough features object
	}

}
