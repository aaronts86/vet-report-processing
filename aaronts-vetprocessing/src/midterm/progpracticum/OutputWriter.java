/**
 * Aaron Schraufnagel.
 */
package midterm.progpracticum;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * File: OutputWriter.java
 * The <code>OutputWriter</code> class outputs all the veterinary clinic's stored patient
 * and procedure data, as well as its sales reports for a given time period, to a proper
 * format.
 * 
 * @author Aaron Schraufnagel
 * @see java.io.File
 * @see java.io.FileNotFoundException
 * @see java.util.ArrayList
 * @see java.util.HashMap
 * @see java.util.List
 * @see java.util.Map
 * @see java.util.TreeMap
 * 
 * @custom.inv None
 */
public class OutputWriter {
    /**
     * FORMAT is a final String representation of the formatting to be used anytime American
     * dollars are being represented in the form $0.00.
     */
    private static final String FORMAT = "$%.2f";
    
    /**
     * The outputPatientReport method takes the data that was stored in the lists and maps
     * containing the clinic's patient info. This data is then outputted in a proper format
     * to a file.
     */
    public static void outputPatientReport() {
        /**
         * dates is a String array representing the first and last date from a given period
         * of patient data.
         */
        final String[] dates = generateDates();
        /**
         * patientMap is a map that holds the data for all the clinic's patient ID's
         * and their total charges.
         */
        final Map<String, Double> patientMap = new TreeMap<>();
        /**
         * patients is a list that holds the data of all the patients and their vital
         * information.
         */
        final List<Patient> patients = new ArrayList<>();
        /**
         * totalFee holds the overall charges of every patient in the clinic.
         */
        double totalFee = 0.0;
        
        /**
         * All of the data collected for the patientMap is placed into it.
         */
        patientMap.putAll(ClinicMaps.getMyPatientMap());
        /**
         * All of the data collected for the patient list is placed into it.
         */
        patients.addAll(PatientList.getMyPatientList());
        
        /**
         * A try-catch block is used in the event that there is any problem with outputting
         * the clinic patient information to the proper file.
         */
        try {
            /**
             * A FileOutputStream is used to output to a file.
             */
            final FileOutputStream file = new
                    FileOutputStream("myresources/patientReport.csv");
            /**
             * A PrintWriter is used to write the patient data to a file.
             */
            final PrintWriter writer = new PrintWriter(file);
            
            /**
             * The period of first and last dates is written to the file based on the data
             * generated in the dates array.
             */
            writer.write("Period:," + dates[0] + "," + dates[1]);
            /**
             * The number of total visits are written to the file based on the calculations
             * when gathering the patient data.
             */
            writer.write("\nNumber of visits during this period,"
                         + ClinicMaps.getMyTotalVisits());
            /**
             * The header contents are written to the file for each patient.
             */
            writer.write("\nID,Class,Species,Gender,Age,Height,Weight,Call,Name,Address,"
                         + "Owner,Total");
    
            /**
             * An enhanced for loop is used to cycle through the patient map. This allows the
             * data to be written in the order of their ID numbers. Each patient's
             * fee will be calculated as well as the overall total fee.
             */
            for (Map.Entry<String, Double> patientFee : patientMap.entrySet()) {
                /**
                 * An enhanced for loop is used to cycle through the patient list. When there
                 * is a match of patient ID's in the map and the list, the patient info is
                 * gathered and output to the file.
                 */
                for (Patient patient: patients) {
                    /**
                     * An if statement is used on every patient in the map and list to
                     * determine if there is a match. If so, all the information is
                     * gathered from each to output the proper data to the file.
                     */
                    if (patient.getMyPatientID().equals(patientFee.getKey())) {
                        writer.write("\n" + patient.getMyPatientID() + ","
                                     + patient.getMyPet().getMyClass() + ","
                                     + patient.getMyPet().getMySpecies() + ","
                                     + patient.getMyPet().getMyGender() + ","
                                     + patient.getMyPet().getMyAge() + ","
                                     + patient.getMyPet().getMyHeight() + ","
                                     + patient.getMyPet().getMyWeight() + ","
                                     + patient.getMyPet().getMyCall() + ","
                                     + patient.getMyPet().getMyName() + ","
                                     + patient.getMyPet().getMyAddress() + ","
                                     + patient.getMyPet().getMyOwner() + ","
                                     + String.format(FORMAT, patientFee.getValue()));
                        /**
                         * The totalFee is added to every time the patient map determines
                         * that the patient had a procedure done and the value is
                         * incremented by the fee.
                         */
                        totalFee += patientFee.getValue();
                    }
                }
            }
            /**
             * The total fee is written to the file in its proper format.
             */
            writer.write("\nTotal:,,,,,,,,,,," + String.format(FORMAT, totalFee));
            /**
             *  The output FileWriter is closed.
             */
            writer.close();
        /**
         * If there are any problems outputting to the proper file, a FileNotFound exception
         * is displayed to the user.    
         */
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * The outputProcedureReport method takes the data that was stored in the lists and maps
     * containing the clinic's procedure info. This data is then outputted in a proper format
     * to a file.
     */
    public static void outputProcedureReport() {
        /**
         * dates is a String array representing the first and last date from a given period
         * of procedure data.
         */
        final String[] dates = generateDates();
        /**
         * procedureMap is a map that holds the data for all the clinic's procedure ID's
         * and their total number of procedures done.
         */
        final Map<String, Integer> procedureMap = new HashMap<>();
        /**
         * procedures is a list that holds the data of all the procedures and the procedure
         * information.
         */
        final List<Procedure> procedures = new ArrayList<>();
        /**
         * totalFee holds the overall charges of every patient in the clinic.
         */        
        double totalFee = 0.0;
        
        /**
         * All of the data collected for the procedureMap is placed into it.
         */
        procedureMap.putAll(ClinicMaps.getMyProcedureMap());
        /**
         * All of the data collected for the procedure list is placed into it.
         */
        procedures.addAll(ProcedureList.getMyProcedureList());
        
        /**
         * A try-catch block is used in the event that there is any problem with outputting
         * the procedure information to the proper file.
         */        
        try {
            /**
             * A FileOutputStream is used to output to a file.
             */
            final FileOutputStream file = new
                    FileOutputStream("myresources/procedureReport.csv");
            /**
             * A PrintWriter is used to write the patient data to a file.
             */
            final PrintWriter writer = new PrintWriter(file);
            
            /**
             * The period of first and last dates is written to the file based on the data
             * generated in the dates array.
             */
            writer.write("Period:," + dates[0] + "," + dates[1]);
            /**
             * The number of total visits are written to the file based on the calculations
             * when gathering the patient data.
             */
            writer.write("\nNumber of visits during this period,"
                         + ClinicMaps.getMyTotalVisits());
            /**
             * The header contents are written to the file for each procedure.
             */
            writer.write("\nProcedure,Fee,Quantity,Total");
            
            /**
             * An enhanced for loop is used to cycle through each procedure. This allows the
             * data to be written in the order that they were inputted in, ordered by their
             * procedure name in alphabetical order. Each procedures's total fee will be
             * calculated as well as the overall total fee for all procedures.
             */
            for (Procedure procedure: procedures) {
                writer.write("\n" + procedure.getMyProcedureID() + " "
                             + procedure.getMyProcedureName() + "," + procedure.getMyFee()
                             + "," + procedureMap.get(procedure.getMyProcedureID()) + ","
                             + String.format(FORMAT, procedure.getMyFee()
                             * procedureMap.get(procedure.getMyProcedureID())));
                /**
                 * The totalFee is added to every time the procedure map determines
                 * how many times the procedure has been done and this number is
                 * multiplied by the fee associated with the procedure which is then
                 * incremented by the fee.
                 */
                totalFee += procedure.getMyFee()
                        * procedureMap.get(procedure.getMyProcedureID());
            }
            /**
             * The total fee is written to the file in its proper format.
             */
            writer.write("\nTotal:,,," + String.format(FORMAT, totalFee));
            /**
             *  The output FileWriter is closed.
             */
            writer.close();
        /**
         * If there are any problems outputting to the proper file, a FileNotFound exception
         * is displayed to the user.    
         */    
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * The generateDates method takes the list of dates that was stored based on the given
     * input data's time period. The first and last of these dates are placed into an array
     * to be outputted to the patient and procedure output files in the proper format.
     * @return dates array to hold the first and last date of the given time period
     */
    public static String[] generateDates() {
        /**
         * allDates is a list that holds the data of all the dates stored based on the given
         * input data's time period.
         */
        final List<String> allDates = new ArrayList<>();
        /**
         * dates is a String array to hold the first and last date of the given time period.
         * The default date values are given in the event that no date values are given
         * for the time period.
         */
        final String[] dates = {"??/??/??", "??/??/??"};
        
        /**
         * All of the dates collected from the input data for the list is placed into it.
         */
        allDates.addAll(ClinicMaps.getMyDates());

        /**
         * An if statement is used to determine if the list of dates isn't empty. If it is
         * empty, the default values are used. Otherwise, the first and last date values
         * in the last are set as the new defaults.
         */
        if (allDates.size() > 0) {
            dates[0] = allDates.get(0);
            dates[1] = allDates.get(allDates.size() - 1);

            /**
             * An enhanced for loop is used to cycle through each date in the list to
             * determine if there are any dates before or after the default first and last
             * date values.
             */
            for (String date: allDates) {
                /**
                 * If there are any dates in the list coming before the previously set
                 * first date in the list, the new value replaces the old value.
                 */
                if (date.compareTo(dates[0]) < 0) {
                    dates[0] = date;
                }
                /**
                 * If there are any dates in the list coming after the previously set
                 * last date in the list, the new value replaces the old value.
                 */
                if (date.compareTo(dates[1]) > 0) {
                    dates[1] = date;
                }
            }
        }
        /**
         * The first and last date values of the time period are returned.
         */
        return dates;
    }
}
