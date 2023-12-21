package api.dentiste.apidentiste.service;

import java.util.Date;
import java.util.List;

import api.dentiste.apidentiste.dto.AppointmentDto;

public interface AppointmentI {

	void addAppointment(AppointmentDto appointment);
	void updateAppointment(AppointmentDto appointment);
	List<AppointmentDto> getListAppointment();
	void deleteAppointment(Long id);
	List<AppointmentDto> searchAppointmentByDate(Date date);
	List<AppointmentDto> searchAppointmentByUser(String userName);
	
}
