package group54.managementeteries.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Antiprosopos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String onomateponimo;

    @Column
    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
