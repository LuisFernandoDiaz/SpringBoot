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
@Table(name = "city")
public class City {

    @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Name;
    private String CountryCode;
    private String District;
    private Integer Population;
//
//    @ManyToOne
//    @JoinColumn(name = "CountryCode")
//    private Country country;


}
