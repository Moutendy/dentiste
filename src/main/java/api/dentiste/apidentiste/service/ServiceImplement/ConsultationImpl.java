package api.dentiste.apidentiste.service.ServiceImplement;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.dentiste.apidentiste.dto.ConsultationDto;
import api.dentiste.apidentiste.mapper.ConsultationMapping;
import api.dentiste.apidentiste.repository.ConsultationRepository;
import api.dentiste.apidentiste.service.ConsultationI;
@Service
public class ConsultationImpl implements ConsultationI{

	protected ConsultationMapping consultationMapping;
	protected ConsultationRepository consultationRepository;
	
	public ConsultationImpl(ConsultationMapping consultationMapping,ConsultationRepository consultationRepository) {
		this.consultationMapping = consultationMapping;
		this.consultationRepository = consultationRepository;
	}
	@Override
	public void addConsultation(ConsultationDto consultation) {
		// TODO Auto-generated method stub
		consultationRepository.save(consultationMapping.toEntity(consultation));
	}

	@Override
	
	public void updateConsultation(ConsultationDto consultation) {
		// TODO Auto-generated method stub
		if(consultationRepository.existsById(consultation.getId()))
		{
			consultationRepository.save(consultationMapping.toEntity(consultation));
		}
	}

	@Override
	public List<ConsultationDto> getListConsultation() {
		// TODO Auto-generated method stub
		return consultationMapping.listtoConsultationDto(consultationRepository.findAll());
	}

	@Override
	public ResponseEntity<String> deleteConsultation(Long id) {
		   try {
			   consultationRepository.deleteById(id);
	           return new ResponseEntity<>("consultation add successfully", HttpStatus.CREATED);
	        } catch (Exception e) {
	           return new ResponseEntity<>("Failed to add consultation: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}

	@Override
	public List<ConsultationDto> searchConsultationByDate(Date date) {
		// TODO Auto-generated method stub
		return consultationMapping.listtoConsultationDto(consultationRepository.searchConsultationByDate(date));
	}

	@Override
	public List<ConsultationDto> searchConsultationByUser(String userName) {
		// TODO Auto-generated method stub
		return consultationMapping.listtoConsultationDto(consultationRepository.searchConsultationByUser(userName));
	}

}
