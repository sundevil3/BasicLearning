package org.pran.spring.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.pran.spring.model.FileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {

	@Autowired
	ServletContext servletContext;


	@RequestMapping(value = "/fileUploadPage", method = RequestMethod.GET)
	public ModelAndView fileUploadPage() {
		FileModel file = new FileModel();
		ModelAndView modelAndView = new ModelAndView("fileUpload", "command", file);
		return modelAndView;
	}

	@RequestMapping(value="/fileUploadPage", method = RequestMethod.POST)
	public String fileUpload(@Validated FileModel file, BindingResult result, ModelMap model) throws IOException {
		if (result.hasErrors()) {
			System.out.println("validation errors");
			return "fileUploadPage";
		} else {
			System.out.println("Fetching file");
			MultipartFile multipartFile = file.getMultipartFile();
			String uploadPath = "C:\\Users\\Administrator\\Desktop\\Stuff2\\Git Repos\\sessionxyz\\SpringMVCDemo\\src\\main\\resources\\";
			FileCopyUtils.copy(file.getMultipartFile().getBytes(), new File(uploadPath+file.getMultipartFile().getOriginalFilename()));
			String fileName = multipartFile.getOriginalFilename();
			model.addAttribute("fileName", fileName);
			return "success";
		}
	}

}
