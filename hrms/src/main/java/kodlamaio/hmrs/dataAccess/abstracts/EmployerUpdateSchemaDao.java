package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.EmployerUpdateSchema;

public interface EmployerUpdateSchemaDao extends JpaRepository<EmployerUpdateSchema,Integer> {
	EmployerUpdateSchema getById(int id);
	EmployerUpdateSchema getByEmployerId(int id);
	List<EmployerUpdateSchema> findByEmployerIdAndEmailIsNotNull(int id);
	}
