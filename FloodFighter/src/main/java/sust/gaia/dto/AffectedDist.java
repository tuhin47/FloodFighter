/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.gaia.dto;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;

/**
 *
 * @author Joker
 */
@Entity
public class AffectedDist {
    
   

    @Id
    private String distName;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "Affected_Thana")
    private Collection<Thana> affectedThana = new ArrayList<Thana>();

    public AffectedDist() {
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    public Collection<Thana> getAffectedThana() {
        return affectedThana;
    }

    public void setAffectedThana(Collection<Thana> affectedThana) {
        this.affectedThana = affectedThana;
    }
    

}
