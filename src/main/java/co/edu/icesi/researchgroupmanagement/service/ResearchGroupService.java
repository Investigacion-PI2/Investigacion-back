package co.edu.icesi.researchgroupmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.researchgroupmanagement.model.Faculty;
import co.edu.icesi.researchgroupmanagement.model.ResearchGroup;
import co.edu.icesi.researchgroupmanagement.repository.FacultyRepository;
import co.edu.icesi.researchgroupmanagement.repository.InstitutionRepository;
import co.edu.icesi.researchgroupmanagement.repository.ResearchGroupRepository;
import co.edu.icesi.researchgroupmanagement.repository.SciTiNationalProgramRepository;

@Service
public class ResearchGroupService {
    ResearchGroupRepository rgr;
    FacultyRepository fr;
    InstitutionRepository ir;
    SciTiNationalProgramRepository scitir;

    @Autowired
    public ResearchGroupService(ResearchGroupRepository rgr, FacultyRepository fr,
            SciTiNationalProgramRepository scitir, InstitutionRepository ir) {
        this.rgr = rgr;
        this.fr = fr;
        this.ir = ir;
        this.scitir = scitir;
    }

    @Transactional
    public ResearchGroup save(ResearchGroup rg) {

        if (rg == null) {
            throw new IllegalArgumentException("El grupo de investigacion no puede ser nulo");
        } else if (rg.getName() == null) {
            throw new IllegalArgumentException("El nombre del grupo de investigacion no puede estar vacio");
        } else if (rg.getMincienciasCategory() == null) {
            throw new IllegalArgumentException("La categoria no debe ser nula");
        } else if (rg.getDescription() == null) {
            throw new IllegalArgumentException("Descripcion no debe estar vacia");
            // Estas validaciones ahora son de la clase rgroupLeaders
//        } else if (rg.getCitizenId() == null) {
//            throw new IllegalArgumentException("Citizen id no debe ser nulo");
//        } else if (rg.getNationality() == null) {
//            throw new IllegalArgumentException("Nationality no debe ser nulo");
//        } else if (rg.getSecondLastName() == null) {
//            throw new IllegalArgumentException("Second lastname nulo");
//        } else if (rg.getCountryOfBirth() == null) {
//            throw new IllegalArgumentException("Pais de nacimiento nulo");
        } else if (rg.getFaculty() == null) {
            throw new IllegalArgumentException("Facultad nulo");
        } else if (rg.getInstitution() == null) {
            throw new IllegalArgumentException("Intitucion nula");
        } else if (rg.getSciTiNationalProgram() == null) {
            throw new IllegalArgumentException("SciTiNatProgram nulo");
        } else if (rg.getUsers() == null) {
            throw new IllegalArgumentException("El grupo debe tener un lider");
        } else if (rg.getResearchLines().isEmpty()) {
            throw new IllegalArgumentException("El grupo debe tener al menos una linea de investigacion");
        } else if (fr.findById(rg.getFaculty().getId()).isEmpty()) {
            throw new IllegalArgumentException("Facultad no existe");
        } else if (ir.findById(rg.getInstitution().getId()).isEmpty()) {
            throw new IllegalArgumentException("Institucion no existe");
        } else if (scitir.findById(rg.getSciTiNationalProgram().getId()).isEmpty()) {
            throw new IllegalArgumentException("SciTiNationalProgram no existe");
        } else {
            rgr.save(rg);
            return rg;
        }

    }

    @Transactional
    public Iterable<ResearchGroup> findAll() {
        return rgr.findAll();
    }

    @Transactional
    public ResearchGroup findById(Long id) {
        return rgr.findById(id).get();
    }
}