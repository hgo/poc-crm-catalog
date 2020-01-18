package tr.com.turkcell.crm.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import tr.com.turkcell.crm.ws.catalog.ListOffersRequest;
import tr.com.turkcell.crm.ws.catalog.ListOffersResponse;

import java.util.List;

@Endpoint
public class OfferEndpoint
{

    private static final String NAMESPACE_URI = "http://ws.crm.turkcell.com.tr/catalog";

    private final CatalogService catalogService;
    private final CatalogMapper catalogMapper;

    @Autowired
    public OfferEndpoint(CatalogService catalogService, CatalogMapper catalogMapper)
    {
        this.catalogService = catalogService;
        this.catalogMapper = catalogMapper;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listOffersRequest")
    @ResponsePayload
    public ListOffersResponse listCustomers(@RequestPayload ListOffersRequest request)
    {
        ListOffersResponse response = new ListOffersResponse();

        final Iterable<Offer> offers = catalogService.getOffers();

        List<tr.com.turkcell.crm.ws.catalog.Offer> responseOffers = catalogMapper.mapOffers(offers);
        response.getOffers().addAll(responseOffers);

        return response;
    }

}
