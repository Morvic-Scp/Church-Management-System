/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;

import java.sql.Date;

/**
 *
 * @author Morvic
 */
public class financesub {
    
    private String Id;
    private Date Date;
    private int membershipDues;
    private int thanksgiving;
    private int tithe;
    private int specOffering;
    private int otherdues;
    private int Collections;
    private int funeraldues;
    private int pe;
    private int tithebook;
    private int bapcard;
    private int annualharvest;
    private int refund;
    

    public financesub(String Id,Date Date, int membershipDues, int thanksgiving, int tithe, int specOffering, int otherdues, int Collections, int funeraldues, int pe, int tithebook, int bapcard, int annualharvest, int refund) {
        this.Id = Id;
        this.Date=Date;
        this.membershipDues = membershipDues;
        this.thanksgiving = thanksgiving;
        this.tithe = tithe;
        this.specOffering = specOffering;
        this.otherdues = otherdues;
        this.Collections = Collections;
        this.funeraldues = funeraldues;
        this.pe = pe;
        this.tithebook = tithebook;
        this.bapcard = bapcard;
        this.annualharvest = annualharvest;
        this.refund = refund;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }
    
    public int getMembershipDues() {
        return membershipDues;
    }

    
    public void setMembershipDues(int membershipDues) {
        this.membershipDues = membershipDues;
    }

    public int getThanksgiving() {
        return thanksgiving;
    }

    public void setThanksgiving(int thanksgiving) {
        this.thanksgiving = thanksgiving;
    }

    public int getTithe() {
        return tithe;
    }

    public void setTithe(int tithe) {
        this.tithe = tithe;
    }

    public int getSpecOffering() {
        return specOffering;
    }

    public void setSpecOffering(int specOffering) {
        this.specOffering = specOffering;
    }

    public int getOtherdues() {
        return otherdues;
    }

    public void setOtherdues(int otherdues) {
        this.otherdues = otherdues;
    }

    public int getCollections() {
        return Collections;
    }

    public void setCollections(int Collections) {
        this.Collections = Collections;
    }

    public int getFuneraldues() {
        return funeraldues;
    }

    public void setFuneraldues(int funeraldues) {
        this.funeraldues = funeraldues;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getTithebook() {
        return tithebook;
    }

    public void setTithebook(int tithebook) {
        this.tithebook = tithebook;
    }

    public int getBapcard() {
        return bapcard;
    }

    public void setBapcard(int bapcard) {
        this.bapcard = bapcard;
    }

    public int getAnnualharvest() {
        return annualharvest;
    }

    public void setAnnualharvest(int annualharvest) {
        this.annualharvest = annualharvest;
    }

    public int getRefund() {
        return refund;
    }

    public void setRefund(int refund) {
        this.refund = refund;
    }
    
    

}
