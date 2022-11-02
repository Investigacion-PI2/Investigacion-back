package co.edu.icesi.researchgroupmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.researchgroupmanagement.dao.ResearchGroupDao;
import co.edu.icesi.researchgroupmanagement.model.Faculty;
import co.edu.icesi.researchgroupmanagement.model.Institution;
import co.edu.icesi.researchgroupmanagement.model.MincienciasCategory;
import co.edu.icesi.researchgroupmanagement.model.ResearchGroup;
import co.edu.icesi.researchgroupmanagement.model.SciTiNationalProgram;
import co.edu.icesi.researchgroupmanagement.repository.FacultyRepository;
import co.edu.icesi.researchgroupmanagement.repository.InstitutionRepository;
import co.edu.icesi.researchgroupmanagement.repository.MinCienciasCategoryRepository;
import co.edu.icesi.researchgroupmanagement.repository.ResearchGroupRepository;
import co.edu.icesi.researchgroupmanagement.repository.SciTiNationalProgramRepository;
import co.edu.icesi.researchgroupmanagement.repository.UserRepository;

@Service
public class ResearchGroupService {
    ResearchGroupDao rgr;
    FacultyRepository fr;
    InstitutionRepository ir;
    SciTiNationalProgramRepository scitir;
    MinCienciasCategoryRepository minr;
    UserRepository ur;

    @Autowired
    public ResearchGroupService(ResearchGroupDao rgr, FacultyRepository fr,
            SciTiNationalProgramRepository scitir, InstitutionRepository ir, MinCienciasCategoryRepository minr,
            UserRepository ur) {
        this.rgr = rgr;
        this.fr = fr;
        this.ir = ir;
        this.scitir = scitir;
        this.minr = minr;
        this.ur = ur;
    }

    @Transactional
    public ResearchGroup save(ResearchGroup rg) {
        // MincienciasCategory minCateg =
        // minr.findById(rg.getMincienciasCategory().getId()).get();
        // Faculty fac = fr.findById(rg.getFaculty().getId()).get();
        // Institution inst = ir.findById(rg.getInstitution().getId()).get();
        // SciTiNationalProgram sct =
        // scitir.findById(rg.getSciTiNationalProgram().getId()).get();
        ResearchGroup rg1 = new ResearchGroup();
        if (rg.getName() == null) {
            throw new IllegalArgumentException("El nombre del grupo de investigacion no puede estar vacio");
        } else if (rg.getMincienciasCategory() == null) {
            throw new IllegalArgumentException("La categoria no debe ser nula");
        } else if (rg.getDescription() == null) {
            throw new IllegalArgumentException("Descripcion no debe estar vacia");
            // Estas validaciones ahora son de la clase rgroupLeaders
            // } else if (rg.getCitizenId() == null) {
            // throw new IllegalArgumentException("Citizen id no debe ser nulo");
            // } else if (rg.getNationality() == null) {
            // throw new IllegalArgumentException("Nationality no debe ser nulo");
            // } else if (rg.getSecondLastName() == null) {
            // throw new IllegalArgumentException("Second lastname nulo");
            // } else if (rg.getCountryOfBirth() == null) {
            // throw new IllegalArgumentException("Pais de nacimiento nulo");
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
            rg1 = rg;
            rg1.setMincienciasCategory(minr.findById(rg.getMincienciasCategory().getId()).get());
            rg1.setFaculty(fr.findById(rg.getFaculty().getId()).get());
            rg1.setInstitution(ir.findById(rg.getInstitution().getId()).get());
            rg1.setSciTiNationalProgram(scitir.findById(rg.getSciTiNationalProgram().getId()).get());
            rg1.setUsers(ur.findById(rg.getUsers().getId()).get());
            rg1.setResearchLines(null);
            rgr.save(rg1);
            return rg1;
        }

    }

    @Transactional
    public Iterable<ResearchGroup> findAll() {
        return rgr.findAll();
    }

    @Transactional
    public ResearchGroup findById(Long id) {
        return rgr.findById(id);
    }

    @Transactional
    public Iterable<ResearchGroup> findByFaculty(String faculty) {
        return rgr.findByFaculty(faculty);
    }
}