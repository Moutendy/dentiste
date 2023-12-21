package api.dentiste.apidentiste.service;

import java.util.List;

import api.dentiste.apidentiste.dto.RoleDto;

public interface RoleI {

	List<RoleDto> getRole(String name);
	
    void addRole(RoleDto role);
    
    void deleteRole(Long role_id);
}
