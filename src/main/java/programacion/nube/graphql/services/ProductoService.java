package programacion.nube.graphql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion.nube.graphql.data.ProductoDocument;
import programacion.nube.graphql.data.ProductoRepository;

import java.util.List;
import java.util.Optional;

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
}
