package api.dentiste.apidentiste.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import api.dentiste.apidentiste.dto.AppointmentDto;
import api.dentiste.apidentiste.entity.Appointment;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface AppointmentsMapper {

	AppointmentsMapper INSTANCE = Mappers.getMapper(AppointmentsMapper.class);
	
	 @Mapping(target="id", source = "appointment.id")
	 @Mapping(target="date", source = "appointment.date")
	 @Mapping(target="heure", source = "appointment.heure")
	 @Mapping(target="userDto", source = "appointment.user")
	 AppointmentDto oneToDto(Appointment appointment);
	 
	 
	 
	 @Mapping(target = "id", source="appointmentDto.id")
	 @Mapping(target = "date", source="appointmentDto.date")
	 @Mapping(target = "heure", source="appointmentDto.heure")
	 @Mapping(target="user", source = "appointmentDto.userDto")
	 Appointment transformaDtoToEntity(AppointmentDto appointmentDto);
	 
	 
	List<AppointmentDto> listtoRendezVousDto(List<Appointment> appointment);
		
	List<Appointment> listRendezVousEntity(List<AppointmentDto> rendezVousDto);
}
