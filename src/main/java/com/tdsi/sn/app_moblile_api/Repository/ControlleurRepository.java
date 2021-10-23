package com.tdsi.sn.app_moblile_api.Repository;

import com.tdsi.sn.app_moblile_api.Entity.Controlleur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlleurRepository extends JpaRepository<Controlleur,Integer> {

    @Query("from Controlleur u where u.telephone=?1")
    Controlleur findByTelephone(String telephone);


}
