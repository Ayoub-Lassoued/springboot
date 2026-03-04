package com.ayoub.Telephone.repos;

import com.ayoub.Telephone.entities.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ayoub.Telephone.entities.Telephone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
    List<Telephone> findByNomTel(String nomTel);
    List<Telephone> findByNomTelContains(String nom);
    @Query("select t from Telephone t where t.nomTel like %:nom% and t.prixTel > :prix")
    List<Telephone> findByNomPrix(@Param("nom") String nom,
                                  @Param("prix") Double prix);
    @Query("select t from Telephone t order by t.nomTel ASC, t.prixTel DESC")
    List<Telephone> trierTelephonesNomsPrix();
    List<Telephone> findByStatutIdSat(Long id);
    @Query("select t from Telephone t where t.statut = ?1")
    List<Telephone> findByStatut (Statut statut);
    List<Telephone> findByOrderByNomTelAsc();




}
