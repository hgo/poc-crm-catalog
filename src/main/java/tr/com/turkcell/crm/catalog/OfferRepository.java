package tr.com.turkcell.crm.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface OfferRepository extends JpaRepository<Offer,String> {

    @Query("select o from Offer o join fetch o.offerProperties")
    Set<Offer> getOffers();

}
