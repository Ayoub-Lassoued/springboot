package com.ayoub.Telephone.repos;

import com.ayoub.Telephone.entities.Statut;
import com.ayoub.Telephone.entities.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutRepository extends JpaRepository<Statut, Long> {
}
