public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Товара " + id + " не существет");
    }
}
