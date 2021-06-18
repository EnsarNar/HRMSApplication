package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.ResumeTechnology;

public interface ResumeTechnologyDao extends JpaRepository<ResumeTechnology, Integer> {

}
