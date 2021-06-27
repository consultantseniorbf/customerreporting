package com.climax.customerreporting.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.climax.customerreporting.ServiceImpl.FileManagerServiceImpl;
import com.climax.customerreporting.services.EmployerService;
import com.climax.customerreporting.services.Statisitques;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImportFileController {
	
	@Autowired
	FileManagerServiceImpl filename;
        @Autowired
        EmployerService employerService;
        @Autowired
        Statisitques statisitques;
	@GetMapping("/")
	private String importer(Model model) {
	
            model.addAttribute("employers", employerService.getAll());
		return "index";
		
	}
        
        @PostMapping("/import-file")
        public String importData(Model model,@RequestParam("file") MultipartFile fichier ) throws IOException, ParseException, java.text.ParseException, FileNotFoundException, CsvValidationException
        {
            File file =new File(fichier.getOriginalFilename());
            switch(filename.getFileExentision(file))
            {
                case "csv":
                    
                    filename.readAndStoreCsvFile(file.getAbsoluteFile());
                    break;
                    
                case "json":
                   
                    filename.readAndStoreJson(file.getAbsoluteFile());
                    break;
                    
                case "txt":
                        filename.readAndStoreTxtFile(file.getAbsoluteFile());
                    break;
                    
                default:
                        model.addAttribute("message", "le format de fichier n'est pas reconnu");
                   break;
                            
            }
            return "index";
        }

	@GetMapping("/stat")
	private String statistiques(Model model) {
                model.addAttribute("statistique", statisitques.findByAverageProfessionalSalaire());
		return "statistique";
		
	}
	
	@GetMapping("/import")
	private String findName(Model model) {
		
		model.addAttribute("filename", "salutt");
		
		try {
			filename.readAndStoreXmlFile(new File("C:\\employee.xml").getAbsoluteFile());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/index";
		
	}
	
	

}
