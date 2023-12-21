package api.dentiste.apidentiste.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import api.dentiste.apidentiste.entity.Consultation;
import api.dentiste.apidentiste.util.ConstanteRepository;
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{

	@Query(value = ConstanteRepository.searchConsultationByDate,nativeQuery = true)
	List<Consultation>searchConsultationByDate(@Param("date")Date date);
	
	@Query(value = ConstanteRepository.searchConsultationByUser,nativeQuery = true)
	List<Consultation>searchConsultationByUser(@Param("nom")String nom);
	
}
