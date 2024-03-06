package api.dentiste.apidentiste.service.ServiceImplement;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import api.dentiste.apidentiste.dto.RdvDto;
import api.dentiste.apidentiste.mapper.AppointmentsMapper;
import api.dentiste.apidentiste.repository.AppointmentRepository;
import api.dentiste.apidentiste.service.RdvI;

@Service
public class RdvImpl implements RdvI {
	
	protected AppointmentRepository appointmentRepository;
	protected AppointmentsMapper appointmentMapper;
	public RdvImpl(AppointmentsMapper appointmentMapper, AppointmentRepository appointmentRepository){
		this.appointmentMapper = appointmentMapper;
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public void addAppointment(RdvDto appointment) {
		// TODO Auto-generated method stub
		appointmentRepository.save(appointmentMapper.transformaDtoToEntity(appointment));
	}

	@Override
	public void updateAppointment(RdvDto appointment) {
		// TODO Auto-generated method stub
		if(appointmentRepository.existsById(appointment.getId())) {
			appointmentRepository.save(appointmentMapper.transformaDtoToEntity(appointment));
		}
		
	}

	@Override
	public List<RdvDto> getListAppointment() {
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
	public List<RdvDto> searchAppointmentByDate(Date date) {
		// TODO Auto-generated method stub
		return appointmentMapper.listtoRendezVousDto(appointmentRepository.searchAppointmentByDate(date));
	}

	@Override
	public List<RdvDto> searchAppointmentByUser(String userName) {
		// TODO Auto-generated method stub
		return appointmentMapper.listtoRendezVousDto(appointmentRepository.searchAppointment(userName));
	}

}
