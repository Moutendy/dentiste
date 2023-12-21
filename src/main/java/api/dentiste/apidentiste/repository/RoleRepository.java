package api.dentiste.apidentiste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import api.dentiste.apidentiste.entity.Role;
import api.dentiste.apidentiste.util.ConstanteRepository;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

	@Query(value = ConstanteRepository.searchRole,nativeQuery = true)
	List<Role>searchRole(@Param("nom")String nom);
}
