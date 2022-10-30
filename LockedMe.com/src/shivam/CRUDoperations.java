package shivam;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CRUDoperations {
	
	//lisAllfiles() method is created to list all files or folders in a given directory.

	public void listAllFiles(String path) throws IOException {

		if (path == null || path.isEmpty() || path.isBlank()) {
			throw new NullPointerException("Path cannot be null, empty or blank");
		}

		File fl = new File(path);//create fl object of the File Class.
		if (!fl.exists()) {//exists() method is used to check file exists or not and return true if exists and false if not exists.
			throw new IllegalArgumentException("Path does not exists");
		}

		File fileList[] = fl.listFiles();//listFiles() method is a part of File Class in java and returns an array of files.

		if (fileList != null && fileList.length > 0) {
			System.out.println("List of Files are:");

			for (File file : fileList) {       //for each loop
				if (file.isDirectory()) {     //isDirectory method is a part of File Class and returns true if the abstract file path is a directory else false.
					System.out.println(file.getName());

				} else if (file.isFile()) {    //isFile method is a part of File Class in java and returns true if the abstract file path is a file else false.
					System.out.println(file.getName());
				}
			}

		} else {
			System.out.println("directory is empty");
		}
		System.out.println("***************************************************************************");

	}
	
	//createFile() method is created to create a file in a given directory.

	public void createFile(String path, String fileName) throws IOException {

		if (path == null || path.isEmpty() || path.isBlank()) {
			throw new NullPointerException("Path cannot be null, empty or blank");
		}

		if (fileName == null || fileName.isEmpty() || fileName.isBlank()) {
			throw new NullPointerException("File name cannot be null, empty or blank");
		}

		File fl = new File(path, fileName);
		boolean createNewFile = fl.createNewFile();//creteNewFile() method is a part of File Class in java and is used to create a new file.
		if (createNewFile) {
			System.out.println("file created successfully");
		} else if (!createNewFile) {
			System.out.println("file already exists");
		}
		System.out.println("***************************************************************************");

	}
	
	//deleteFile() method is created to delete a file in a given directory.

	public void deleteFile(String path, String fileName) throws IOException {

		if (path == null || path.isEmpty() || path.isBlank()) {
			throw new NullPointerException("Path cannot be null, empty or blank");
		}

		if (fileName == null || fileName.isEmpty() || fileName.isBlank()) {
			throw new NullPointerException("File name cannot be null, empty or blank");
		}

		File fl = new File(path, fileName);
		boolean deletedFile = fl.delete();//delete() method is a part of inbuilt function in java and is used to delete a file.
		if (deletedFile) {
			System.out.println("file deleted successfully");
		} else {
			System.out.println("file not found. Please try again.");
		}
		System.out.println("***************************************************************************");

	}
	
	//searchFile() method is used to search a file in a given directory.

	public void searchFile(String path, String fileName) throws IOException {

		if (path == null || path.isEmpty() || path.isBlank()) {
			throw new NullPointerException("Path cannot be null, empty or blank");
		}
		if (fileName == null || fileName.isEmpty() || fileName.isBlank()) {
			throw new NullPointerException("File name cannot be null, empty or blank");
		}

		File fl = new File(path);

		if (!fl.exists()) {
			throw new IllegalArgumentException("Path does not exists");
		}
		if (fl.isFile()) {
			throw new IllegalArgumentException("is a file and we are expecting a directory");
		}

		String fileList[] = fl.list();
		boolean flag = false;
		
		Pattern pattern = Pattern.compile(fileName);
		
		if (fileList != null && fileList.length > 0) {
			for (String string : fileList) {
				Matcher matcher = pattern.matcher(string.toLowerCase());
				if (matcher.matches()) {
					System.out.println("file is found at location" + fl.getAbsolutePath());
					flag = true;
					break;
				}

			}

		}
		if (flag == false) {
			System.out.println("file not found. Please try again");
		}
		System.out.println("***************************************************************************");

	}

}
