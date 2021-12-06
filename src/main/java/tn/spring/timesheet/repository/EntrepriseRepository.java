package tn.spring.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.spring.timesheet.entities.Entreprise;
import java.util.List;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

    @Query(value="SELECT count(*) FROM entreprise",nativeQuery = true)
    public int countEntreprise();

    @Query("SELECT DISTINCT u.name FROM Entreprise u")
    public List<String> getAllNamesOfEntreprise();

    @Query("SELECT u FROM Entreprise u WHERE u.raisonSocial = ?1")
    public List<Entreprise> getAllEntrepriseByRaisonSocial(String raisonsOCIAL);

    @Modifying(clearAutomatically = true)
    @Query("update Entreprise u set  u.name = :name where u.id = :id")
    public void editEntrepriseName(@Param("name")String name, @Param("id")  int id);
}
