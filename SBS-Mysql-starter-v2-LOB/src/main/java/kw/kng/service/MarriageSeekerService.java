package kw.kng.service;

import java.util.Optional;

import kw.kng.entity.MarriageSeeker;

public interface MarriageSeekerService 
{
	public String registerMarriageSeeker(MarriageSeeker seeker);
	public Optional<MarriageSeeker> searchSeekerById(Long id);

}
