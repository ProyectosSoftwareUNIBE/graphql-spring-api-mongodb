package programacion.nube.graphql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion.nube.graphql.data.ProductDocument;
import programacion.nube.graphql.data.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDocument> getAllProducts() {
        return this.productRepository.findAll();
    }

    public ProductDocument createProduct(ProductDocument productDocument) {
        return this.productRepository.save(productDocument);
    }

    public ProductDocument getProductById(String id) {
        Optional<ProductDocument> productDocumentOptional = this.productRepository.findById(id);
        return productDocumentOptional.get();
    }

    public ProductDocument updateProductByID(String id, ProductDocument productDocument) {
        Optional<ProductDocument> productDocumentOptional = this.productRepository.findById(id);
        ProductDocument productDb = productDocumentOptional.get();
        productDb.setName(productDocument.getName());
        productDb.setCode(productDocument.getCode());
        productDb.setPrice(productDocument.getPrice());
        return this.productRepository.save(productDb);

    }

    public ProductDocument deleteProductById(String id) {
        Optional<ProductDocument> productDocumentOptional = this.productRepository.findById(id);
        ProductDocument productDb = productDocumentOptional.get();
        this.productRepository.deleteById(id);
        return productDb;
    }

}
