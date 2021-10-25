package com.tdsi.sn.app_moblile_api.Entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Objet {

    private int telephone;
    private BigInteger X;
    private BigInteger Qrtext;
    private LocalDateTime localDateTime;

    public int getTelephone() {
        return telephone;
    }

    public BigInteger getX() {
        return X;
    }

    public BigInteger getQrtext() {
        return Qrtext;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Objet(int telephone, BigInteger x, BigInteger qrtext, LocalDateTime localDateTime) {
        this.telephone = telephone;
        X = x;
        Qrtext = qrtext;
        this.localDateTime = localDateTime;
    }
}
