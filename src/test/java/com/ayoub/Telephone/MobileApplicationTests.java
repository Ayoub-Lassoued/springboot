package com.ayoub.Telephone;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ayoub.Telephone.entities.Telephone;
import com.ayoub.Telephone.service.TelephoneService;

@SpringBootTest
class MobileApplicationTests {

	 @Autowired
	    private TelephoneService telService;

	    @Test
	    public void testSaveTel() {
	        Telephone tel = new Telephone(
	                "iPhone 12",
	                "Très bon téléphone",
	                2200.0,
	                new Date(),
	                "apple@gmail.com"
	        );

	        Telephone savedTel = telService.saveTel(tel);
	        System.out.println(savedTel);
	    }

	    @Test
	    public void testGetTel() {
	        Telephone tel = telService.getTel(1L);
	        System.out.println(tel);
	    }

	    @Test
	    public void testUpdateTel() {
	    	Telephone tel = telService.getTel(1L);

	        if (tel != null) {
	            tel.setPrixTel(2500.0);
	            telService.updateTel(tel);
	        }
	    }

	    @Test
	    public void testDeleteTelById() {
	        telService.deleteTelById(1L);
	    }

	    @Test
	    public void testDeleteTel() {
	    	Telephone tel = telService.getTel(1L);
	        if (tel != null) {
	            telService.deleteTel(tel);
	        }
	    }

	    @Test
	    public void testGetAllTels() {
	        List<Telephone> tels = telService.getAllTels();
	        for (Telephone t : tels) {
	            System.out.println(t);
	        }
	    }
	    @Test
	    public void testFindByNomTelContains() {

	        Page<Telephone> tels = telService.getAllTelsParPage(0, 2);

	        System.out.println("Size: " + tels.getSize());
	        System.out.println("Total Elements: " + tels.getTotalElements());
	        System.out.println("Total Pages: " + tels.getTotalPages());

	        tels.getContent().forEach(t -> {
	            System.out.println(t.toString());
	        });

	    }}
