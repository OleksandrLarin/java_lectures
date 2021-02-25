package lecture22.jdbc;

import lecture22.jdbc.dao.StudentDao;
import lecture22.jdbc.model.Student;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        DBConnector dbConnector = new DBConnector();
        TableFactory.createStudentTable(dbConnector);

        Student student = buildStudent();

//        DataProvider.insertStudent(dbConnector, student);

        StudentDao studentDao = new StudentDao(dbConnector);
        student.setId(5);
        boolean isUpdated = studentDao.updateStudent(student);
        List<Student> studentList = studentDao.getAll();

        System.out.println("Student info was update: " + isUpdated);
        System.out.println(studentList);

        dbConnector.close();
    }

    private static Student buildStudent() {
        Student student = new Student();
        student.setFirstName("Petya");
        student.setLastName("Ivanov");
        student.setDateOfBirth(LocalDate.now().minusYears(20));
        return student;
    }
}
