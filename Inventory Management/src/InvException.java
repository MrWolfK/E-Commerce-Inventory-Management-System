public class InvException extends Exception {

    public InvException() {

        super("Inventory Error");
    }

    public InvException(
            String message) {

        super(message);
    }
}