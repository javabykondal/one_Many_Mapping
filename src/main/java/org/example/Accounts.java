package org.example;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Accounts {
@Id
@Column(name = "acid")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int aid;

    @Column(name = "actype") private  String ac;

    @Column(name = "acemail")private String acemail;

    @Column(name = "acstate")private String acstate;
    @JoinColumn(name = "aidss",referencedColumnName = "cid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Accounts() {
    }

    public Accounts(String ac, String acemail, String acstate) {
        this.ac = ac;
        this.acemail = acemail;
        this.acstate = acstate;
    }

    public Accounts(int aid, String ac, String acemail, String acstate) {
        this.aid = aid;
        this.ac = ac;
        this.acemail = acemail;
        this.acstate = acstate;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getAcemail() {
        return acemail;
    }

    public void setAcemail(String acemail) {
        this.acemail = acemail;
    }

    public String getAcstate() {
        return acstate;
    }

    public void setAcstate(String acstate) {
        this.acstate = acstate;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "aid=" + aid +
                ", ac='" + ac + '\'' +
                ", acemail='" + acemail + '\'' +
                ", acstate='" + acstate + '\'' +
                ", customer=" + customer +
                '}';
    }
}
