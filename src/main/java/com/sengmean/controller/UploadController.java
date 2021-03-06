package com.sengmean.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {

	@PostMapping("/file/upload")
	public String upload(@RequestParam("file") List<MultipartFile> files, HttpServletRequest request) {
		
		String uploadPath = "/opt/images/";
		File path = new File(uploadPath);
		if (!path.exists())
			path.mkdirs();
		for (MultipartFile file: files)
			try {
				// generate random file name (check duplicate fill name)
				String fileName = file.getOriginalFilename();
				fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") +1);
				System.out.println(fileName);
				// upload file to server
				Files.copy(file.getInputStream(), Paths.get(uploadPath, fileName));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		return "fileUpload";
	}
}
