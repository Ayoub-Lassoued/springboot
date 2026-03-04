package com.ayoub.Telephone.service;

import java.util.List;

import com.ayoub.Telephone.entities.Statut;
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

    @Override
    public List<Telephone> findByNomTelephone(String nomTel) {
        return telRepository.findByNomTel(nomTel);
    }

    @Override
    public List<Telephone> findByNomTelephonesContains(String nomTel) {
        return telRepository.findByNomTelContains(nomTel);
    }

    @Override
    public List<Telephone> findByNomPrix(String nom, Double prix) {
        return telRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Telephone> findByStatut(Statut statut) {
        return telRepository.findByStatut(statut);
    }

    @Override
    public List<Telephone> findByStatutIdSat(Long id) {
        return telRepository.findByStatutIdSat(id);
    }

    @Override
    public List<Telephone> findByOrderByNomTelephoneAsc() {
        return telRepository.findByOrderByNomTelAsc();
    }

    @Override
    public List<Telephone> trierTelephonesNomsPrix() {
        return telRepository.findByOrderByNomTelAsc();
    }


}
