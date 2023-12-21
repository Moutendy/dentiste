package api.dentiste.apidentiste.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import api.dentiste.apidentiste.dto.UserDto;
import api.dentiste.apidentiste.entity.Users;

@Mapper(componentModel = "spring",uses = {RoleMapper.class})
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	 @Mapping(target="id", source="user.id")
	 @Mapping(target="nom", source="user.nom")
	 @Mapping(target="prenom", source="user.prenom")
	 @Mapping(target="specialite", source="user.specialite")
	 UserDto toDto(Users user);
	 

	 @Mapping(target="id", source="userDto.id")
	 @Mapping(target="nom", source="userDto.nom")
	 @Mapping(target="prenom", source="userDto.prenom")
	 @Mapping(target="specialite", source="userDto.specialite")
	 Users userDtotoUser(UserDto userDto);
	
	List<UserDto> listtoDto(List<Users> user);
	
	
	List<Users> listUserto(List<UserDto> user);
}
