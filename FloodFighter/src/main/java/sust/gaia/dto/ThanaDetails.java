/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.gaia.dto;

import javax.persistence.Embeddable;

/**
 *
 * @author Joker
 */
@Embeddable
public class ThanaDetails {

  
    private String thana_name;
    private long population;

    public ThanaDetails(String thana_name, long population) {
        this.thana_name = thana_name;
        this.population = population;
    }

    public ThanaDetails() {
    }

    public String getThana_name() {
        return thana_name;
    }

    public void setThana_name(String thana_name) {
        this.thana_name = thana_name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

}
