package api.dentiste.apidentiste.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dentiste.apidentiste.dto.ConsultationDto;
import api.dentiste.apidentiste.service.ConsultationI;
import api.dentiste.apidentiste.util.extraDto.ConsutationAndUser;
import api.dentiste.apidentiste.util.inter.ConsultationOperation;

@RestController
@RequestMapping("api/consultation/")
public class ConsultationController {
	
	protected ConsultationOperation consultationOperation;
	protected ConsultationI consultationService;
	
	public ConsultationController(ConsultationOperation consultationOperation,ConsultationI consultationService) {
		this.consultationOperation = consultationOperation;
		this.consultationService = consultationService;
	}
	
	   @PostMapping(value="addconsultation" ,consumes = "application/json")
	   ResponseEntity<String> addConsultation(@RequestBody ConsutationAndUser consultation) {
		   try {
			   consultationOperation.addConsultation(consultation);
	            return new ResponseEntity<>("consultation add successfully", HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Failed to add consultation: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   
	   @GetMapping(value="searchconsultationbydate/{date}", consumes = MediaType.APPLICATION_JSON_VALUE)
	   ResponseEntity<List<ConsultationDto>> searchConsultationByDate(@PathVariable("date") String date) throws ParseException {
		   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   Date dateFrDate = dateFormat.parse(date); 
		   try {
	            return new ResponseEntity<>(consultationService.searchConsultationByDate(dateFrDate), HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(consultationService.searchConsultationByDate(dateFrDate), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	   }
	   
	   
	   @GetMapping(value="searchconsultationbyuser/{userName}", consumes = MediaType.APPLICATION_JSON_VALUE)
	   ResponseEntity<List<ConsultationDto>> searchConsultationByUser(@PathVariable("userName")String userName) {
           try {
               return new ResponseEntity<>(consultationService.searchConsultationByUser(userName), HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(consultationService.searchConsultationByUser(userName), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	   }
	   
	   @DeleteMapping(value="deleteconsultation/{id}" ,consumes = "application/json")
	   ResponseEntity<String> deleteConsultation(@PathVariable("id") Long id) {
		   try {
			   consultationService.deleteConsultation(id);
	            return new ResponseEntity<>("consultation add successfully", HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Failed to add consultation: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   
	   
	   @GetMapping(value="getlistconsultation" ,produces = MediaType.APPLICATION_JSON_VALUE)
	   ResponseEntity<List<ConsultationDto>> getListConsultation() {
		   try {
	            return new ResponseEntity<>(consultationService.getListConsultation(), HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(consultationService.getListConsultation(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   
	   
	   @PutMapping(value="updateconsultation" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	   @Transactional
	   void updateConsultation(@RequestBody ConsultationDto consultation) {
		   consultationService.updateConsultation(consultation);
	    }
}
