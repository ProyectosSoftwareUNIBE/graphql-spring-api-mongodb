package programacion.nube.graphql.data;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<ProductoDocument,String> {
}
