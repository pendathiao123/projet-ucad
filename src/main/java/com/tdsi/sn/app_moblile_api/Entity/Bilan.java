package com.tdsi.sn.app_moblile_api.Entity;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "bilan")
public class Bilan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbilan;
    private int nbreticketrepas;
    private int nbreticketdej;
    private Date date;


}
