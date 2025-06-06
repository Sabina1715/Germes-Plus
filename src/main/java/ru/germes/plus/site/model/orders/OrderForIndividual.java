package ru.germes.plus.site.model.orders;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.germes.plus.site.enums.OrderStatus;
import ru.germes.plus.site.model.PointOfSale;
import ru.germes.plus.site.model.ShippingInformation;
import ru.germes.plus.site.model.persons.IndividualPerson;
import ru.germes.plus.site.model.persons.LegalPerson;
import ru.germes.plus.site.model.products.ProductForIndividual;
import ru.germes.plus.site.model.summaries.SummaryForIndividual;
import ru.germes.plus.site.model.summaries.SummaryForLegal;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class OrderForIndividual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private IndividualPerson individualPerson;

    @ManyToOne
    @JoinColumn(name = "point_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PointOfSale pointOfSale;

    @ManyToOne
    @JoinColumn(name = "shipping_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ShippingInformation shippingInformation;

    @ElementCollection
    @CollectionTable(name = "orderForIndividualProduct", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "products")
    private List<ProductForIndividual> products;


    private Integer price;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
