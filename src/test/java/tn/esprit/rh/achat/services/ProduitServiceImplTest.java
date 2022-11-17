	package tn.esprit.rh.achat.services;
	
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;
	
	import lombok.extern.slf4j.Slf4j;
	//import org.junit.Test;
	import org.junit.jupiter.api.Test;
	import tn.esprit.rh.achat.entities.Produit;
	import tn.esprit.rh.achat.repositories.ProduitRepository;
	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertNotNull;
	
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;

	import java.util.Date;
	import java.util.Optional;
	import java.util.stream.Collectors;
	import java.util.stream.Stream;
	
	@Slf4j
	@ExtendWith(MockitoExtension.class)
	public class ProduitServiceImplTest {
	
//Ahmed Ben Ezzine
		
		@Mock
		ProduitRepository produitRepository;
	
		@InjectMocks
		ProduitServiceImpl produitService;
		
		
	    private Produit produit1 = new Produit(21L,"v21","voiture", 250000, new Date(),new Date(),null,null,null);
	    private Produit produit2 = new Produit(29L,"v29","voiture", 250000, new Date(),new Date(),null,null,null);
	
	   
	    @Test
	    public void MockAddProduit() {
	        when(produitRepository.save(produit1)).thenReturn(produit1);
	        assertNotNull(produit1);
	        assertEquals(produit1, produitService.addProduit(produit1));
	        log.info("add works successfully");
	    }
	    @Test
	    public void TestRetrieveAllProduits() {
	        when(produitRepository.findAll()).thenReturn(Stream
	                .of(produit1,produit2)
	                .collect(Collectors.toList()));
	        assertEquals(2,produitService.retrieveAllProduits().size());
	        log.info("Retrieve produits works successfully");
	    }
	    @Test
	    public void TestDeleteProduit() {
	        produitRepository.save(produit1);
	        produitService.deleteProduit(produit1.getIdProduit());
	        verify(produitRepository, times(1)).deleteById(produit1.getIdProduit());
	        log.info("Delete works successfully");
	    }
	    @Test
	    public void TestUpdateProduit() {
	        when(produitRepository.save(produit1)).thenReturn(produit1);
	        assertNotNull(produit1);
	        assertEquals(produit1, produitService.updateProduit(produit1));
	        log.info("Update works successfully");
	    }
	    @Test
	    public void TestRetrieveProduit() {
	        when(produitRepository.findById(produit1.getIdProduit())).thenReturn(Optional.of(produit1));
	        assertEquals(produit1, produitService.retrieveProduit(produit1.getIdProduit()));
	        log.info("Retrieve works successfully");
	    }
		
	}
