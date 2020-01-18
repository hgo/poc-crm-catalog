package tr.com.turkcell.crm.catalog;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Offer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offer")
    private List<OfferProperty> offerProperties = new ArrayList<>();
}
