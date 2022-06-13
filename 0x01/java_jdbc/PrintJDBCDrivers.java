import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main(String[] args) {

        Enumeration<Driver> drivers = DriverManager.getDrivers();

        while (drivers.asIterator().hasNext()){
            Driver driver = drivers.asIterator().next();
            System.out.println(driver.getClass().getCanonicalName() + " " + driver.getMajorVersion());
        }
    }
}
