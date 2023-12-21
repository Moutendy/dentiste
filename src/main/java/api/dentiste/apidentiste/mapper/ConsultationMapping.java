package api.dentiste.apidentiste.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import api.dentiste.apidentiste.dto.ConsultationDto;
import api.dentiste.apidentiste.entity.Consultation;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface ConsultationMapping {

	ConsultationMapping INSTANCE = Mappers.getMapper(ConsultationMapping.class);
	
	 @Mapping(target="id", source="consultation.id")
	 @Mapping(target="date", source="consultation.date")
	 @Mapping(target="heure", source="consultation.heure")
	 @Mapping(target="observations", source="consultation.observations")
	 @Mapping(target="usersDto", source="consultation.user")
	 ConsultationDto toDto(Consultation consultation);
	 
	 @Mapping(target="id", source="consultation.id")
	 @Mapping(target="date", source="consultation.date")
	 @Mapping(target="heure", source="consultation.heure")
	 @Mapping(target="observations", source="consultation.observations")
	 @Mapping(target="user", source="consultation.usersDto")
	 Consultation toEntity(ConsultationDto consultation);
	 
	List<ConsultationDto> listtoConsultationDto(List<Consultation> consultation);
		
	List<Consultation> listConsultationEntity(List<ConsultationDto> consultation);
}
