package com.tdsi.sn.app_moblile_api.Services;

import com.tdsi.sn.app_moblile_api.Entity.Objet;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.time.LocalDateTime;

@Service
public class Verification {
    private RSAPrivateKeySpec priv;
    private RSAPublicKeySpec pub;
    public static BigInteger g;

    public void genkeys(){

        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstanceStrong();
            keyGen.initialize(1024, random);
            KeyPair pair = keyGen.genKeyPair();
            pub = KeyFactory.getInstance("RSA").getKeySpec(pair.getPublic(),RSAPublicKeySpec.class);
            priv = KeyFactory.getInstance("RSA").getKeySpec(pair.getPrivate(), RSAPrivateKeySpec.class);
            g = new BigInteger(1024,random);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public BigInteger decodd(BigInteger password){
          return password.modPow(priv.getPrivateExponent(),priv.getModulus());
    }
    public BigInteger hash(int telephone, LocalDateTime localDateTime) throws Exception {
        BigInteger h = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest((telephone+localDateTime.toString()).getBytes());
            h = new BigInteger(1, messageDigest);
        } catch (Exception e){
            System.out.println(e.getCause());
        }
        return h;
    }
    public BigInteger hashTelephone(int telephone){
        String numero = Integer.toString(telephone);
        BigInteger h = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(numero.getBytes());
            h = new BigInteger(1, messageDigest);
        } catch (Exception e){
            System.out.println(e.getCause());
        }
        return h;
    }
    public String getPt(int password,int telephone){
        return BigInteger.valueOf(password*telephone).toString(16);
    }
    public String getPuEtudiant(int password,int telephone,BigInteger g){
        String text = pub.getModulus().toString();
        return text;
    }
    public BigInteger getPublic(){
        return pub.getPublicExponent();
    }
    public boolean authenticaed(BigInteger Pu, BigInteger g, Objet objet) throws Exception {
        BigInteger  a = Pu.modPow(pub.getPublicExponent(),pub.getModulus()).add(hashTelephone(objet.getTelephone()));
        BigInteger b = objet.getX().multiply(a).multiply(hash(objet.getTelephone(),objet.getLocalDateTime()));
        if (g.modPow(objet.getQrtext(),pub.getModulus()) == b){
            return true;
        }
        else {
            return false;
        }
    }
}
