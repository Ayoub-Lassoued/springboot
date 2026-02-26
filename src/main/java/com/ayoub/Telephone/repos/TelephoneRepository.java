package com.ayoub.Telephone.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayoub.Telephone.entities.Telephone;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {

}
