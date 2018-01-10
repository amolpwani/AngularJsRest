package com.ford.afd.controller;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ford.afd.model.Catagory;
import com.ford.afd.repository.CatagoryRepository;

/**
 * Created by dchiruma on 12/26/2017.
 */

@RestController
@RequestMapping("/catagory")
public class CatagoryController {
    @Autowired
    private CatagoryRepository catagoryRepository;

    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public List<Catagory> catagories(){return catagoryRepository.findAll();}

    @RequestMapping(value = "getList/{id}",method = RequestMethod.GET)
    public Catagory catagoryById(@PathVariable long id ){return catagoryRepository.findOne(id);}

    @RequestMapping(value="getList/{id}",method=RequestMethod.PUT)
    public Catagory updateCatagory(@PathVariable long id, @RequestBody Catagory catagory){
    	Catagory existingCatagory = catagoryRepository.findOne(id);
        BeanUtils.copyProperties(catagory, existingCatagory);
        return catagoryRepository.saveAndFlush(existingCatagory);
    }

    @RequestMapping(value = "deleteCatagoryById/{id}",method = RequestMethod.DELETE)
    public Catagory deleteCatagoryById(@PathVariable long id ){
    	Catagory catagory = catagoryRepository.findOne(id);
        catagoryRepository.delete(id);
        return catagory;
    }

    @RequestMapping(value="getList",method=RequestMethod.POST)
    public Catagory createListData(@RequestBody Catagory catagory) {
     return catagoryRepository.saveAndFlush(catagory);
    }

}
