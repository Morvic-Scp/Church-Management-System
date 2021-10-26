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
public class expenseSub {
    
    private String ID;
    private Date Date;
    private int utilities;
    private int allow;
    private int charity;
    private int tithebook;
    private int transportation;
    private int others;

    public expenseSub(String ID,Date Date, int utilities, int allow, int charity, int tithebook, int transportation, int others) {
        this.ID = ID;
        this.Date=Date;
        this.utilities = utilities;
        this.allow = allow;
        this.charity = charity;
        this.tithebook = tithebook;
        this.transportation = transportation;
        this.others = others;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getUtilities() {
        return utilities;
    }

    public void setUtilities(int utilities) {
        this.utilities = utilities;
    }

    public int getAllow() {
        return allow;
    }

    public void setAllow(int allow) {
        this.allow = allow;
    }

    public int getCharity() {
        return charity;
    }

    public void setCharity(int charity) {
        this.charity = charity;
    }

    public int getTithebook() {
        return tithebook;
    }

    public void setTithebook(int tithebook) {
        this.tithebook = tithebook;
    }

    public int getTransportation() {
        return transportation;
    }

    public void setTransportation(int transportation) {
        this.transportation = transportation;
    }

    public int getOthers() {
        return others;
    }

    public void setOthers(int others) {
        this.others = others;
    }
    
}
