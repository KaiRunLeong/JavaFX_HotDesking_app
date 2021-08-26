/*
 * Class: CurrentUserLoginDetailsModel.java
 *
 * Description: The class will contain information on the current user who is logged
 *              into the system.
 *
 * Author: Kai Run Leong (s3862092)
 */

package main.model;

public class CurrentUserLoginDetailsModel {
    private static int employeeID;
    private static String fullName;

    public static void setEmployeeID(int id){
       employeeID = id;
    }

    public static int getEmployeeID(){
        return employeeID;
    }

    public static String getFullName() {
        return fullName;
    }

    public static void setFullName(String fullName) {
        CurrentUserLoginDetailsModel.fullName = fullName;
    }
}
