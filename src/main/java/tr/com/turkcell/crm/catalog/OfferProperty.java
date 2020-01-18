package tr.com.turkcell.crm.catalog;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class OfferProperty {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    private String name;
    private String value;

    @ManyToOne(optional = false)
    @JoinColumn(name = "offer_id")
    private Offer offer;

}
