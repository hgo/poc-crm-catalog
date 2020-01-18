package tr.com.turkcell.crm.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class DataSupplier
{

    private final OfferRepository offerRepository;
    private final OfferPropertyRepository offerPropertyRepository;

    @Autowired
    public DataSupplier(OfferRepository offerRepository, OfferPropertyRepository offerPropertyRepository) {
        this.offerRepository = offerRepository;
        this.offerPropertyRepository = offerPropertyRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event)
    {

        if (offerRepository.count() == 0)
        {
            Offer offer = new Offer();
            offer.setName("Fiber12MB");
            offerRepository.save(offer);

            OfferProperty bandwithProperty = new OfferProperty();
            bandwithProperty.setName("Tell_FiberBandwidth");
            bandwithProperty.setValue("128");
            bandwithProperty.setOffer(offer);
            offerPropertyRepository.save(bandwithProperty);

            OfferProperty uavtProperty = new OfferProperty();
            uavtProperty.setName("Tell_UAVT");
            uavtProperty.setValue("1235295894");
            uavtProperty.setOffer(offer);
            offerPropertyRepository.save(uavtProperty);

        }

    }
}
