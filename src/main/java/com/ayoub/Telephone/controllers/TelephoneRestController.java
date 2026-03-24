package com.ayoub.Telephone.controllers;

import com.ayoub.Telephone.dto.TelephoneDTO;
import com.ayoub.Telephone.service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tels")
@CrossOrigin
public class TelephoneRESTController {
    @Autowired
    TelephoneService telephoneService;
    @RequestMapping(method = RequestMethod.GET)
    public List<TelephoneDTO> getAllTels() {
        return telephoneService.getAllTels();
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public TelephoneDTO getTelById(@PathVariable("id") Long id) {
        return telephoneService.getTel(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public TelephoneDTO createtel(@RequestBody TelephoneDTO telephoneDTO) {
    return telephoneService.saveTel(telephoneDTO);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public TelephoneDTO updateTel(@RequestBody TelephoneDTO telephoneDTO) {
    return telephoneService.updateTel(telephoneDTO);
    }
}
