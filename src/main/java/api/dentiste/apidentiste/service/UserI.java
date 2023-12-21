package api.dentiste.apidentiste.service;

import java.util.List;


import api.dentiste.apidentiste.dto.UserDto;

public interface UserI {
	
	UserDto getUser(Long id);
	
    void addUser(UserDto user);
    
    List<UserDto> showUser();
    
    List<UserDto> searchUser(String name);
}
