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
	@GetMapping("/")
	private String importer(Model model) {
	
		return "index";
		
	}

	@GetMapping("/stat")
	private String statistiques(Model model) {
	
		return "statistique";
		
	}
	
        
	
	
	

}
