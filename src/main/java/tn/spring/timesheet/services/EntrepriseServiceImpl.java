package tn.spring.timesheet.services;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tn.spring.timesheet.entities.Entreprise;
import tn.spring.timesheet.repository.EntrepriseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EntrepriseServiceImpl implements IEntrepriseService{

    private static final Logger logger = LogManager.getLogger(EntrepriseServiceImpl.class);

    private final EntrepriseRepository entrepriseRepoistory;

    @Override
    public Entreprise ajouterEntreprise(Entreprise entreprise) {
        logger.info("In ajouterEntreprise");

        try {
            logger.debug("adding  entity");
            Entreprise addedEntreprise = entrepriseRepoistory.save(entreprise);
            logger.info("Out ajouterEntreprise with success");
            return addedEntreprise;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Entreprise> getAllEntreprise() {
        logger.info("In getAllEntreprise");

        try {
            logger.debug("getting all entreprise");
            List<Entreprise> listEntreprise = entrepriseRepoistory.findAll();
            logger.info("Out getAllEntreprise with success");
            return listEntreprise;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public int getNombreEntreprise() {
        logger.info("In getNombreEntreprise");

        try {
            logger.debug("getting number of entreprise");
            int nbrEntreprise = entrepriseRepoistory.countEntreprise();
            logger.info("Out getNombreEntreprise with success");
            return nbrEntreprise;
        }catch (Exception e){
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<String> getAllEntrepriseNames() {
        logger.info("In getAllEntrepriseNames");

        try {
            logger.debug("getting entreprise name");
            List<String> entrepriseList = entrepriseRepoistory.getAllNamesOfEntreprise();
            logger.info("Out getAllEntrepriseNames with success");
            return entrepriseList;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<Entreprise> getAllEntrepriseByRaisonSocial(String raisonSocial) {
        logger.info("In getAllEntrepriseByRaisonSocial");

        try {
            logger.debug("getting entreprise by there raisonSocial");
            List<Entreprise> entrepriseList = entrepriseRepoistory.getAllEntrepriseByRaisonSocial(raisonSocial);
            logger.info("Out getAllEntrepriseByRaisonSocial with success");
            return entrepriseList;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Entreprise getEntrepriseById(int entrepriseId) {
        logger.info("In getEntrepriseById");

        try {
                logger.debug("getting entreprise by id");
                Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);
                if(value.isPresent()){
                    Entreprise entreprise = value.get();
                    logger.info("Out getEntrepriseById with success");
                    return entreprise;
                }else{
                    return null;
                }
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Entreprise editEntrepriseById(Entreprise entreprise, int id) {
        logger.info("In editEntrepriseById");

        try {
            logger.debug("editting entreprise by id");
            Optional<Entreprise> value=  entrepriseRepoistory.findById(id);
            if(value.isPresent()){
                Entreprise existedEntreprise = value.get();
                existedEntreprise.setName(entreprise.getName());
                existedEntreprise.setRaisonSocial(entreprise.getRaisonSocial());
                logger.info("Out editEntrepriseById with success");
                return entrepriseRepoistory.save(existedEntreprise);
            }else {
                logger.info("no entreprise found");
                return null;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Entreprise editEntrepriseNameById(String name, int id) {
        logger.info("In editEntrepriseNameById");

        try {
            logger.debug("editting entreprise name  by id");
            entrepriseRepoistory.editEntrepriseName(name,id);
            logger.info("Out editEntrepriseNameById with success");
            Optional<Entreprise> value =  entrepriseRepoistory.findById(id);
            if(value.isPresent()){
                return value.get();
            }else{
                return null;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteEntrepriseById(int entrepriseId) {
        logger.info("In editEntrepriseNameById");

        try {
            logger.debug("deleting entreprise   by id");
            entrepriseRepoistory.deleteById(entrepriseId);
            logger.info("Out editEntrepriseNameById with success");
        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }

    @Override
    public void deleteAllEntreprise() {
        logger.info("In deleteAllEntreprise");

        try {
            logger.debug("deleting all entreprise ");
            entrepriseRepoistory.deleteAll();
            logger.info("Out deleteAllEntreprise with success");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

}
