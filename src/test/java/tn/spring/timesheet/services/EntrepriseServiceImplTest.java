package tn.spring.timesheet.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.spring.timesheet.entities.Entreprise;
import tn.spring.timesheet.repository.EntrepriseRepository;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
class EntrepriseServiceImplTest {

    @Mock private EntrepriseRepository entrepriseRepository;

    private EntrepriseServiceImpl underTest;

    private static final Logger logger = LogManager.getLogger(EntrepriseServiceImplTest.class);

    @BeforeEach
    void setUp(){
        underTest = new EntrepriseServiceImpl(entrepriseRepository);
    }

    @Test
    void ajouterEntreprise() {
        logger.info("testing ajouterEntreprise");
        logger.debug("adding  entity");
        Entreprise entreprise = new Entreprise("tictactrip","informatique");
        logger.debug("Mock save method in entrepriserepository");
        Mockito.when(entrepriseRepository.save(entreprise)).thenReturn(entreprise);
        try {
            logger.debug("testing ajouterEntreprise method");
            Entreprise addedEntreprise = underTest.ajouterEntreprise(entreprise);
            assertThat(addedEntreprise.getName()).isEqualTo(entreprise.getName());
            logger.info("Out ajouterEntreprise with success");
            assertThat(addedEntreprise.getRaisonSocial()).isEqualTo(entreprise.getRaisonSocial());
        }catch (Exception e){
            logger.error("Error in ajouterEntreprise causedBy"+e.getMessage());
        }
    }

    @Test
    void getAllEntreprise() {
        logger.info("testing getAllEntreprise");
        logger.debug("adding  Entreprise list for testing");
        List<Entreprise> listEntreprise = new ArrayList<>();
        logger.debug("adding  first entreprise");
        Entreprise entreprise1 = new Entreprise("tictactrip","informatique");
        logger.debug("adding  second entreprise");
        Entreprise entreprise2 = new Entreprise("sofrecom","informatique");
        logger.debug("adding  third entreprise");
        Entreprise entreprise3 = new Entreprise("vermeg","informatique");
        listEntreprise.add(entreprise1);
        listEntreprise.add(entreprise2);
        listEntreprise.add(entreprise3);
        logger.info("Mock findall method in entrepriserepository");
        Mockito.when(entrepriseRepository.findAll()).thenReturn(listEntreprise);
        try {
            logger.debug("testing getAllEntreprise method");
            List<Entreprise> listEntrepriseTest = underTest.getAllEntreprise();
            logger.info("Out getAllEntreprise with success");
            assertThat(listEntrepriseTest).asList().contains(entreprise1).contains(entreprise2).contains(entreprise3).hasSize(3);
        }catch (Exception e){
            logger.error("Error in getAllEntreprise causedBy"+e.getMessage());
        }
    }

    @Test
    void getNombreEntreprise() {
        logger.info("testing getNombreEntreprise");
        logger.info("Mock count employees method in entrepriserepository");
        Mockito.when(entrepriseRepository.countEntreprise()).thenReturn(3);
        try {
            logger.debug("testing getNombreEntreprise method");
            assertThat(underTest.getNombreEntreprise()).isEqualTo(3);
            logger.info("Out getNombreEntreprise with success");
        }catch (Exception e){
            logger.error("Error in getNombreEntreprise causedBy"+e.getMessage());
        }
    }

    @Test
    void getAllEntrepriseNames() {
        logger.info("testing getAllEntrepriseNames");
        logger.debug("creating string name  list for testing");
        List<String> nameList = new ArrayList<>();
        logger.debug("adding  first name");
        nameList.add("tictactrip");
        logger.debug("adding  first name");
        nameList.add("vermeg");
        logger.debug("adding  first name");
        nameList.add("sofrecom");
        logger.info("Mock  getAllNamesOfEntreprise in entrepriserepository");
        Mockito.when(entrepriseRepository.getAllNamesOfEntreprise()).thenReturn(nameList);
        try {
            logger.debug("testing getAllEntrepriseNames method");
            assertThat(underTest.getAllEntrepriseNames()).asList().contains("tictactrip").contains("vermeg").contains("sofrecom");
            logger.info("Out getAllEntrepriseNames with success");
        }catch (Exception e){
            logger.error("Error in getAllEntrepriseNames causedBy"+e.getMessage());
        }
    }

    @Test
    void getAllEntrepriseByRaisonSocial() {
        logger.info("testing getAllEntrepriseByRaisonSocial");
        logger.debug("creating entreprise  list for testing");
        List<Entreprise> listEntreprise = new ArrayList<>();
        Entreprise entreprise1 = new Entreprise("tictactrip","informatique");
        Entreprise entreprise2 = new Entreprise("sofrecom","informatique");
        Entreprise entreprise3 = new Entreprise("vermeg","informatique");
        logger.debug("adding  first entity");
        listEntreprise.add(entreprise1);
        logger.debug("adding  first entity");
        listEntreprise.add(entreprise2);
        logger.debug("adding  first entity");
        listEntreprise.add(entreprise3);
        logger.info("Mock getAllEntrepriseByRaisonSocial in entrepriserepository");
        Mockito.when(underTest.getAllEntrepriseByRaisonSocial("informatique")).thenReturn(listEntreprise);
        try {
            logger.debug("testing getAllEntrepriseByRaisonSocial method");
            assertThat(underTest.getAllEntrepriseByRaisonSocial("informatique")).asList().contains(entreprise1).contains(entreprise2).contains(entreprise3).hasSize(3);
            logger.info("Out getAllEntrepriseByRaisonSocial with success");
        }catch (Exception e){
            logger.error("Error in getAllEntrepriseByRaisonSocial causedBy"+e.getMessage());
        }
    }

    @Test
    void getEntrepriseById() {
        logger.info("testing getEntrepriseById");
        logger.debug("creating entreprise  entity for testing");
        Entreprise entreprise = new Entreprise("tictactrip","informatique");
        logger.info("Mock findById in entrepriserepository");
        Mockito.when(entrepriseRepository.findById(1)).thenReturn(java.util.Optional.of(entreprise));
        try {
            logger.debug("testing getEntrepriseById method");
            assertThat(underTest.getEntrepriseById(1).getName()).isEqualTo(entreprise.getName());
            assertThat(underTest.getEntrepriseById(1).getRaisonSocial()).isEqualTo(entreprise.getRaisonSocial());
            logger.info("Out getEntrepriseById with success");
        }catch (Exception e){
            logger.error("Error in getAllEntrepriseByRaisonSocial causedBy"+e.getMessage());
        }

    }

    @Test
    void editEntrepriseById() {
        logger.info("testing editEntrepriseById");
        int id = 1;
        logger.debug("creating entreprise  entity for testing");
        Entreprise entreprise = new Entreprise("tictactrip","informatique");
        logger.debug("creating entreprise  entity  for testing");
        Entreprise edittedEntreprise =new Entreprise("vermeg","assurence");
        logger.info("Mock findById in entrepriserepository");
        Mockito.when(entrepriseRepository.findById(id)).thenReturn(java.util.Optional.of(entreprise));
        logger.info("Mock save in entrepriserepository");
        Mockito.when(entrepriseRepository.save(entreprise)).thenReturn(edittedEntreprise);
        try {
            logger.debug("testing editEntrepriseById method");
            Entreprise updatedEntreprise = underTest.editEntrepriseById(edittedEntreprise,1);
            assertThat(updatedEntreprise.getRaisonSocial()).isEqualTo(edittedEntreprise.getRaisonSocial());
            assertThat(updatedEntreprise.getName()).isEqualTo(edittedEntreprise.getName());
            logger.info("Out editEntrepriseById with success");
        }catch (Exception e){
            logger.error("Error in editEntrepriseById causedBy"+e.getMessage());
        }

    }

    @Test
    void editEntrepriseNameById() {
        logger.info("testing editEntrepriseNameById");
        int id = 1;
        logger.debug("creating entreprise  entity for testing");
        Entreprise edittedEntreprise =new Entreprise("vermeg","informatique");
        logger.info("Mock findById in entrepriserepository");
        Mockito.when(entrepriseRepository.findById(id)).thenReturn(java.util.Optional.of(edittedEntreprise));
        try {
            logger.debug("testing editEntrepriseNameById method");
            Entreprise updatedEntreprise = underTest.editEntrepriseNameById("vermeg",1);
            assertThat(updatedEntreprise.getName()).isEqualTo("vermeg");
            logger.info("Out editEntrepriseNameById with success");
        }catch (Exception e){
            logger.error("Error in editEntrepriseNameById causedBy"+e.getMessage());
        }
    }
}