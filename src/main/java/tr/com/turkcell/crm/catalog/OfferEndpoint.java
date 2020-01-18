package tr.com.turkcell.crm.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import tr.com.turkcell.crm.ws.catalog.ListOffersRequest;
import tr.com.turkcell.crm.ws.catalog.ListOffersResponse;

@Endpoint
public class OfferEndpoint {

    private static final String NAMESPACE_URI = "http://ws.crm.turkcell.com.tr/catalog";

    private OfferRepository offerRepository;

    @Autowired
    public OfferEndpoint(OfferRepository offerRepository)
    {
        this.offerRepository = offerRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listOffersRequest")
    @ResponsePayload
    public ListOffersResponse listCustomers(@RequestPayload ListOffersRequest request)
    {
        ListOffersResponse response = new ListOffersResponse();
        for (Offer _offer : offerRepository.getOffers())
        {
            tr.com.turkcell.crm.ws.catalog.Offer wsOffer = new tr.com.turkcell.crm.ws.catalog.Offer();

            for(OfferProperty _offerProperty : _offer.getOfferProperties())
            {
                tr.com.turkcell.crm.ws.catalog.OfferProperty wsOfferProperty = new tr.com.turkcell.crm.ws.catalog.OfferProperty();

                wsOfferProperty.setId(_offerProperty.getId());
                wsOfferProperty.setName(_offerProperty.getName());
                wsOfferProperty.setValue(_offerProperty.getValue());

                wsOffer.getOfferProperties().add(wsOfferProperty);
            }

            wsOffer.setId(_offer.getId());
            wsOffer.setName(_offer.getName());

            response.getOffers().add(wsOffer);
        }
        return response;
    }

}
