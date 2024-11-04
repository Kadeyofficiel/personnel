package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import personnel.*;

class testLigue 
{
	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test
	void createLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}

	@Test
	void addEmploye() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"); 
		assertEquals(employe, ligue.getEmployes().first());
	}
}

// Les ajouts // 


	@Test
	void getNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		assertEquals("Fléchettes", ligue.getNom());
	}
	
	@Test
	void setNom() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		ligue.setNom("Billard");
		assertEquals("Billard", ligue.getNom());
	}
	
	@Test
	void getAdministrateur() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
		Employe employe = ligue.addEmploye("Bouchard", "Gerard", "g.bouchard@gmail.com", "azerty"); 
		ligue.setAdministrateur(employe);
		assertEquals("root", employe.getNom());
	}


	//Nouveaux ajouts 04/11 !!

	@Test 
	void setAdmin()
	{
		Ligue ligue = new Ligue("Fléchettes");
		Employe admin = ligue.addEmploye("test", "test", "mail@gmail.com", "asert"); 
		ligue.setAdministrateur(admin);
		assertEquals(admin, ligue.getAdministrateur());
	}

	@Test
	void getLigue() throws SauvegardeImpossible
	{
		Ligue ligue = gestionPersonnel.addLigue("Fléchettes");
	
	}


	//test pour date null
	  @Test
    void testDateArriveNull() throws SauvegardeImpossible{
    	Ligue ligue = gestionPersonnel.addLigue("Football");
    	
    
     Exception exception1 = assertThrows(Erreurdate.class, () -> {
            ligue.addEmploye("Bouchard", "Gérard", "g.bouchard@gmail.com", "azerty"  , null , LocalDate.of(2023, 1, 1));
        });
        assertEquals("La date de départ ne peut pas être avant la date d'arrivée.", exception1.getMessage());
        
     }