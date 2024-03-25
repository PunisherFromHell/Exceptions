import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void ShouldCatchWhenNoItemToRemove() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "phone", 30_000);
        Product product2 = new Product(2, "book", 300);
        Product product3 = new Product(3, "car", 3_000_000);


        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4)
        );
    }

    @Test
    public void ShouldRemoveItem() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "phone", 30_000);
        Product product2 = new Product(2, "book", 300);
        Product product3 = new Product(3, "car", 3_000_000);


        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);

        Product[] actual = repo.findAll();
        Product[] excepted = {product1, product3};

        Assertions.assertArrayEquals(excepted, actual);
    }
}
