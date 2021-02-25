package lecture22.jdbc.dao;

import lecture22.jdbc.DBConnector;
import lecture22.jdbc.model.Student;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static final String FIND_ALL = "Select * From student";
    private static final String UPDATE_STUDENT_BY_ID = "Update student " +
            "Set first_name = ? , last_name = ?, date_of_birth = ? " +
            "Where student_id = ?;";

    private final DBConnector dbConnector;

    public StudentDao(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public List<Student> getAll() {
        final ResultSet resultSet = dbConnector.executeQuery(FIND_ALL);

        return processResult(resultSet);
    }

    private List<Student> processResult(ResultSet resultSet) {
        List<Student> students = new ArrayList<>();

        try {
            while (resultSet.next()) {
                students.add(buildStudent(resultSet));
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return students;
    }

    private Student buildStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setFirstName(resultSet.getString("first_name"));
        student.setLastName(resultSet.getString("last_name"));
        student.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
        return student;
    }

    public boolean updateStudent(Student student) {
        final PreparedStatement preparedStatement = dbConnector.getPreparedStatement(UPDATE_STUDENT_BY_ID);
        try {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));
            preparedStatement.setInt(4, student.getId());

            return 1 == preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
