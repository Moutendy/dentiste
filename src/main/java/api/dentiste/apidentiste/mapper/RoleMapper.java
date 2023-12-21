package api.dentiste.apidentiste.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import api.dentiste.apidentiste.dto.RoleDto;
import api.dentiste.apidentiste.entity.Role;


@Mapper(componentModel = "spring")

public interface RoleMapper {

	 RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	 @Mapping(target="id", source="role.id")
	 @Mapping(target="name", source="role.name")
	 RoleDto RoletoDto(Role role);
	 
	 @Mapping(target="id", source="roleDto.id")
	 @Mapping(target="name", source="roleDto.name")
	 Role DtotoRole(RoleDto roleDto);
	
	 List<RoleDto> listRoletoListRoleDto(List<Role> role);
	
	 List<Role> listRoleDtotoListRole(List<RoleDto> roleDto);
}
