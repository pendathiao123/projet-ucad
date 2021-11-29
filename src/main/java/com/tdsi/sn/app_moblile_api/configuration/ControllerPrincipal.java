package com.tdsi.sn.app_moblile_api.configuration;

import com.example.app1.entity.Controlleur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControllerPrincipal implements UserDetails {

    private Controlleur controlleur;

    public ControllerPrincipal(Controlleur controlleur){
        this.controlleur = controlleur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.controlleur.getPermissionsList().forEach(p ->{
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        });
        this.controlleur.getRolesList().forEach(r ->{
            GrantedAuthority authority = new SimpleGrantedAuthority("ROlE"+r);
            authorities.add(authority);
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.controlleur.getPassword();
    }

    @Override
    public String getUsername() {
        return this.controlleur.getPrenom();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
