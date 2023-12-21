package api.dentiste.apidentiste.util;

import org.springframework.stereotype.Service;

import api.dentiste.apidentiste.dto.UserDto;
import api.dentiste.apidentiste.mapper.UserMapper;
import api.dentiste.apidentiste.repository.UserRepository;
import api.dentiste.apidentiste.service.ConsultationI;
import api.dentiste.apidentiste.service.UserI;
import api.dentiste.apidentiste.util.extraDto.ConsutationAndUser;
import api.dentiste.apidentiste.util.inter.ConsultationOperation;
@Service
public class ConsultationOperationImpl implements ConsultationOperation{

	protected UserI userService;
	protected ConsultationI consultationService;
	protected UserMapper userMapper;
	protected UserRepository userRepository;
	
	public ConsultationOperationImpl(UserI userService,ConsultationI consultationService
			,UserMapper userMapper,UserRepository userRepository){
		
		this.userService = userService;
		this.consultationService = consultationService;
		this.userMapper = userMapper;
		this.userRepository = userRepository;
	}
	
	public void addConsultation(ConsutationAndUser consultation)
	{    if(!userRepository.existsById(consultation.getUserDto().getId()))
		{
		UserDto userSave = userMapper.toDto(userRepository.save(userMapper.userDtotoUser(consultation.getUserDto())));
		consultation.getConsultationDto().setUsersDto(userSave);
		}
	    consultation.getConsultationDto().setUsersDto(consultation.getUserDto());
		consultationService.addConsultation(consultation.getConsultationDto());
	}


}
