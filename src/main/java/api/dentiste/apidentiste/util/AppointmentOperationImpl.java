package api.dentiste.apidentiste.util;

import org.springframework.stereotype.Service;

import api.dentiste.apidentiste.dto.UserDto;
import api.dentiste.apidentiste.mapper.UserMapper;
import api.dentiste.apidentiste.repository.UserRepository;
import api.dentiste.apidentiste.service.AppointmentI;
import api.dentiste.apidentiste.service.UserI;
import api.dentiste.apidentiste.util.extraDto.AppointmentAndUser;
import api.dentiste.apidentiste.util.inter.AppointmentOperation;
@Service
public class AppointmentOperationImpl implements AppointmentOperation{

	protected UserI userService;
	protected AppointmentI appointmentService;
	protected UserMapper userMapper;
	protected UserRepository userRepository;
	
	public AppointmentOperationImpl(UserI userService, AppointmentI appointmentService
			,UserMapper userMapper,UserRepository userRepository) {
		
		this.userService = userService;
		this.appointmentService = appointmentService;
		this.userMapper = userMapper;
		this.userRepository = userRepository;
	}
	
	@Override
	public void addAppointment(AppointmentAndUser appointmentAndUser) {
		// TODO Auto-generated method stub	
		 if(!userRepository.existsById(appointmentAndUser.getUserDto().getId()))
			{
			UserDto userSave = userMapper.toDto(userRepository.save(userMapper.userDtotoUser(appointmentAndUser.getUserDto())));
			appointmentAndUser.getAppointmentDto().setUserDto(userSave);
			}
		 appointmentAndUser.getAppointmentDto().setUserDto(appointmentAndUser.getUserDto());
		 appointmentService.addAppointment(appointmentAndUser.getAppointmentDto());
	}

}
