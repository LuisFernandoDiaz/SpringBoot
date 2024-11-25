package pe.edu.i202222219.cl1_jpa_data_diaz_luis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "country")
public class Country {

    @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private Double SurfaceArea;
    private Integer IndepYear;
    private String Population;
    private Double LifeExpectancy;
    private Double GNP;
    private Double GNPOld;
    private String LocalName;
    private String GovernmentForm;
    private String HeadOfState;
    private Integer Capital;
    private String code2;

//    @OneToMany(mappedBy = "country")
//    private List<City> city;
//
//    @OneToMany(mappedBy = "country")
//    private List<Countrylanguage> countrylanguages;

}
