package programacion.nube.graphql.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import programacion.nube.graphql.data.ProductDocument;
import programacion.nube.graphql.services.ProductService;

import java.util.List;

@Controller
public class ProductQuery implements GraphQLQueryResolver {

    private ProductService productService;

    @Autowired
    public ProductQuery(ProductService productService) {
        this.productService = productService;
    }

    public List<ProductDocument> products() {
        return this.productService.getAllProducts();
    }

    public ProductDocument product(String id) {
        return this.productService.getProductById(id);
    }



}
