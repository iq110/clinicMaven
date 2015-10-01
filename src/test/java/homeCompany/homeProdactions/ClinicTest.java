package homeCompany.homeProdactions;

import homeCompany.homeProdactions.Pets.Pet;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ClinicTest extends TestCase {
    public  Clinic clinic = new Clinic();

    @Before
    public void setup() throws IOException {
        clinic = new Clinic();
        clinic.addClient("client1");
        clinic.addClient("client2");
        clinic.getClientByName("client1").addPetToClient(1, "cat1");
        clinic.getClientByName("client1").addPetToClient(2, "dog1");
        clinic.getClientByName("client2").addPetToClient(1,"cot1");

    }

    @Test()
    public void testHasClient() throws Exception {
        setup();
        Assert.assertEquals(false, clinic.hasClient("client3"));
    }

    @Test()
    public void testGetClientByName() throws Exception {
        setup();
        Assert.assertNotNull(clinic.getClientByName("client1"));
    }

    @Test()
    public void testChangeClientName() throws Exception {
        setup();
        Client c = clinic.getClientByName("client1");
        clinic.changeClientName(c, "newName");
        Assert.assertEquals("newName",c.getName());
    }

    @Test()
    public void testChangePetName() throws Exception {
        setup();
        Pet p = clinic.getClientByName("client2").getPetByName("cot1");
        clinic.changePetName(p,"cot11");
        Assert.assertEquals("cot11",p.getName());
    }

    @Test()
    public void testAddClient() throws Exception {
        setup();
        clinic.addClient("newClient");
        Assert.assertEquals(true,clinic.hasClient("newClient"));
    }
    @Test()
    public void testRemoveClient() throws Exception {
        setup();
        clinic.addClient("removedClient");
        Assert.assertNotNull(clinic.getClientByName("removedClient"));
        clinic.removeClient("removedClient");
        Assert.assertNull(clinic.getClientByName("removedClient"));

    }

}