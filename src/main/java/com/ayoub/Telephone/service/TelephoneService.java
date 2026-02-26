package com.ayoub.Telephone.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ayoub.Telephone.entities.Telephone;


public interface TelephoneService {
	Telephone saveTel(Telephone t);
    Telephone updateTel(Telephone t);
    void deleteTel(Telephone t);
    void deleteTelById(Long id);
    Telephone getTel(Long id);
    List<Telephone> getAllTels();
    Page<Telephone> getAllTelsParPage(int page, int size);


}
