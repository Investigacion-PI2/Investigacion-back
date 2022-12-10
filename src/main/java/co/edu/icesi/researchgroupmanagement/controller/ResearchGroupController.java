package co.edu.icesi.researchgroupmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.researchgroupmanagement.model.ResearchGroup;
import co.edu.icesi.researchgroupmanagement.service.ResearchGroupService;

@RestController
@RequestMapping("/api/researchgroup")
public class ResearchGroupController {

    @Autowired
    public ResearchGroupService service;

    @PostMapping
    public void save(@RequestBody ResearchGroup rg) {
        service.save(rg);
    }

    @GetMapping
    public Iterable<ResearchGroup> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResearchGroup findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }
}