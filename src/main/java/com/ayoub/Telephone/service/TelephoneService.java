package com.ayoub.Telephone.service;

import com.ayoub.Telephone.dto.TelephoneDTO;
import com.ayoub.Telephone.entities.Statut;
import com.ayoub.Telephone.entities.Telephone;



import org.springframework.data.domain.Page;

import java.util.List;

public interface TelephoneService {

    TelephoneDTO saveTel(TelephoneDTO t);
    TelephoneDTO updateTel(TelephoneDTO t);
    void deleteTel(Telephone t);
    void deleteTelById(Long id);
    TelephoneDTO getTel(Long id);
    List<TelephoneDTO> getAllTels();
    Page<Telephone> getAllTelsParPage(int page, int size);

    List<Telephone> findByNomTelephone(String nomTel);
    List<Telephone> findByNomTelephonesContains(String nomTel);
    List<Telephone> findByNomPrix(String nom, Double prix);
    List<Telephone> findByStatut(Statut statut);
    List<Telephone> findByStatutIdSat(Long id);
    List<Telephone> findByOrderByNomTelephoneAsc();
    List<Telephone> trierTelephonesNomsPrix();
    Statut getStatutById(Long id);
    List<Statut> getAllStatuts();
    TelephoneDTO convertEntityToDto (Telephone telephone);
    Telephone convertDtoToEntity(TelephoneDTO telephoneDTO);



}