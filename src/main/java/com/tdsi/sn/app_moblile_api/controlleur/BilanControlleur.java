package com.tdsi.sn.app_moblile_api.controlleur;


import com.tdsi.sn.app_moblile_api.Entity.Bilan;
import com.tdsi.sn.app_moblile_api.service.BilanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class BilanControlleur {

    @Autowired
    private BilanService bilanService;

    @GetMapping("/bilans")
    public Iterable<Bilan> getBilans() {
        return bilanService.getBilans();
    }
    @GetMapping("/bilan/{id}")
    public Optional<Bilan> getBilan(@PathVariable("id") int id)  {
        return bilanService.getBilan(id);
    }
    @PutMapping("/bilan")
    public Bilan createBilan(@RequestBody Bilan bilan) {
        return bilanService.createBilan(bilan);
    }
}
