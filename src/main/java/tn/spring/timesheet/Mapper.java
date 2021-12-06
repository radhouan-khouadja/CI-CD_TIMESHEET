package tn.spring.timesheet;

import org.springframework.stereotype.Component;
import tn.spring.timesheet.entities.Entreprise;
import tn.spring.timesheet.entities.EntrepriseDTO;

@Component
public class Mapper {
    public EntrepriseDTO toEntrepriseDto(Entreprise entreprise){
        EntrepriseDTO entrepriseDTO = new EntrepriseDTO();
        entrepriseDTO.setName(entreprise.getName());
        entrepriseDTO.setRaisonSocial(entreprise.getRaisonSocial());
        entrepriseDTO.setId(entreprise.getId());
        return entrepriseDTO;
    }

    public Entreprise toEntreprise(EntrepriseDTO entrepriseDTO){
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDTO.getId());
        entreprise.setName(entrepriseDTO.getName());
        entreprise.setRaisonSocial(entrepriseDTO.getRaisonSocial());
        return entreprise;
    }

}
