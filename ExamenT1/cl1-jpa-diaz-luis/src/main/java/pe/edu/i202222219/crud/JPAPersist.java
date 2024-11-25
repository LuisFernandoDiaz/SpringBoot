package pe.edu.i202222219.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202222219.entity.Country;

import java.util.Date;

public class JPAPersist {

    public static void main(String[] args) {

        // referenciar al em
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // crear un libro
        Country country = new Country("ZZZ", "Zzzzz", "Zzzzz", "Zzzz", 100.34, 1.11, 11.00, 77, 111, "Zzzzz", "Zzzzz", "Zzzzz", 11, "ZZ" );

        // presistir el libro
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

    }

}