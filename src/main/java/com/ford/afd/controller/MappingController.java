package com.ford.afd.controller;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ford.afd.model.Mapping;
import com.ford.afd.repository.MappingRepository;

/**
 * Created by dchiruma on 12/26/2017.
 */

@RestController
@RequestMapping("/mapping")
public class MappingController {
    @Autowired
    private MappingRepository mappingRepository;

    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public List<Mapping> mappings(){return mappingRepository.findAll();}

    @RequestMapping(value = "getList/{id}",method = RequestMethod.GET)
    public Mapping mappingById(@PathVariable long id ){return mappingRepository.findOne(id);}

    @RequestMapping(value="getList/{id}",method=RequestMethod.PUT)
    public Mapping updateMapping(@PathVariable long id, @RequestBody Mapping mapping){
    	Mapping existingMapping = mappingRepository.findOne(id);
        BeanUtils.copyProperties(mapping, existingMapping);
        return mappingRepository.saveAndFlush(existingMapping);
    }

    @RequestMapping(value = "deleteMappingById/{id}",method = RequestMethod.DELETE)
    public Mapping deleteMappingById(@PathVariable long id ){
    	Mapping mapping = mappingRepository.findOne(id);
        mappingRepository.delete(id);
        return mapping;
    }

    @RequestMapping(value="getList",method=RequestMethod.POST)
    public Mapping createMapping(@RequestBody Mapping mapping) {
     return mappingRepository.saveAndFlush(mapping);
    }

}
