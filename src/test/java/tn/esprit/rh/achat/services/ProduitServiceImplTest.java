package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

//Ahmed Ben Ezzine

@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplTest {
	@Mock
	ProduitRepository produitRepo;
	
	@InjectMocks
	ProduitServiceImpl produitService;
	
	@Test
	void ajoutProduit() {
		Produit p = new Produit();
		p.setCodeProduit("hello");
		Mockito.when(produitRepo.save(Mockito.any(Produit.class))).thenReturn(p);
		Produit result = produitService.addProduit(p);
		Assertions.assertNotNull(result);
	}
}
