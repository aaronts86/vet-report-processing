/**
 * Aaron Schraufnagel.
 */
package midterm.progpracticum;

/**
 * File: Vertebrate.java
 * A <code>Vertebrate</code> object represents a vertebrate and the 
 * <code>Vertebrate</code> class is a superclass to all vertebrate subclasses. 
 * 
 * @author Aaron Schraufnagel
 * @custom.inv myAge >= 0, myHeight >= 0, myWeight >= 0
 * 
 */
public class Vertebrate {
    /**
     * myClass instance field holds the VertClass enum value of the Vertebrate object's class
     * in the animal kingdom.
     */
    private VertClass myClass;
    /**
     * mySpecies instance field holds the String value of the Vertebrate object's species
     * type in the animal kingdom.
     */
    private String mySpecies;
    /**
     * myGender instance field holds the VertGender enum value of the Vertebrate object's 
     * gender type.
     */
    private VertGender myGender;
    /**
     * myAge instance field holds the double value of the Vertebrate object's age.
     */
    private double myAge;
    /**
     * myHeight instance field holds the double value of the Vertebrate object's height.
     */
    private double myHeight;
    /**
     * myWeight instance field holds the double value of the Vertebrate object's weight.
     */
    private double myWeight;
    /**
     * myCall instance field holds the String value of the Vertebrate object's language.
     */
    private String myCall;
  
    /**
     * The default constructor for the <code>Vertebrate</code> class 
     * initializes instance fields if no explicit parameters are given.
     */
    public Vertebrate() {
        // initializes myCLass instance field
        this.myClass = VertClass.NONE;
        // initializes mySpecies instance field
        this.mySpecies = "None";
        // initializes myGender instance field
        this.myGender = VertGender.OTHER;
        // initializes myCall instance field
        this.myCall = "None";
    }
    
    /**
     * The parameterized constructor for the <code>Vertebrate</code> class 
     * initializes its instance fields with the explicit parameters given.
     * 
     * @param aClass the vertebrate's class
     * @param aSpecies contains only letters, spaces, and apostrophes
     * @param aGender the vertebrate's gender
     * @param anAge >= 0
     * @param aHeight >= 0
     * @param aWeight >= 0
     * @param aCall the vertebrate's speech
     * 
     * @throws IllegalArgumentException
     */
    public Vertebrate(final VertClass aClass, final String aSpecies, final VertGender aGender,
                      final double anAge, final double aHeight, final double aWeight, 
                      final String aCall) {
        //super();
        if (anAge < 0 || aHeight < 0 || aWeight < 0) {
            throw new IllegalArgumentException();
        }
        // initializes myClass instance field
        this.myClass = aClass;
        // initializes mySpecies instance field
        this.mySpecies = aSpecies;
        // initializes myGendder instance field
        this.myGender = aGender;
        // initializes myAge instance field
        this.myAge = anAge;
        // initializes myHeight instance field
        this.myHeight = aHeight;
        // initializes myWeight instance field
        this.myWeight = aWeight;
        // initializes myCall instance field
        this.myCall = aCall;
    }
    
    /**
     * Returns the vertebrate's class.
     * @return myClass the vertebrate's class
     */
    public VertClass getMyClass() {
        return myClass;
    }
    
    /**
     * Sets the vertebrate's class.
     * @param aClass the vertebrate's class
     * @custom.post intantiates myClass instance field to value of aClass
     */
    public void setMyClass(VertClass aClass) {
        this.myClass = aClass;
    }
    
    /**
     * Returns the vertebrate's species.
     * @return mySpecies the vertebrate's species
     */
    public String getMySpecies() {
        return mySpecies;
    }
    
    /**
     * Sets the vertebrate's species.
     * @param aSpecies the vertebrate's species
     * @custom.post intantiates mySpecies instance field to value of aSpecies
     */
    public void setMySpecies(String aSpecies) {
        this.mySpecies = aSpecies;
    }
    
    /**
     * Returns the vertebrate's gender.
     * @return myGender the vertebrate's gender
     */
    public VertGender getMyGender() {
        return myGender;
    }
    
    /**
     * Sets the vertebrate's gender.
     * @param aGender the vertebrate's gender
     * @custom.post intantiates myGender instance field to value of aGender
     */
    public void setMyGender(VertGender aGender) {
        this.myGender = aGender;
    }
    
    /**
     * Returns the vertebrate's age.
     * @return myAge the vertebrate's age
     */
    public double getMyAge() {
        return myAge;
    }
    
    /**
     * Sets the vertebrate's age.
     * @param anAge >= 0
     * @custom.post intantiates myAge instance field to value of anAge
     * 
     * @throws IllegalArgumentException
     */
    public void setMyAge(double anAge) {
        if (anAge < 0) {
            throw new IllegalArgumentException();
        }
        this.myAge = anAge;
    }
    
    /**
     * Returns the vertebrate's height.
     * @return myHeight the vertebrate's height
     */
    public double getMyHeight() {
        return myHeight;
    }
    
    /**
     * Sets the vertebrate's height.
     * @param aHeight >= 0
     * @custom.post intantiates myHeight instance field to value of aHeight
     * 
     * @throws IllegalArgumentException
     */
    public void setMyHeight(double aHeight) {
        if (aHeight < 0) {
            throw new IllegalArgumentException();
        }
        this.myHeight = aHeight;
    }
    
    /**
     * Returns the vertebrate's weight.
     * @return myWeight the vertebrate's weight
     */
    public double getMyWeight() {
        return myWeight;
    }
    
    /**
     * Sets the vertebrate's weight.
     * @param aWeight >= 0
     * @custom.post intantiates myWeight instance field to value of aWeight
     * 
     * @throws IllegalArgumentException
     */
    public void setMyWeight(double aWeight) {
        if (aWeight < 0) {
            throw new IllegalArgumentException();
        }
        this.myWeight = aWeight;
    }
    
    /**
     * Returns the vertebrate's call.
     * @return myClass the vertebrate's call
     */
    public String getMyCall() {
        return myCall;
    }
    
    /**
     * Sets the vertebrate's speech.
     * @param aCall the vertebrate's speech
     * @custom.post intantiates mySpeech instance field to value of aSpeech
     */
    public void setMyCall(String aCall) {
        this.myCall = aCall;
    }
    
    /**
     * Returns a String representation of this <code>Vertebrate</code> object.
     * @return toReturn readable representation of this <code>Vertebrate</code> object.
     */
    @Override
    public String toString() {
        String toReturn = "\nClass: " + myClass + "\nSpecies: " + mySpecies + "\nGender: " 
                          + myGender;
        toReturn += "\nAge: " + myAge + "\nHeight: " + myHeight + "\nWeight: " + myWeight 
                    + "\nSpeech: " + myCall;
        toReturn += "\n------\n";
        return toReturn;
    }
}
