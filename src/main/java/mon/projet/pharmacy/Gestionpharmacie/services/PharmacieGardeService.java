package mon.projet.pharmacy.Gestionpharmacie.services;

import mon.projet.pharmacy.Gestionpharmacie.entities.Pharmacie;
import mon.projet.pharmacy.Gestionpharmacie.entities.PharmacieGarde;
import mon.projet.pharmacy.Gestionpharmacie.repository.GardeRepository;
import mon.projet.pharmacy.Gestionpharmacie.repository.PharmacieGardeRepositry;
import mon.projet.pharmacy.Gestionpharmacie.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacieGardeService {

    @Autowired
    PharmacieGardeRepositry pharmaciegardeRepositry;
    @Autowired
    PharmacieRepository pharmacieRepository;
    @Autowired
    GardeRepository gardeRepository;

    public List<Pharmacie> getGardes(){
        List<Pharmacie> listPharmacie = new ArrayList<>();
        for (PharmacieGarde pg:pharmaciegardeRepositry.findAll()){
            if (pg.getDateFin() == null){
                listPharmacie.add(pg.getPharmacie());
            }
        }
        return listPharmacie;
    }

    public List<PharmacieGarde> getAll() { return pharmaciegardeRepositry.findAll();}

    public void addGarde(PharmacieGarde pharmacieGarde){
         pharmaciegardeRepositry.save(pharmacieGarde);
    }
}
