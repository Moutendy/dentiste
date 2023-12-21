package api.dentiste.apidentiste.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dentiste.apidentiste.dto.RoleDto;
import api.dentiste.apidentiste.mapper.RoleMapper;
import api.dentiste.apidentiste.service.RoleI;

@RestController
@RequestMapping("api/role/")
public class RoleController {

	protected RoleI roleService;
	
	public RoleController(RoleI roleService,RoleMapper roleMapper)
	{
		this.roleService = roleService;
	}
	
	
	 @PostMapping(value="addrole" ,consumes = "application/json")
	 ResponseEntity<String> addRole(@RequestBody RoleDto roleDto) {
		 try {
			    roleService.addRole(roleDto);
	            return new ResponseEntity<>("Role added successfully", HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Failed to add role: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	 }
	 
	 @GetMapping(value="getrole/{name}" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<RoleDto> getRole(@PathVariable("name") String name) {
			// TODO Auto-generated method stub
			return roleService.getRole(name);
		}
	 
	 @DeleteMapping(value="deleterole/{id}" ,consumes = "application/json")
	 public ResponseEntity<String> deleteRole(@PathVariable("id") Long id) {
			// TODO Auto-generated method stub
			 try {
				    roleService.deleteRole(id);
		            return new ResponseEntity<>("Role delete successfully", HttpStatus.CREATED);
		        } catch (Exception e) {
		            return new ResponseEntity<>("Failed to delete role: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		        }
		}
}
