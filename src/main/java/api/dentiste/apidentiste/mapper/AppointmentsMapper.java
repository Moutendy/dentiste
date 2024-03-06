package api.dentiste.apidentiste.mapper;

import java.util.List;

import api.dentiste.apidentiste.dto.RdvDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import api.dentiste.apidentiste.entity.Rdv;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface AppointmentsMapper {
	AppointmentsMapper INSTANCE = Mappers.getMapper(AppointmentsMapper.class);
	
	 @Mapping(target="id", source = "rdv.id")
	 @Mapping(target="date", source = "rdv.date")
	 @Mapping(target="heure", source = "rdv.heure")
	 @Mapping(target="userDto", source = "rdv.user")
     RdvDto oneToDto(Rdv rdv);

	 @Mapping(target = "id", source="rdvDto.id")
	 @Mapping(target = "date", source="rdvDto.date")
	 @Mapping(target = "heure", source="rdvDto.heure")
	 @Mapping(target="user", source = "rdvDto.userDto")
	 Rdv transformaDtoToEntity(RdvDto rdvDto);

	List<RdvDto> listtoRendezVousDto(List<Rdv> rdv);
		
	List<Rdv> listRendezVousEntity(List<RdvDto> rdvDtoList);
}
