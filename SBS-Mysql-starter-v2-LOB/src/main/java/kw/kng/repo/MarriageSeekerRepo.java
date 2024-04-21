package kw.kng.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kw.kng.entity.MarriageSeeker;

@Repository
public interface MarriageSeekerRepo extends JpaRepository<MarriageSeeker, Long>
{

}
