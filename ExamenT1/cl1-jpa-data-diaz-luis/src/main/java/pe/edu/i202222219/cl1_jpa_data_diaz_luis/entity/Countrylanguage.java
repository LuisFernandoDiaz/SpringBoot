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
@Table(name = "countrylanguage")
public class Countrylanguage {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String CountryCode;
    private String Language;
    private String IsOfficial;
    private Double Percentage;

//    @ManyToOne
//    @JoinColumn(name = "CountryCode")
//    private Country country;


}
