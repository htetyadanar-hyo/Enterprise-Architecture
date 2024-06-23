package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EmailSender emailSender;
    @Override
    public void addNewProduct(String name,double quantity, double price,String email){
        Product product = new Product(name,quantity,price,email);
        productRepository.save(product);
        emailSender.sendEmail(email, "Adding a new product: " + name + ", Quantity: " + quantity + " and price is $" + price );
    }
}
