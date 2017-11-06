package org.tran.poc.poc.dao;

import javax.persistence.*;

@Entity
@Table(name = "tran_action")

public class TransAudit {

  /*  @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;*/

    @Id
    @Column(name = "Tran_From")
    private String from;

    @Column(name = "Tran_To")
    private String to;

    @Column(name = "Tran_Amount")
    private int amount;

    @Column(name = "Tran_When")
    private String when;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

 /*   public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }*/

    public String getTo() {
        return to;

    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }


}
