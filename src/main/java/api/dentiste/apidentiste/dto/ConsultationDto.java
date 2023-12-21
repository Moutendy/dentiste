package api.dentiste.apidentiste.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultationDto {
	protected Long id;
	protected Date date;
	protected String heure;
    UserDto usersDto;
    public UserDto getUsersDto() {
		return usersDto;
	}
	public void setUsersDto(UserDto usersDto) {
		this.usersDto = usersDto;
	}
	private String observations;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
}
