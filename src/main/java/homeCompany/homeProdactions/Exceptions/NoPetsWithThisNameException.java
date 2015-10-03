package homeCompany.homeProdactions.Exceptions;

/**
 * Client or has no pets with this name
 * clinic hasn't client with pets which has this name
 */
public class NoPetsWithThisNameException extends Exception {
    public NoPetsWithThisNameException(){
        super("You Have No Pets With This Name!!");
    }
}
