package tn.spring.timesheet.services;


import tn.spring.timesheet.entities.Entreprise;
import java.util.List;

public interface IEntrepriseService {
     Entreprise ajouterEntreprise(Entreprise entreprise);
     List<Entreprise> getAllEntreprise();
     int getNombreEntreprise();
     List<String> getAllEntrepriseNames();
     List<Entreprise> getAllEntrepriseByRaisonSocial(String raisonSocial);
     Entreprise getEntrepriseById(int entrepriseId);
     Entreprise editEntrepriseById(Entreprise entreprise,int id);
     Entreprise editEntrepriseNameById(String name,int id);
     void deleteEntrepriseById(int entrepriseId);
     void deleteAllEntreprise();
}
