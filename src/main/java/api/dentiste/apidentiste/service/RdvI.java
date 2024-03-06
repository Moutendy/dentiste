package api.dentiste.apidentiste.service;

import java.util.Date;
import java.util.List;

import api.dentiste.apidentiste.dto.RdvDto;

public interface RdvI {

	void addAppointment(RdvDto appointment);
	void updateAppointment(RdvDto appointment);
	List<RdvDto> getListAppointment();
	void deleteAppointment(Long id);
	List<RdvDto> searchAppointmentByDate(Date date);
	List<RdvDto> searchAppointmentByUser(String userName);
	
}
