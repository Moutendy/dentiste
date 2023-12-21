package api.dentiste.apidentiste.util.extraDto;

import api.dentiste.apidentiste.dto.ConsultationDto;
import api.dentiste.apidentiste.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsutationAndUser {
	 UserDto userDto;
	 ConsultationDto consultationDto;
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public ConsultationDto getConsultationDto() {
		return consultationDto;
	}
	public void setConsultationDto(ConsultationDto consultationDto) {
		this.consultationDto = consultationDto;
	}
}
