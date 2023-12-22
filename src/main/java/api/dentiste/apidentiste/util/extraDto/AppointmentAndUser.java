package api.dentiste.apidentiste.util.extraDto;

import api.dentiste.apidentiste.dto.AppointmentDto;
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
	 AppointmentDto appointmentDto;
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public AppointmentDto getAppointmentDto() {
		return appointmentDto;
	}
	public void setAppointmentDto(AppointmentDto appointmentDto) {
		this.appointmentDto = appointmentDto;
	}

}
