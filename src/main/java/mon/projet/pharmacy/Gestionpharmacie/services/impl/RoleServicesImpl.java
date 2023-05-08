package mon.projet.pharmacy.Gestionpharmacie.services.impl;

import mon.projet.pharmacy.Gestionpharmacie.entities.Role;
import mon.projet.pharmacy.Gestionpharmacie.repository.RoleRepository;
import mon.projet.pharmacy.Gestionpharmacie.services.facade.RoleServices;

import java.util.Collection;

public class RoleServicesImpl implements RoleServices {
    private RoleRepository roleRepository;

    public RoleServicesImpl(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }
    @Override
    public Role save(Role role) {
        Role loadedRole = roleRepository.findByAuthority(role.getAuthority());
        if(loadedRole == null){
            return roleRepository.save(role);
        }else{
            return loadedRole;
        }
    }

    @Override
    public void save(Collection<Role> roles) {
        if(roles!=null && !roles.isEmpty()){
            for (Role role :roles) {
                Role foundedRole = findByAuthority(role.getAuthority());
                if (foundedRole != null) {
                    role.setId(foundedRole.getId());
                }else{
                    roleRepository.save(role);
                }
            }
        }
    }

    @Override
    public Role findByAuthority(String authority) {
        return roleRepository.findByAuthority(authority);    }
}
