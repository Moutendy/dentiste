package api.dentiste.apidentiste.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import api.dentiste.apidentiste.dto.ConsultationDto;

public interface ConsultationI {
	void addConsultation(ConsultationDto consultation);
	void updateConsultation(ConsultationDto consultation);
	List<ConsultationDto> getListConsultation();
	ResponseEntity<String> deleteConsultation(Long id);
	List<ConsultationDto> searchConsultationByDate(Date date);
	List<ConsultationDto> searchConsultationByUser(String userName);
}
