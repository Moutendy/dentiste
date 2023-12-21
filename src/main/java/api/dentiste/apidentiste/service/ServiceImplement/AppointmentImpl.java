package api.dentiste.apidentiste.service.ServiceImplement;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import api.dentiste.apidentiste.dto.AppointmentDto;
import api.dentiste.apidentiste.mapper.AppointmentsMapper;
import api.dentiste.apidentiste.repository.AppointmentRepository;
import api.dentiste.apidentiste.service.AppointmentI;

@Service
public class AppointmentImpl implements AppointmentI{
	
	protected AppointmentRepository appointmentRepository;
	protected AppointmentsMapper appointmentMapper;
	public AppointmentImpl(AppointmentsMapper appointmentMapper,AppointmentRepository appointmentRepository){
		this.appointmentMapper = appointmentMapper;
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public void addAppointment(AppointmentDto appointment) {
		// TODO Auto-generated method stub
		appointmentRepository.save(appointmentMapper.transformaDtoToEntity(appointment));
	}

	@Override
	public void updateAppointment(AppointmentDto appointment) {
		// TODO Auto-generated method stub
		if(appointmentRepository.existsById(appointment.getId())) {
			appointmentRepository.save(appointmentMapper.transformaDtoToEntity(appointment));
		}
		
	}

	@Override
	public List<AppointmentDto> getListAppointment() {
		// TODO Auto-generated method stub
		return appointmentMapper.listtoRendezVousDto(appointmentRepository.findAll());
	}

	@Override
	public void deleteAppointment(Long id) {
		// TODO Auto-generated method stub
		if(appointmentRepository.existsById(id)) {
			appointmentRepository.deleteById(id);
		}
	}

	@Override
	public List<AppointmentDto> searchAppointmentByDate(Date date) {
		// TODO Auto-generated method stub
		return appointmentMapper.listtoRendezVousDto(appointmentRepository.searchConsultationByDate(date));
	}

	@Override
	public List<AppointmentDto> searchAppointmentByUser(String userName) {
		// TODO Auto-generated method stub
		return appointmentMapper.listtoRendezVousDto(appointmentRepository.searchAppointment(userName));
	}

}
