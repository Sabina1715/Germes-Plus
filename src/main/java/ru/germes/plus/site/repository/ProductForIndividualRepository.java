package ru.germes.plus.site.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.germes.plus.site.model.products.ProductForIndividual;

@Repository
public interface ProductForIndividualRepository extends JpaRepository<ProductForIndividual, Long> {
}
