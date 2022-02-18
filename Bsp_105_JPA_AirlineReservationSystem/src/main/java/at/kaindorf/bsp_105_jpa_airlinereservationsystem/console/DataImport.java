package at.kaindorf.bsp_105_jpa_airlinereservationsystem.console;

import at.kaindorf.bsp_105_jpa_airlinereservationsystem.pojos.Aircraft;
import at.kaindorf.bsp_105_jpa_airlinereservationsystem.pojos.AircraftType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataImport {

    private static DataImport dataImportInstance = new DataImport();

    private Path typesPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "aircrafttypes.csv");
    private Path airlinesPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "airlines.csv");
    private Path airportsPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "airports.csv");

    private EntityManagerFactory emf;
    private EntityManager em;

    private DataImport() {}

    public static DataImport getInstance() {
        return dataImportInstance;
    }


    public void open(){
        emf = Persistence.createEntityManagerFactory("PU_Airline_Reservation_System");
        em = emf.createEntityManager();
    }

    public void close() {
        em.close();
        emf.close();
    }

    public void importData() throws IOException {
        File inputF = new File(typesPath.toString());
        InputStream inputFS = new FileInputStream(inputF);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

        List<AircraftType> aircraftTypeList = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    public static void main(String[] args) {
        DataImport dim = getInstance();
        dim.open();
        try {
            dim.importData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dim.close();
    }
}
