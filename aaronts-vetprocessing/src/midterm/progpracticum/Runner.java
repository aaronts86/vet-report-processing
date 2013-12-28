/**
 * Aaron Schraufnagel.
 */
package midterm.progpracticum;

/**
 * File: Runner.java
 * The <code>Runner</code> class contains the main method for running the program
 * and calling all the methods to read input from the files, store them, and to output them.
 *
 * @author Aaron Schraufnagel
 * 
 * @custom.inv None
 */
public class Runner {
    
    /**
     * @param aRgs the arguments for the main method of array type String
     */
    public static void main(String[] aRgs) {
        PatientList.buildPatientList();
        ProcedureList.buildProcedureList();
        ClinicMaps.buildMaps();
        OutputWriter.outputPatientReport();
        OutputWriter.outputProcedureReport();
    }
}
