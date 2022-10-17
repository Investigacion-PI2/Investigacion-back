package co.edu.icesi.researchgroupmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.researchgroupmanagement.model.ResearchGroup;
import co.edu.icesi.researchgroupmanagement.repository.ResearchGroupRepository;

@Service
public class ResearchGroupService {
    ResearchGroupRepository rgr;

    @Autowired
    public ResearchGroupService(ResearchGroupRepository rgr) {
        this.rgr = rgr;
    }

    @Transactional
    public ResearchGroup save(ResearchGroup rg) {
        if (rg == null) {
            throw new IllegalArgumentException("El grupo de investigacion no puede ser nulo");
        } else if (rg.getName() == null) {
            throw new IllegalArgumentException("El nombre del grupo de investigacion no puede estar vacio");
        } else if (rg.getColcienciasCategory() == null) {
            throw new IllegalArgumentException("La categoria no debe ser nula");
        } else if (rg.getDescription() == null) {
            throw new IllegalArgumentException("Descripcion no debe estar vacia");
        } else if (rg.getCitizenId() == null) {
            throw new IllegalArgumentException("Citizen id no debe ser nulo");
        } else if (rg.getNationality() == null) {
            throw new IllegalArgumentException("Nationality no debe ser nulo");
        } else if (rg.getSecondLastName() == null) {
            throw new IllegalArgumentException("Second lastname nulo");
        } else if (rg.getCountryOfBirth() == null) {
            throw new IllegalArgumentException("Pais de nacimiento nulo");
        } else if (rg.getFaculty() == null) {
            throw new IllegalArgumentException("Facultad nulo");
        } else if (rg.getInstitution() == null) {
            throw new IllegalArgumentException("Intitucion nula");
        } else if (rg.getSciTiNationalProgram() == null) {
            throw new IllegalArgumentException("SciTiNatProgram nulo");
        } else {
            rgr.save(rg);
            return rg;
        }

    }
}