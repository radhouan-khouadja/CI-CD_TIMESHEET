package tn.spring.timesheet.entities;

public class EntrepriseDTO {
    private int id;
    private String name;
    private String raisonSocial;

    public EntrepriseDTO(){
        super();
    }
    public EntrepriseDTO(String name,String raisonSocial){
        this.name = name;
        this.raisonSocial = raisonSocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }
}
