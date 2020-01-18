package tr.com.turkcell.crm.catalog;

import org.springframework.stereotype.Service;

@Service
public class CatalogService
{
    private final OfferRepository offerRepository;

    public CatalogService(OfferRepository offerRepository)
    {
        this.offerRepository = offerRepository;
    }

    public Iterable<Offer> getOffers()
    {
        return offerRepository.getOffers();
    }
}
