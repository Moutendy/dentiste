package api.dentiste.apidentiste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import api.dentiste.apidentiste.entity.Users;
import api.dentiste.apidentiste.util.ConstanteRepository;
@Repository
public interface UserRepository extends JpaRepository<Users,Long>{

//    List<Users> findByNom(String nom);
	@Query(value = ConstanteRepository.searchUser,nativeQuery = true)
	List<Users>searchUser(@Param("nom")String nom);

}
