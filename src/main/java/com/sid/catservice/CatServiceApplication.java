package com.sid.catservice;

import com.sid.catservice.dao.ProduitRepository;
import com.sid.catservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {

    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(CatServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Produit.class);
        produitRepository.save(new Produit(null,"ordinateur",6700,3));
        produitRepository.save(new Produit(null,"hp compact",200,15));
        produitRepository.save(new Produit(null,"produit3",300,5));

        produitRepository.findAll().forEach(p->{

            System.out.println(p.toString());
        });

    }
}
