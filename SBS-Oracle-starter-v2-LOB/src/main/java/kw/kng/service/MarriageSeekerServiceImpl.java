package kw.kng.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.entity.MarriageSeeker;
import kw.kng.repo.MarriageSeekerRepo;

@Service
public class MarriageSeekerServiceImpl implements MarriageSeekerService 
{
	@Autowired
	private MarriageSeekerRepo mrepo;

	
	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) 
	{
		return "Marriage Seeker Info is saved with Id Value: "+ mrepo.save(seeker).getMsid();
	}

	@Override
	public Optional<MarriageSeeker> searchSeekerById(Long id) 
	{
		// TODO Auto-generated method stub
		return mrepo.findById(id);
	}

}
