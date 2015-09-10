package com.prongbang.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

public class ManageFile {
	
	public static String encodeImage(byte[] imageByteArray) {
		return Base64.encodeBase64URLSafeString(imageByteArray);
	}
	
	public static byte[] decodeImage(String imageDataString) {
		return Base64.decodeBase64(imageDataString);
	}
	
	// save uploaded file to new location
	public static void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void convertByte2File(byte[] byteArray, String filename) throws IOException {

		FileOutputStream fileOuputStream;
		try {
			fileOuputStream = new FileOutputStream(filename);
			fileOuputStream.write(byteArray);
			fileOuputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void upload(String fileName, byte[] imageBytes) {

		String filePath = "e:/Test/Server/Upload/" + fileName;

		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			BufferedOutputStream outputStream = new BufferedOutputStream(fos);
			outputStream.write(imageBytes);
			outputStream.close();

			System.out.println("Received file: " + filePath);

		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	public static byte[] download(String fileName) {
		String filePath = "e:/Test/Server/Download/" + fileName;
		System.out.println("Sending file: " + filePath);

		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream inputStream = new BufferedInputStream(fis);
			byte[] fileBytes = new byte[(int) file.length()];
			inputStream.read(fileBytes);
			inputStream.close();

			return fileBytes;
		} catch (IOException ex) {
			System.err.println(ex);
		}
		return null;
	}
}
