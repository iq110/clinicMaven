package homeCompany.homeProdactions;

import homeCompany.homeProdactions.Exceptions.*;
import homeCompany.homeProdactions.Pets.Pet;

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


    public Client getClientByName(String clientName) throws UserException {
        if (hasClient(clientName)) {
            for (Client c : clients) {
                if (c.getName().equals(clientName))
                    return c;
            }
        }
        throw new UserException("You Have No Client With This Name!!!");
    }


    public boolean changeClientName(Client client, String newName) throws AddExcisingNameException, UserException {
        if (!client.equals(null)) {
            if (!hasClient(newName)) {
                client.setName(newName);
                return true;
            } else throw new AddExcisingNameException();
        }
        throw new UserException("Client Not Selected!!!");
    }
    public boolean changePetName(Pet pet, String newName) {
        pet.setName(newName);
        return true;
    }

    public Client addClient(String clientName) throws AddExcisingNameException {
        if (!hasClient(clientName)) {
            Client newClient = new Client(clientName);
            this.clients.add(newClient);
            return newClient;
        }
        throw new AddExcisingNameException();
    }
    public boolean removeClient(String clientName) throws NoPetsWithThisNameException {
        for (Client c : clients)
            if (c.getName().equals(clientName)) {
                c.removeAllPets();
                clients.remove(c);
                System.out.println(clientName + " Was Removed!");
                return true;
            }
        throw new NoPetsWithThisNameException();
    }


    public void printClientsByPetName(String petName) throws NoPetsWithThisNameException, NoClientsExceptions {
        if (this.clients.isEmpty())
            throw new NoClientsExceptions();

        int countOfPrints = 0;//if function will print no one client
        // it will say to user about this
        for (Client c : this.clients) {
            if (c.hasPet(petName)) {
                System.out.println(c.getName());
                countOfPrints++;
            }
        }
        if (countOfPrints == 0)
            throw new NoPetsWithThisNameException();
    }
    public void printClientsAndThemPets() throws NoClientsExceptions, ClientHasNoPetsException {
        if (this.clients.isEmpty())
            throw new NoClientsExceptions();
        for (Client c : clients) {
            System.out.println(c.getName());
            c.printPets();
        }
    }

}
