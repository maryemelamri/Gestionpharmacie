package mon.projet.pharmacy.Gestionpharmacie.services;

import mon.projet.pharmacy.Gestionpharmacie.entities.Ville;
import mon.projet.pharmacy.Gestionpharmacie.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public  class VilleService {
    @Autowired
    private VilleRepository villeRepository;
    public void save( Ville ville){
        villeRepository.save(ville);
    }

    public List<Ville> findAll(){
        return villeRepository.findAll();
    }

    //public List <Ville> getAllVilles(){return  villeRepository.findAll();};
    public Ville findByNom(String nom) {
        return villeRepository.findByNom(nom);
    }

    public Ville findById(int id) {
        return villeRepository.findById(id);
    }
    public void delete(int id ){
        villeRepository.delete(villeRepository.findById(id));
    }

    public Ville getVilleById(int id) {
        Ville  ville = villeRepository.findById(id);
        
        return ville;
    }
    public List<Ville> getAllVilles() {
        // Code pour récupérer toutes les villes de votre source de données (par exemple, une base de données)
        List<Ville> villes = villeRepository.findAll();

        return villes;
    }

}
