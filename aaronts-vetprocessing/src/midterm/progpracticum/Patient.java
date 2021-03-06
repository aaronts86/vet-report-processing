/**
 * Aaron Schraufnagel.
 */
package midterm.progpracticum;

import java.util.Objects;

/**
 * File: Patient.java
 * The <code>Patient</code> class represents a pet that is a patient at the veterinary clinic
 * and holds values for the patient's ID number and all of their vital information.
 * 
 * @author Aaron Schraufnagel
 * @see java.util.Objects
 * 
 * @custom.inv myPet cannot be null, myPatientID cannot be null
 */
public class Patient implements Comparable<Patient> {
    private HomePet myPet;
    private String myPatientID;
    
    public Patient(final HomePet aPet, final String aPatientID) {
        if (aPet == null) {
            throw new NullPointerException("Pet cannot be null");
        }
        if (aPatientID == null) {
            throw new NullPointerException("Patient ID number cannot be null");
        }
        this.myPet = aPet;
        this.myPatientID = aPatientID;
    }
    
    public Patient(final Patient anOther) {
        this(anOther.myPet, anOther.myPatientID);
    }
    
    public HomePet getMyPet() {
        return myPet;
    }
    
    public void setMyPet(HomePet aPet) {
        if (aPet == null) {
            throw new NullPointerException("Pet cannot be null");
        }
        this.myPet = aPet;
    }
    
    public String getMyPatientID() {
        return myPatientID;
    }
    
    public void setMyPatientID(String aPatientID) {
        if (aPatientID == null) {
            throw new NullPointerException("Patient ID number cannot be null");
        }
        this.myPatientID = aPatientID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.myPatientID);
    }

    @Override
    public boolean equals(Object anOtherObject) {
        if (this == anOtherObject) {
            return true;
        }
        if (anOtherObject == null) {
            return false;
        }
        if (!(anOtherObject instanceof Patient)) {
            return false;
        }
        final Patient other = (Patient) anOtherObject;
        return Objects.equals(this.myPatientID, other.myPatientID);
    }
    
    @Override
    public int compareTo(Patient anOther) {
        return this.myPatientID.compareTo(anOther.myPatientID);
    }  
    
    @Override
    public String toString() {
        return "\nPatient ID: " + myPatientID + myPet;
    }  
}
