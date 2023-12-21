package group54.managementeteries.payload;

public class AitisiRequest {
    private String companyname;
    private String katastatiko;
    private String edra;

    private String partner1;
    private String partner2;


    public AitisiRequest(String companyname, String katastatiko, String edra, String partner1, String partner2) {
        this.companyname = companyname;
        this.katastatiko = katastatiko;
        this.edra = edra;
        this.partner1 = partner1;
        this.partner2 = partner2;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getKatastatiko() {
        return katastatiko;
    }

    public void setKatastatiko(String katastatiko) {
        this.katastatiko = katastatiko;
    }

    public String getEdra() {
        return edra;
    }

    public void setEdra(String edra) {
        this.edra = edra;
    }

    public String getPartner1() {
        return partner1;
    }

    public void setPartner1(String partner1) {
        this.partner1 = partner1;
    }

    public String getPartner2() {
        return partner2;
    }

    public void setPartner2(String partner2) {
        this.partner2 = partner2;
    }
}
