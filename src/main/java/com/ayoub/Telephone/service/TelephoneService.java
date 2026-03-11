package com.ayoub.Telephone.service;

import com.ayoub.Telephone.entities.Statut;
import com.ayoub.Telephone.entities.Telephone;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TelephoneService {

    Telephone saveTel(Telephone t);
    Telephone updateTel(Telephone t);
    void deleteTel(Telephone t);
    void deleteTelById(Long id);
    Telephone getTel(Long id);
    List<Telephone> getAllTels();
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
    // ✅ ne pas oublier
}