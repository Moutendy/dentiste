package api.dentiste.apidentiste.service.ServiceImplement;

import java.util.List;

import org.springframework.stereotype.Service;

import api.dentiste.apidentiste.dto.RoleDto;
import api.dentiste.apidentiste.mapper.RoleMapper;
import api.dentiste.apidentiste.repository.RoleRepository;
import api.dentiste.apidentiste.service.RoleI;

@Service
public class RoleImp implements RoleI{

	protected RoleMapper roleMapper;
	protected RoleRepository roleRepository;
	
	public RoleImp(RoleMapper roleMapper,RoleRepository roleRepository) {
		this.roleMapper = roleMapper;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public List<RoleDto> getRole(String name) {
		// TODO Auto-generated method stub
		return roleMapper.listRoletoListRoleDto(roleRepository.searchRole(name));
	}

	@Override
	public void addRole(RoleDto role) {
		// TODO Auto-generated method stub		
		roleRepository.save(roleMapper.DtotoRole(role));
	}
	
	@Override
	public void deleteRole(Long role_id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(role_id);
	}


}
