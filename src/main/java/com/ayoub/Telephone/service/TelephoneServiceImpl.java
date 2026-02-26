package com.ayoub.Telephone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ayoub.Telephone.entities.Telephone;
import com.ayoub.Telephone.repos.TelephoneRepository;




@Service
public class TelephoneServiceImpl implements TelephoneService  {
	  @Autowired
	    private TelephoneRepository telRepository;

	    @Override
	    public Telephone saveTel(Telephone t) {
	        return telRepository.save(t);
	    }

	    @Override
	    public Telephone updateTel(Telephone t) {
	        return telRepository.save(t);
	    }

	    @Override
	    public void deleteTel(Telephone t) {
	        telRepository.delete(t);
	    }

	    @Override
	    public void deleteTelById(Long id) {
	        telRepository.deleteById(id);
	    }

	    @Override
	    public Telephone getTel(Long id) {
	        return telRepository.findById(id).orElse(null);
	    }

	    @Override
	    public List<Telephone> getAllTels() {
	        return telRepository.findAll();
	    }

	    @Override
	    public Page<Telephone> getAllTelsParPage(int page, int size) {
	        return telRepository.findAll(PageRequest.of(page, size));
	    }

	   
	   
	

}
