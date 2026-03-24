package com.ayoub.Telephone.service;

import com.ayoub.Telephone.dto.TelephoneDTO;
import com.ayoub.Telephone.entities.Statut;
import com.ayoub.Telephone.entities.Telephone;
import com.ayoub.Telephone.repos.StatutRepository;
import com.ayoub.Telephone.repos.TelephoneRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TelephoneServiceImpl implements TelephoneService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private TelephoneRepository telRepository;

    @Autowired
    private StatutRepository statutRepository;

    // ✅ SAVE
    @Override
    public TelephoneDTO saveTel(TelephoneDTO t) {
        Telephone tel = convertDtoToEntity(t);
        Telephone savedTel = telRepository.save(tel);
        return convertEntityToDto(savedTel);
    }

    // ✅ UPDATE
    @Override
    public TelephoneDTO updateTel(TelephoneDTO t) {
        Telephone tel = convertDtoToEntity(t);
        Telephone updatedTel = telRepository.save(tel);
        return convertEntityToDto(updatedTel);
    }

    // ✅ DELETE BY ENTITY
    @Override
    public void deleteTel(Telephone t) {
        telRepository.delete(t);
    }

    // ✅ DELETE BY ID
    @Override
    public void deleteTelById(Long id) {
        telRepository.deleteById(id);
    }

    // ✅ GET BY ID
    @Override
    public TelephoneDTO getTel(Long id) {
        return telRepository.findById(id)
                .map(this::convertEntityToDto)
                .orElse(null);
    }

    // ✅ GET ALL
    @Override
    public List<TelephoneDTO> getAllTels() {
        return telRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    // ✅ GET ALL WITH PAGINATION
    @Override
    public Page<Telephone> getAllTelsParPage(int page, int size) {
        return telRepository.findAll(PageRequest.of(page, size));
    }

    // ✅ SEARCH BY NAME
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

    // ✅ STATUT
    @Override
    public Statut getStatutById(Long id) {
        return statutRepository.findById(id).orElse(null);
    }

    @Override
    public List<Statut> getAllStatuts() {
        return statutRepository.findAll();
    }

    // ✅ CONVERT ENTITY → DTO
    // ✅ CONVERT ENTITY → DTO
    @Override
    public TelephoneDTO convertEntityToDto(Telephone telephone) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TelephoneDTO telephoneDTO = modelMapper.map(telephone, TelephoneDTO.class);
        return telephoneDTO; // ✅ كان produitDTO خطأ
    }

    // ✅ CONVERT DTO → ENTITY
    @Override
    public Telephone convertDtoToEntity(TelephoneDTO telephoneDTO) {
        Telephone telephone = new Telephone();
        telephone = modelMapper.map(telephoneDTO, Telephone.class); // ✅ كان TelephoneDTO.class خطأ
        return telephone;
    }}