package homeCompany.homeProdactions;

import homeCompany.homeProdactions.Pets.Pet;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ClinicTest {
    public  Clinic clinic = new Clinic();

    @Before
    public void setup() throws Exception {
        clinic = new Clinic();
        clinic.addClient("client1");
        clinic.addClient("client2");
        clinic.getClientByName("client1").addPetToClient(1, "cat1");
        clinic.getClientByName("client1").addPetToClient(2, "dog1");
        clinic.getClientByName("client2").addPetToClient(1,"cot1");

    }

    @Test()
    public void testHasClient() throws Exception {
        Assert.assertEquals(false, clinic.hasClient("client3"));
    }

    @Test()
    public void testGetClientByName() throws Exception {
        Assert.assertNotNull(clinic.getClientByName("client1"));
    }

    @Test()
    public void testChangeClientName() throws Exception {
        Client c = clinic.getClientByName("client1");
        clinic.changeClientName(c, "newName");
        Assert.assertEquals("newName",c.getName());
    }

    @Test()
    public void testChangePetName() throws Exception {
        Pet p = clinic.getClientByName("client2").getPetByName("cot1");
        clinic.changePetName(p,"cot11");
        Assert.assertEquals("cot11",p.getName());
    }

    @Test()
    public void testAddClient() throws Exception {
        clinic.addClient("newClient");
        Assert.assertEquals(true,clinic.hasClient("newClient"));
    }
    @Test(expected = Exception.class)
    public void testRemoveClient() throws Exception {
        clinic.addClient("removedClient");
        Assert.assertNotNull(clinic.getClientByName("removedClient"));
        clinic.removeClient("removedClient");
        Assert.assertNull(clinic.getClientByName("removedClient"));

    }

}