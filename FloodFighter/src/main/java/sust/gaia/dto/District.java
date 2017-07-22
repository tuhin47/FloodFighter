/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.gaia.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import sust.gia.controller.BasicControl;

/**
 *
 * @author Joker
 */
@Entity
public class District {

    public static void main(String[] args) {
        for (int i = 0; i < 64; i++) {
            District d = new District("A" + i, 05, 05);
            d.getThana().add(new ThanaDetails("B" + i, 50));
            d.getThana().add(new ThanaDetails("c" + i, 50));

            new BasicControl().insert(d);
        }
    }

    @Id
    private String distName;
    private long population;
    private long area;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "Thana_List")
    private List<ThanaDetails> thana = new ArrayList();

    public District(String distName, long population, long area) {
        this.distName = distName;
        this.population = population;
        this.area = area;
    }

    public District() {
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public List<ThanaDetails> getThana() {
        return thana;
    }

    public void setThana(List<ThanaDetails> thana) {
        this.thana = thana;
    }

}
