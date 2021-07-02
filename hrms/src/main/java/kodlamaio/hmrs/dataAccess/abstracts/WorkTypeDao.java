package kodlamaio.hmrs.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hmrs.entities.concretes.WorkType;



public interface WorkTypeDao extends JpaRepository<WorkType,Integer> {
}
