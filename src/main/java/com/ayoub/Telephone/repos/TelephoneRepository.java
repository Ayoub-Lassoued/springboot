package com.ayoub.Telephone.repos;

import com.ayoub.Telephone.entities.Statut;
import com.ayoub.Telephone.entities.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // ✅ ajouter cette annotation
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {

    List<Telephone> findByNomTel(String nomTel);

    List<Telephone> findByNomTelContains(String nom);

    @Query("select t from Telephone t where t.nomTel like %:nom% and t.prixTel > :prix")
    List<Telephone> findByNomPrix(@Param("nom") String nom,
                                  @Param("prix") Double prix);

    @Query("select t from Telephone t order by t.nomTel ASC, t.prixTel DESC")
    List<Telephone> trierTelephonesNomsPrix();

    // ❌ findByStatutIdSat — Spring ne connait pas "IdSat"
    // ✅ Remplacer par @Query ou le bon nom du champ
    @Query("select t from Telephone t where t.statut.idSat = :id")
    List<Telephone> findByStatutIdSat(@Param("id") Long id);

    @Query("select t from Telephone t where t.statut = ?1")
    List<Telephone> findByStatut(Statut statut);

    List<Telephone> findByOrderByNomTelAsc();
}