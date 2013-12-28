/**
 * Aaron Schraufnagel.
 */
package midterm.progpracticum;

/**
 * File: HomePet.java
 * A <code>HomePet</code> object represents a home pet and the <code>HomePet</code> 
 * class is a subclass of the <code>Vertebrate</code> class. 
 * 
 * @author Aaron Schraufnagel
 * @custom.inv myName contains only letters, spaces, and apostrophes,
 *             myOwner contains only letters, spaces, and apostrophes
 *
 */
public class HomePet extends Vertebrate {
    /**
     * myName instance field holds the String value of the HomePet object's name.
     */
    private String myName;                  
    /**
     * myAddress instance field holds the String value of the HomePet object's address.
     */
    private String myAddress;               
    /**
     * myOwner instance field holds the String value of the HomePet object's owner.
     */
    private String myOwner;                 

    /**
     * The default constructor for the <code>HomePet</code> class initializes instance fields
     *  if no explicit parameters are given.
     */
    public HomePet() {
        // calls the superclass default constructor
        super();
        // initializes myName instance field
        this.myName = "None";
        // initializes myAddress instance field
        this.myAddress = "None";
        // initializes myOwner instance field
        this.myOwner = "None";
    }

    /**
     * The parameterized constructor for the <code>HomePet</code> class initializes its 
     * instance fields as well as passing the given explicit parameters to its superclass
     * as well.
     * 
     * @param aClass the vertebrate's class
     * @param aSpecies contains only letters, spaces, and apostrophes
     * @param aGender the vertebrate's gender
     * @param anAge >= 0
     * @param aHeight >= 0
     * @param aWeight >= 0
     * @param aCall the vertebrate's speech
     * @param aName contains only letters, spaces, and apostrophes
     * @param anAddress the homepet's residence address
     * @param anOwner contains only letters, spaces, and apostrophes
     * 
     * @throws IllegalArgumentException
     */
    public HomePet(final VertClass aClass, final String aSpecies, final VertGender aGender, 
                   final double anAge, final double aHeight, final double aWeight,
                   final String aCall, final String aName, final String anAddress,
                   final String anOwner) {
        // initializes superclass instance fields
        super(aClass, aSpecies, aGender, anAge, aHeight, aWeight, aCall);
        // initializes myName instance field
        this.myName = aName;
        // initializes myAddress instance field
        this.myAddress = anAddress;
        // initializes myOwner instance field
        this.myOwner = anOwner;
    }


    /**
     * Returns the homepet's name.
     * @return myName the homepet's name
     */
    public String getMyName() {
        return myName;
    }


    /**
     * Sets the homepet's name.
     * @param aName contains only letters, spaces, and apostrophes
     * @custom.post intantiates myName instance field to value of aName
     */
    public void setMyName(String aName) {
        this.myName = aName;
    }


    /**
     * Returns the homepet's address.
     * @return myAddress the homepet's address
     */
    public String getMyAddress() {
        return myAddress;
    }


    /**
     * Sets the homepet's address.
     * @param anAddress the homepet's residence address
     * @custom.post intantiates myAddress instance field to value of anAddress
     */
    public void setMyAddress(String anAddress) {
        this.myAddress = anAddress;
    }


    /**
     * Returns the homepet owner's name.
     * @return myOwner the homepet owner's name
     */
    public String getMyOwner() {
        return myOwner;
    }


    /**
     * Sets the homepet owner's name.
     * @param anOwner contains only letters, spaces, and apostrophes
     * @custom.post intantiates myOwner instance field to value of anOwner
     */
    public void setMyOwner(String anOwner) {
        this.myOwner = anOwner;
    }

    /**
     * Returns a String representation of this <code>HomePet</code> object.
     * @return toReturn readable representation of this <code>HomePet</code> object.
     */
    @Override
    public String toString() {
        return "\nName: " + myName + "\nAddress: " + myAddress + "\nOwner: "
                + myOwner + super.toString();
    }
}
