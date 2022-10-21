package shivam;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CRUDoperations {

	public void listAllFiles(String path) throws IOException {

		if (path == null || path.isEmpty() || path.isBlank()) {
			throw new NullPointerException("Path cannot be null, empty or blank");
		}

		File fl = new File(path);
		if (!fl.exists()) {
			throw new IllegalArgumentException("Path does not exists");
		}

		File fileList[] = fl.listFiles();

		if (fileList != null && fileList.length > 0) {
			System.out.println("List of Files are:");

			for (File file : fileList) {
				if (file.isDirectory()) {
					System.out.println(file.getName());

				} else if (file.isFile()) {
					System.out.println(file.getName());
				}
			}

		} else {
			System.out.println("directory is empty");
		}
		System.out.println("***************************************************************************");

	}

	public void createFile(String path, String fileName) throws IOException {

		if (path == null || path.isEmpty() || path.isBlank()) {
			throw new NullPointerException("Path cannot be null, empty or blank");
		}

		if (fileName == null || fileName.isEmpty() || fileName.isBlank()) {
			throw new NullPointerException("File name cannot be null, empty or blank");
		}

		File fl = new File(path, fileName);
		boolean createNewFile = fl.createNewFile();
		if (createNewFile) {
			System.out.println("file created successfully");
		} else if (!createNewFile) {
			System.out.println("file already exists");
		}
		System.out.println("***************************************************************************");

	}

	public void deleteFile(String path, String fileName) throws IOException {

		if (path == null || path.isEmpty() || path.isBlank()) {
			throw new NullPointerException("Path cannot be null, empty or blank");
		}

		if (fileName == null || fileName.isEmpty() || fileName.isBlank()) {
			throw new NullPointerException("File name cannot be null, empty or blank");
		}

		File fl = new File(path, fileName);
		boolean deletedFile = fl.delete();
		if (deletedFile) {
			System.out.println("file deleted successfully");
		} else {
			System.out.println("file not found. Please try again.");
		}
		System.out.println("***************************************************************************");

	}

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
				Matcher matcher = pattern.matcher(string);
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
