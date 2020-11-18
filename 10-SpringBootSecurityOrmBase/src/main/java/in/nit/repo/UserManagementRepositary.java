package in.nit.repo;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.domain.UserManagement;
import in.nit.entity.UserManagementEntity;

public interface UserManagementRepositary extends JpaRepository<UserManagementEntity, Serializable>{
	
Optional<UserManagement> findByUserEmail(String email);

}
