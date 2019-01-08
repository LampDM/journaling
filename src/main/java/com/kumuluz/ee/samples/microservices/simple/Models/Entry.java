package com.kumuluz.ee.samples.microservices.simple.Models;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "journal")
//@NamedQuery(name = "journal.findAll", query = "SELECT e FROM Entry e")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String entryJSON;

    @Temporal(TemporalType.TIMESTAMP)
    private Date entryDate;

    private String entryService;

    private Integer entryInstance_Id;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntryJSON() {
        return entryJSON;
    }

    public void setEntryJSON(String entryJSON) {
        this.entryJSON = entryJSON;
    }

    public Date getEntryDate(){return entryDate;}

    public void setEntryDate(Date entryDate){this.entryDate=entryDate;}

    public String getEntryService(){return entryService;}

    public void setEntryService(String entryService){this.entryService=entryService;}

    public Integer getEntryInstance_Id() {
        return entryInstance_Id;
    }

    public void setEntryInstance_Id(Integer entryInstance_Id) {
        this.entryInstance_Id = entryInstance_Id;
    }
}
