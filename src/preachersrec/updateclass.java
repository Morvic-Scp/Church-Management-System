/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;

import javafx.collections.ObservableList;

/**
 *
 * @author Morvic
 */
public class updateclass {
    ObservableList<financesub>passfinance;
    ObservableList<expenseSub>passexpense;
    ObservableList<registrationSub>passregister;
    private final static updateclass update=new updateclass();
    ObservableList<financesub>fieldFinance;
    ObservableList<expenseSub>fieldexpense;
    ObservableList<registrationSub>fieldregister;
    boolean anchorfinhide=false;
    boolean anchorexphide=false;
    boolean anchorreghide=false;
    boolean btnpressed=false;
    int index;
    

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public ObservableList<financesub> getFieldFinance() {
        return fieldFinance;
    }

    public void setFieldFinance(ObservableList<financesub> fieldFinance) {
        this.fieldFinance = fieldFinance;
    }

    public ObservableList<expenseSub> getFieldexpense() {
        return fieldexpense;
    }

    public void setFieldexpense(ObservableList<expenseSub> fieldexpense) {
        this.fieldexpense = fieldexpense;
    }

    public ObservableList<registrationSub> getFieldregister() {
        return fieldregister;
    }

    public void setFieldregister(ObservableList<registrationSub> fieldregister) {
        this.fieldregister = fieldregister;
    }

    public ObservableList<financesub> getPassfinance() {
        return passfinance;
    }

    public void setPassfinance(ObservableList<financesub> passfinance) {
        this.passfinance = passfinance;
    }

    public ObservableList<expenseSub> getPassexpense() {
        return passexpense;
    }

    public void setPassexpense(ObservableList<expenseSub> passexpense) {
        this.passexpense = passexpense;
    }

    public ObservableList<registrationSub> getPassregister() {
        return passregister;
    }

    public void setPassregister(ObservableList<registrationSub> passregister) {
        this.passregister = passregister;
    }
    
    public static updateclass getupdateInstance() {
        return update;
    }

    public boolean isAnchorfinhide() {
        return anchorfinhide;
    }

    public void setAnchorfinhide(boolean anchorfinhide) {
        this.anchorfinhide = anchorfinhide;
    }

    public boolean isAnchorexphide() {
        return anchorexphide;
    }

    public void setAnchorexphide(boolean anchorexphide) {
        this.anchorexphide = anchorexphide;
    }

    public boolean isAnchorreghide() {
        return anchorreghide;
    }

    public void setAnchorreghide(boolean anchorreghide) {
        this.anchorreghide = anchorreghide;
    }

    public boolean isBtnpressed() {
        return btnpressed;
    }

    public void setBtnpressed(boolean btnpressed) {
        this.btnpressed = btnpressed;
    }
    

}
