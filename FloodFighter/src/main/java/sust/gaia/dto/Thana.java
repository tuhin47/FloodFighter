package sust.gaia.dto;

import javax.persistence.Embeddable;

/**
 *
 * @author Joker
 */
@Embeddable
public class Thana {

    private String thana_name;
    private boolean affected;
    private double cumulative;
    private double ratio;

    public Thana() {
    }

    public Thana(String thana_name, double cumulative, double ratio) {
        this.thana_name = thana_name;
        
        this.cumulative = cumulative;
        this.ratio = ratio;
    }

    public String getThana_name() {
        return thana_name;
    }

    public void setThana_name(String thana_name) {
        this.thana_name = thana_name;
    }

    public boolean isAffected() {
        return affected;
    }

    public void setAffected(boolean affected) {
        this.affected = affected;
    }


    public double getCumulative() {
        return cumulative;
    }

    public void setCumulative(double cumulative) {
        this.cumulative = cumulative;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

}
