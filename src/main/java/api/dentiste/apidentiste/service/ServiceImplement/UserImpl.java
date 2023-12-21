package api.dentiste.apidentiste.service.ServiceImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import api.dentiste.apidentiste.dto.UserDto;
import api.dentiste.apidentiste.mapper.UserMapper;
import api.dentiste.apidentiste.repository.UserRepository;
import api.dentiste.apidentiste.service.UserI;

@Service
public class UserImpl implements UserI{
	
	protected UserMapper userMapper;
	protected UserRepository userRepository;
	
	public UserImpl(UserMapper userMapper, UserRepository userRepository) {
		this.userMapper = userMapper;
		this.userRepository = userRepository;
	}

	@SuppressWarnings("deprecation")
	@Override
	public UserDto getUser(Long id) {
		// TODO Auto-generated method stub
		return userMapper.toDto(userRepository.getOne(id));
	}

	@Override
	public void addUser(UserDto user) {
		// TODO Auto-generated method stub
		userRepository.save(userMapper.userDtotoUser(user));
	}

	@Override
	public List<UserDto> showUser() {
		// TODO Auto-generated method stub
		return userMapper.listtoDto(userRepository.findAll());
	}

	@Override
	public List<UserDto> searchUser(String name) {
		// TODO Auto-generated method stub
		return userMapper.listtoDto(userRepository.searchUser(name));
	}

}
