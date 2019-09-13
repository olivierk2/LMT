package fr.dawan.projetLMT.entities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploader {
	private String uploadDirectory;
	private String prefix = "";
	private String suffix = "";
	private File uploadFile;

	public String uploadFile(MultipartFile mpFile, String id, HttpServletRequest request) throws IOException {
		uploadDirectory =  request.getContextPath() + "/resources/images/uploads/";
		System.out.println(uploadDirectory);
		File uploadDir = new File(uploadDirectory);

		if (!uploadDir.exists()) {
			uploadDir.mkdirs(); 
		}
		String filePath = uploadDirectory + id + ".jpg";
		uploadFile = new File(uploadDir, id + ".jpg");
		byte[] bytes = mpFile.getBytes();

		FileOutputStream stream = new FileOutputStream(uploadFile);
		stream.write(bytes);
		stream.close();
		return filePath;
	}

	public String getUploadDirectory() {
		return uploadDirectory;
	}

	public void setUploadDirectory(String uploadDirectory) {
		this.uploadDirectory = uploadDirectory;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

}
