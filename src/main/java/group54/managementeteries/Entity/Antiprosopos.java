package group54.managementeteries.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Antiprosopos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String onomateponimo;



    public void setAitiseis(List<aitisi> aitiseis) {
        this.aitiseis = aitiseis;
    }

    public List<aitisi> getAitiseis() {
        return aitiseis;
    }



    @OneToMany(mappedBy="antiprosopos", cascade = CascadeType.ALL)
    private List<aitisi> aitiseis;

    public Antiprosopos(String onomateponimo) {
        this.onomateponimo = onomateponimo;
    }

    public Antiprosopos() {
    }
}
