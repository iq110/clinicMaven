package homeCompany.homeProdactions.Exceptions;

/**
 * If clinic already has client client whit his name
 */
public class AddExcisingNameException extends Exception {
    public AddExcisingNameException(){
        super("This Name Already Used");
    }
}

