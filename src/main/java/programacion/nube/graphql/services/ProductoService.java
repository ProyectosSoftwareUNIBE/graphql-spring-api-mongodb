package programacion.nube.graphql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion.nube.graphql.data.ProductoDocument;
import programacion.nube.graphql.data.ProductoRepository;
import programacion.nube.graphql.dtos.ProductDto;

import java.util.List;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDocument> getAllProducts() {
        return this.productoRepository.findAll();
    }

    public ProductoDocument getProductById(String id) {
        return this.productoRepository.findById(id).get();
    }

    public ProductDto getProductPrice(String id, double descuento){
        ProductoDocument productoDocument = this.getProductById(id);
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
