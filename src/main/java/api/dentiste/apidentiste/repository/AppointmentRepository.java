package api.dentiste.apidentiste.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import api.dentiste.apidentiste.entity.Appointment;
import api.dentiste.apidentiste.util.ConstanteRepository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
	@Query(value = ConstanteRepository.searchAppointmentByUser,nativeQuery = true)
	List<Appointment>searchAppointment(@Param("name")String name);
	
	@Query(value = ConstanteRepository.searchAppointmentByDate,nativeQuery = true)
	List<Appointment>searchAppointmentByDate(@Param("date")Date date);
}
