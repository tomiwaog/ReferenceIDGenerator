package referencegenerator;
import java.util.HashMap;

class Department {
    private String name;
    String prefix;

    Department(String name, String departmentPrefix) {
        this.name = name;
        this.prefix = departmentPrefix;
    }
}

public class ReferenceSystem {
    //Maps one for storing department names and the other for managing tickets
    private static HashMap<Department, Integer> departmentsReferencesDB = new HashMap<>();
    private static HashMap<String, Department> departmentNames = new HashMap<>();

    
    public ReferenceSystem() {
        addDepartment("", ""); //
    }

    public ReferenceSystem(String name, String prefix){
        addDepartment(name,prefix);
    }
    public static String generateReference() {
        // Unspecified Department name
        return generateReference("");
    }

    public static String generateReference(String department) {
        Department dp = departmentNames.get(department);
        if (dp == null)
            return null;

        int currentCount = departmentsReferencesDB.get(dp);
        departmentsReferencesDB.put(dp, ++currentCount);
        return dp.prefix + currentCount;
    }

    public static String getLastReference() {
        return getLastReference("");
    }

    public static String getLastReference(String department) {
        Department dp = departmentNames.get(department);
        if (dp==null) return null;
        return dp.prefix + departmentsReferencesDB.get(dp);
    }
   
    public static boolean addDepartment(String departmentName, String departmentPrefix){
        if (getDepartment(departmentName)!=null) {
            System.out.println("Cannot create "+departmentName+". Dept already exist!");
            return false;
        }
        
        if (departmentName!=""){
            //Prevents pushing notification for default creation
            System.out.print("Creating property..."+ departmentName);
            System.out.print(". Property: "+departmentName+ " was added!\n");
        }

        Department dep = new Department(departmentName,departmentPrefix);
        departmentNames.put(departmentName, dep);
        departmentsReferencesDB.put(dep, 0);
        
        return true;
    }
    
    private static Department getDepartment(String departmentName){
        Department dp = departmentNames.get(departmentName);
        return dp;
    }
    
}
