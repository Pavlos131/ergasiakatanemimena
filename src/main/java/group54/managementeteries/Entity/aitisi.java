package group54.managementeteries.Entity;
import jakarta.persistence.*;
@Entity
public class aitisi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String companyname;
    @Column
    private String katastatiko;
    @Column
    private String edra;
    @Column
    private String partner1;
    @Column
    private String partner2;

    @Column
    private String condition;


    public aitisi(int id, String companyname, String katastatiko, String edra, String partner1, String partner2, String condition) {
        this.id = id;
        this.companyname = companyname;
        this.katastatiko = katastatiko;
        this.edra = edra;
        this.partner1 = partner1;
        this.partner2 = partner2;
        this.condition = condition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setKatastatiko(String katastatiko) {
        this.katastatiko = katastatiko;
    }

    public void setEdra(String edra) {
        this.edra = edra;
    }

    public void setPartner1(String partner1) {
        this.partner1 = partner1;
    }

    public void setPartner2(String partner2) {
        this.partner2 = partner2;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getId() {
        return id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getKatastatiko() {
        return katastatiko;
    }

    public String getEdra() {
        return edra;
    }

    public String getPartner1() {
        return partner1;
    }

    public String getPartner2() {
        return partner2;
    }

    public String getCondition() {
        return condition;
    }

}
