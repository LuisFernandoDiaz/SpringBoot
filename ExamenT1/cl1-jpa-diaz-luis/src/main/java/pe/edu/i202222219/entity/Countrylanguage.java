package pe.edu.i202222219.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "countrylanguage")
public class Countrylanguage {


    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String CountryCode;
    private String Language;
    private String IsOfficial;
    private Double Percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;



    public Countrylanguage(){
    }

    public Countrylanguage(String countryCode, String language, String isOfficial, Double percentage, Country country) {
        CountryCode = countryCode;
        Language = language;
        IsOfficial = isOfficial;
        Percentage = percentage;
        this.country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        IsOfficial = isOfficial;
    }

    public Double getPercentage() {
        return Percentage;
    }

    public void setPercentage(Double percentage) {
        Percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
