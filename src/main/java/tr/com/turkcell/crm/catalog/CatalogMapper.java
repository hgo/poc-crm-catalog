package tr.com.turkcell.crm.catalog;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogMapper
{

    tr.com.turkcell.crm.ws.catalog.Offer mapOffer(Offer offer);


    List<tr.com.turkcell.crm.ws.catalog.Offer> mapOffers(Iterable<Offer> offers);
}
