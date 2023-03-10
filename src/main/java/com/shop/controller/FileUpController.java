package com.shop.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shop.entity.service.FileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FileUpController {
	
	private final FileService fileService;
	
	@GetMapping("/upload")
	public String tUploadForm() {
		return "/upload";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) throws Exception {
		

		Long id = fileService.saveFile(file);
		
		Long ids[] = new Long[files.length];
		
		fileService.saveFile(file);
		
		for(int i = 0; i < files.length; i++) {
			ids[i] = fileService.saveFile(files[i]);
		}
		
		System.out.println(ids.length);
		
		redirectAttributes.addFlashAttribute("id", (ids.length != 0 ? ids:id));
		
		return "redirect:/upload/success";
	}

	
}
