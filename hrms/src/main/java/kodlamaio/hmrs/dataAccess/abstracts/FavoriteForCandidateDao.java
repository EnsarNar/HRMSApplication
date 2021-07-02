package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.FavoriteForCandidate;

public interface FavoriteForCandidateDao extends JpaRepository<FavoriteForCandidate,Integer>{
	List<FavoriteForCandidate> findAllByCandidate_Id(int candidateId);
	Page<FavoriteForCandidate> findAllByCandidate_Id(int candidateId,Pageable pageable);
}
