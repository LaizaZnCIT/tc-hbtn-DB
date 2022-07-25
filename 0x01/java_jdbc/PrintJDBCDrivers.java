import java.sql.*;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        for(Enumeration<Driver> drivers = DriverManager.getDrivers(); drivers.hasMoreElements();){
            Driver driver = drivers.nextElement();
            System.out.println(driver.getClass() + " " + driver.getMajorVersion());

        }
    }
}
