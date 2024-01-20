package org.example;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid") private  int cid;
    @Column(name = "cname")private String  cname;
    @Column(name = "cemail")private String email;
    @Column(name = "phone")private int phone;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set<Accounts> accountsSet;

    public Set<Accounts> getAccountsSet() {
        return accountsSet;
    }

    public void setAccountsSet(Set<Accounts> accountsSet) {
        this.accountsSet = accountsSet;
    }

    public Customer() {
    }

    public Customer(String cname, String email, int phone) {
        this.cname = cname;
        this.email = email;
        this.phone = phone;
    }

    public Customer(int cid, String cname, String email, int phone) {
        this.cid = cid;
        this.cname = cname;
        this.email = email;
        this.phone = phone;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
