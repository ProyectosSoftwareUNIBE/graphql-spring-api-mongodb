package programacion.nube.graphql.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import programacion.nube.graphql.data.ProductoDocument;
import programacion.nube.graphql.dtos.ProductDto;
import programacion.nube.graphql.services.ProductoService;

import java.util.List;

@Controller
public class ProductoQuery implements GraphQLQueryResolver {

    private ProductoService productoService;

    @Autowired
    public ProductoQuery(ProductoService productoService) {
        this.productoService = productoService;
    }

    public List<ProductoDocument> productos() {
        return this.productoService.getAllProducts();
    }

    public ProductDto getPrecio(String id, double descuento) {
        ProductoDocument productoDocument = this.productoService.getProductById(id);
        ProductDto productDto = new ProductDto();
        productDto.setNombre(productoDocument.getNombre());
        productDto.setCodigo(productoDocument.getCodigo());
        productDto.setPrecio(productoDocument.getPrecio());
        productDto.setIva(productoDocument.getPrecio() * 0.12);
        productDto.setDescuento(productoDocument.getPrecio() * descuento);
        double total = productDto.getPrecio() + productDto.getIva() - productDto.getDescuento();
        productDto.setPrecioFinal(total);
        return productDto;
    }
}
