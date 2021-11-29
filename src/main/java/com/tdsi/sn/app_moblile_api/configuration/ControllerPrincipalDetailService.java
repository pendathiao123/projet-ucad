package com.tdsi.sn.app_moblile_api.configuration;


public class ControllerPrincipalDetailService implements UserDetailsService {
    private ControllerRepository controllerRepository;

    public ControllerPrincipalDetailService(ControllerRepository controllerRepository){
        this.controllerRepository = controllerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Controlleur controlleur = this.controllerRepository.findByPrenom(s);
        ControllerPrincipal controllerPrincipal = new ControllerPrincipal(controlleur);
        return controllerPrincipal;
    }
}
