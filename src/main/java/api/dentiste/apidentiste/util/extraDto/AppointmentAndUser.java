package api.dentiste.apidentiste.util.extraDto;

import api.dentiste.apidentiste.dto.RdvDto;
import api.dentiste.apidentiste.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentAndUser {
	 UserDto userDto;
	 RdvDto rdvDto;
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public RdvDto getRdvDto() {
		return rdvDto;
	}
	public void setRdvDto(RdvDto rdvDto) {
		this.rdvDto = rdvDto;
	}

}
