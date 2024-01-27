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
import api.dentiste.apidentiste.dto.AppointmentDto;
import api.dentiste.apidentiste.service.AppointmentI;
import api.dentiste.apidentiste.util.extraDto.AppointmentAndUser;
import api.dentiste.apidentiste.util.inter.AppointmentOperation;

@RestController
@RequestMapping("api/appointment/")
public class AppointmentController {
	
	protected AppointmentI appointmentService;
	
	protected AppointmentOperation appointmentOperation;
	
	public AppointmentController(AppointmentI appointmentService,AppointmentOperation appointmentOperation) {
		this.appointmentService = appointmentService;
		this.appointmentOperation = appointmentOperation;
	}
	
	@PostMapping(value="addappointment" ,consumes = "application/json")
	ResponseEntity<String> addConsultation(@RequestBody AppointmentAndUser appointmentAndUser) {
		   try {
			   appointmentOperation.addAppointment(appointmentAndUser);
	           return new ResponseEntity<>("consultation add successfully", HttpStatus.CREATED);
	        } catch (Exception e) {
	           return new ResponseEntity<>("Failed to add consultation: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   @GetMapping(value="searchappointmentbydate/{date}", consumes = MediaType.APPLICATION_JSON_VALUE)
	   ResponseEntity<List<AppointmentDto>> searchConsultationByDate(@PathVariable("date") String date) throws ParseException
	   {
		   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		   Date dateFrDate = dateFormat.parse(date); 
		   try {
	            return new ResponseEntity<>(appointmentService.searchAppointmentByDate(dateFrDate), HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(appointmentService.searchAppointmentByDate(dateFrDate), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	   }
	   
	   
	   @GetMapping(value="searchappointmentbyuser/{userName}", consumes = MediaType.APPLICATION_JSON_VALUE)
	   ResponseEntity<List<AppointmentDto>> searchConsultationByUser(@PathVariable("userName")String userName)
	   {
           try {
               return new ResponseEntity<>(appointmentService.searchAppointmentByUser(userName), HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(appointmentService.searchAppointmentByUser(userName), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	   }
	   
	   @DeleteMapping(value="deleteappointment/{id}" ,consumes = "application/json")
	   ResponseEntity<String> deleteConsultation(@PathVariable("id") Long id) {
		   try {
			   appointmentService.deleteAppointment(id);
	            return new ResponseEntity<>("consultation add successfully", HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Failed to add consultation: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   
	   
	   @GetMapping(value="getlistappointment" , consumes = "application/json")
	   ResponseEntity<List<AppointmentDto>> getListAppointment() {
		   try {
	            return new ResponseEntity<>(appointmentService.getListAppointment(), HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(appointmentService.getListAppointment(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	   
	   
	   @PutMapping(value="updateappointment", consumes = MediaType.APPLICATION_JSON_VALUE)
	   @Transactional
	   void updateConsultation(@RequestBody AppointmentDto appointmentDto) {
		   appointmentService.updateAppointment(appointmentDto);
	    }

}
