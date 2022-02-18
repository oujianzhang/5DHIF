package at.kaindorf.bsp_102_klasseninfo.console;

import at.kaindorf.bsp_102_klasseninfo.beans.*;
import at.kaindorf.bsp_102_klasseninfo.bl.Floor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.xml.bind.JAXB;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DataHandler {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public void open() {
        emf = Persistence.createEntityManagerFactory("PU_Klasseninfo");
        em = emf.createEntityManager();
    }

    public void close() {
        em.close();
        emf.close();
    }

    public void importTables() {

        Path path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "schooldata.xml");
        School school = JAXB.unmarshal(path.toFile(), School.class);
        List<Teacher> teachers = new ArrayList<>();
        teachers = school.getTeachers();
        Room room;
        Classname name;
        ClassTeacher teacher;

        em.getTransaction().begin();
        for (Teacher teach: teachers) {
            teacher = new ClassTeacher(teach.getKuerzel(), teach.getVorname(), teach.getFamilienname(), teach.getTitel());
            room = new Room(teach.getRaum(), Integer.parseInt(teach.getRaum().charAt(0)+"") == 1 ? Floor.GROUND : Floor.FIRST);
            name = new Classname(teach.getKlasse(), Integer.parseInt(teach.getKlasse().charAt(0)+""), teach.getSchueler());

            room.setClassname(name);
            name.setClassTeacher(teacher);
            name.setRoom(room);
            teacher.setClassname(name);
            em.persist(teacher);
        }

        em.getTransaction().commit();
    }

    public static void main(String[] args) {
        DataHandler dh = new DataHandler();
        dh.open();
        dh.importTables();

        System.out.println("Test Queries: \n\n");
        System.out.println("1) Room findByClassname");
        System.out.println("2) Room findAll");
        System.out.println("3) Room findByFloor");
        System.out.println("4) Room CountAll");

        System.out.println("5) Classname findByClassname");
        System.out.println("6) Classname findAll");
        System.out.println("7) Classname findByFloor");
        System.out.println("8) Classname CountAll");

        System.out.println("9) ClassTeacher findByClassname");
        System.out.println("10) ClassTeacher findAll");
        System.out.println("11) ClassTeacher findByGrade");
        System.out.println("12) ClassTeacher CountAll");

        System.out.println("13) Quit");

        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        switch(option) {
            case "1":
                TypedQuery<Room> nameQuery = em.createNamedQuery("Room.findByClassName", Room.class);
                System.out.println("Classname: ");
                String classname = sc.next().trim();
                nameQuery.setParameter("classname", classname);
                List<Room> roomsByClassname = nameQuery.getResultList();
                for (Room r: roomsByClassname) {
                    System.out.println(r);
                }
                break;
            case "2":
                TypedQuery<Room> nameQuery1 = em.createNamedQuery("Room.findAll", Room.class);
                List<Room> allRooms = nameQuery1.getResultList();

                allRooms.forEach(System.out::println);
        }


        dh.close();
    }
}
