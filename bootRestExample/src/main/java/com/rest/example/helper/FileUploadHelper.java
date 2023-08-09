package com.rest.example.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	// For static path, working fine...
	
//	private final String FILE_DIR = "D:\\satyam.mishra03\\OneDrive - Infosys Limited\\Documents\\springTestFolder\\springbootTestProjects\\bootDemoProject\\springboot-test-projects\\bootRestExample\\src\\main\\resources\\static\\image";

	// For dynamic path
	
//	private final String FILE_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath().toString();
	public final String FILE_DIR = Paths.get("src/main/resources/static/image").toAbsolutePath().toString();

	// I have created this constructor because we need to manage IO exception
	public FileUploadHelper() throws IOException {
		// TODO Auto-generated constructor stub
	}

	public boolean uploadFile(MultipartFile file) {
		boolean flag = false;

		try {
			Files.copy(file.getInputStream(), Paths.get(FILE_DIR + "\\" + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			flag = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

}
