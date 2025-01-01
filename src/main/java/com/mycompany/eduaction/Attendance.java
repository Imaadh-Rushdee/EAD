package com.mycompany.eduaction;





import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Attendance {
    
    private String  course_id, attendance_status;
    private LocalDate date = LocalDate.now(); 
    private int attendance_id, student_id;
    
    public void setAttendanceId(int id)
    {
        this.attendance_id = id;
    }
    public void setCourseId(String id)
    {
        this.course_id = id;
    }
    public void setStudentId(int id)
    {
        this.student_id = id;
    }
    public void setStatus(String status)
    {
        this.attendance_status = status;
    }
    public void setDate(LocalDate date)
    {
        this.date = date;
    }
    public int getAttendanceId()
    {
        return attendance_id;
    }
    public String getCourseId()
    {
        return course_id;
    }
    public int getStudentId()
    {
        return student_id;
    }
    public String getStatus()
    {
        return attendance_status;
    }
    public LocalDate getDate()
    {
        return date;
    }
    
    public void getAttendance()
    {   ResultSet st = null;
        try
        {
        DatabaseConnection getAttendance = new DatabaseConnection();
        getAttendance.getConnection();
        st = getAttendance.getStatement("SELECT * FROM attendance");
        while(st.next())
        {
        this.attendance_id = st.getInt("attendance_id");
        this.student_id = st.getInt("student_id");
        this.course_id = st.getString("course_id");
        
        this.attendance_status = st.getString("status");
        }
        }
        catch(SQLException se)
        {
            
        } 
    }
    public void getCourseIdTable(String course)
    {
        try
        {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        ResultSet st = db.getStatement("Select course_id from course where course_name = 'Software'");
        this.course_id  = st.getString("course_id");
        
        }
        catch(Exception e)
        {
        }
    }
    public void addAttendance(AttendanceManagement at1)
    {
        int i = 0;
        while(at1.getTable1().getValueAt(i, 0)!=null)
        {
        this.setCourseId(at1.getCombo2().getSelectedItem().toString());
        this.setStatus(at1.getTable1().getValueAt(i, 2).toString());
        this.setStudentId(Integer.parseInt(at1.getTable1().getValueAt(i, 0).toString()));
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getTableDataAttendID(this);
        this.date = LocalDate.now();
        
        db.getStatementUpdate(" insert into attendance(attendance_id, student_id, course_id, date, status) values('"+attendance_id+"','"+student_id+"','"+course_id+"','"+date+"','"+attendance_status+"')");
        i++;
        
        }    
    }
    
    public void updateAttendance()
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("UPDATE attendance SET attendance_id = '"+attendance_id+"', student_id = '"+student_id+"', course_id = '"+course_id+"', date = '"+date+"', status = '"+attendance_status+"' WHERE attendance_id = '"+attendance_id+"'");    
    
    }
    
    public void deleteAttendance()
    {   
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("DELETE FROM attendance WHERE attendance_id = '"+attendance_id+"'");
   
    }
}
