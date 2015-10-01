package homeCompany.homeProdactions;

import homeCompany.homeProdactions.Pets.Pet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class clinic
 */
public class Clinic {

    //List of clients
    private ArrayList<Client> clients = new ArrayList<Client>();

    /**
     * Has clinic client with concrete name
     *
     * @param clientName
     * @return
     */
    public boolean hasClient(String clientName) {
        for (Client c : clients) {
            if (c.getName().equals(clientName))
                return true;
        }
        return false;
    }


    public Client getClientByName(String clientName) {
        if (hasClient(clientName)) {
            for (Client c : clients) {
                if (c.getName().equals(clientName))
                    return c;
            }
        }
        System.out.println("You Have No Client With This Name!!!");
        return null;
    }


    public boolean changeClientName(Client client, String newName) {
        if (!client.equals(null)) {
            if (!hasClient(newName)) {
                client.setName(newName);
                return true;
            } else {
                System.out.println("This Name Already Used");
                return false;
            }
        }
        System.out.println("Client Not Selected!!!");
        return false;
    }
    public boolean changePetName(Pet pet, String newName) {
        pet.setName(newName);
        return true;
    }

    public Client addClient(String clientName) {
        if (!hasClient(clientName)) {
            Client newClient = new Client(clientName);
            this.clients.add(newClient);
            return newClient;
        }
        System.out.println("This Client Already Exist!");
        return null;
    }
    public boolean removeClient(String clientName) {
        for (Client c : clients)
            if (c.getName().equals(clientName)) {
                c.removeAllPets();
                clients.remove(c);
                System.out.println(clientName + " Was Removed!");
                return true;
            }
        System.out.println("You Have No Pets With This Name!!");
        return false;
    }


    public void printClientsByPetName(String petName) {
        int countOfPrints = 0;//if function will print no one client
        // it will say to user about this
        for (Client c : this.clients) {
            if (c.hasPet(petName)) {
                System.out.println(c.getName());
                countOfPrints++;
            }
        }
        if (countOfPrints == 0)
            System.out.println("You Have No Pets With This Name!!");
    }
    public void printClientsAndThemPets() {
        if (this.clients.isEmpty())
            System.out.println("You Have No Clients!");
        for (Client c : clients) {
            System.out.println(c.getName());
            c.printPets();
        }
    }

}
