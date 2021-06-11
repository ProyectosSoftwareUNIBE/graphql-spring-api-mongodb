package programacion.nube.graphql.graphql;


import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import programacion.nube.graphql.data.ProductDocument;
import programacion.nube.graphql.services.ProductService;

@Controller
public class ProductMutation implements GraphQLMutationResolver {

    private ProductService productService;

    @Autowired
    public ProductMutation(ProductService productService) {
        this.productService = productService;
    }

    public ProductDocument createProduct(ProductDocument productDocument) {
        return this.productService.createProduct(productDocument);
    }

    public ProductDocument updateProduct(String id, ProductDocument productDocument) {
        return this.productService.updateProductByID(id, productDocument);
    }

    public ProductDocument deleteProduct(String id) {
        return this.productService.deleteProductById(id);
    }
}
