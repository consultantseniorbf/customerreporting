package com.climax.customerreporting.controllers;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.climax.customerreporting.ServiceImpl.FileManagerServiceImpl;
import com.climax.customerreporting.domaines.Profession;
import com.climax.customerreporting.services.Statisitques;

@Controller
public class ImportFileController {
	
	@Autowired
	FileManagerServiceImpl filenmae;
	
        @Autowired
        Statisitques statisitques;
	
	
	@GetMapping("/import")
	private String findName(Model model) {
		
		model.addAttribute("filename", "salutt");
		
                  model.addAttribute("statisque",  statisitques.findByAverageProfessionalSalaire());
		          
		
		try {
			filenmae.readAndStoreXmlFile(new File("C:\\employer.xml").getAbsoluteFile());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/index";
		
	}
	
	

}
