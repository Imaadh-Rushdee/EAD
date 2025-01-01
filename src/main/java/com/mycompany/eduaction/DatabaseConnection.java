package com.mycompany.eduaction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


//import com.sun.jdi.connect.spi.Connection;

import java.sql.*;
import java.sql.PreparedStatement;
import java.time.LocalDate;
/**
 *
 * @author Imaadh
 */
public class DatabaseConnection {
    
    private  String url = "jdbc:mysql://localhost:3306/education";
    private  String username = "root";
    private  String password = "";
    private Connection cn;
    private ResultSet rst;
    private PreparedStatement pst;
    private int ist;
    
    /**
     *
     */
    public void getConnection()
        {
            try
            {
                Connection con = DriverManager.getConnection(url,username,password);
                this.cn = con;
                
                
            }
            catch(SQLException se)
            {
                
            }
        }
    public ResultSet getStatement(String query)
        {
            try
            {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                this.rst = rs;
                
            }
            catch(SQLException se)
            {
                
            }
            return rst;
        }
    public int getStatementUpdate(String query)
    {
        try
            {
                Statement st = cn.createStatement();
                int rs = st.executeUpdate(query);
                this.ist = rs;
                
            }
            catch(SQLException se)
            {
                
            }
     return ist;
    }
    public void getTableDataStudent(StudentManagement st1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT student_name, student_adress, student_age, student_password, student_id FROM student");
        while(st.next())
        {
            st1.tab().setValueAt(st.getInt("student_id"), i, 0);
            st1.tab().setValueAt(st.getString("student_name"), i, 1);
            st1.tab().setValueAt(st.getString("student_adress"), i, 2);
            st1.tab().setValueAt( String.valueOf(st.getInt("student_age")), i, 3);
            st1.tab().setValueAt(st.getString("student_password"), i, 4);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
        public void getTableDataStudentss(StudentManagement st1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("select student_id from student getLastRecord ORDER BY student_id DESC LIMIT 1");
        while(st.next())
        {
            int d = st.getInt("student_id");
            st1.iddd().setText(String.valueOf(d+1));
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
    public ResultSet checkAttendance(AttendanceManagement st1)
    {   ResultSet st = null;
        String course = st1.getCombo2().getSelectedItem().toString();
        LocalDate date = LocalDate.now();
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        st = getStudent.getStatement("select attendance_id from attendance where course_id = '"+course+"' and date= '"+date+"'");
        
        }
        catch(Exception se)
        {
        }
        
        return st;
    }
    public void getTableDataCoursess(CourseManagement st1)
    {   
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("select course_id from course getLastRecord ORDER BY course_id DESC LIMIT 1");
        while(st.next())
        {
            int d = st.getInt("course_id");
            st1.id().setText(String.valueOf(d+1));
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getTableDataAttendID(Attendance st1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("select attendance_id from attendance getLastRecord ORDER BY attendance_id DESC LIMIT 1");
        while(st.next())
        {
            int d = st.getInt("attendance_id");
            st1.setAttendanceId(d+1);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getTableDataResultD(Result st1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("select result_id from result getLastRecord ORDER BY result_id DESC LIMIT 1");
        while(st.next())
        {
            int d = st.getInt("result_id");
            st1.setResultId(d+1);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getTableDataCsID(studentCourseEnroll st1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("select csid from course_student getLastRecord ORDER BY csid DESC LIMIT 1");
        while(st.next())
        {
            int d = st.getInt("csid");
            st1.setCSID(d+1);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getTableUserID(UserManagement st1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("select user_id from user getLastRecord ORDER BY user_id DESC LIMIT 1");
        while(st.next())
        {
            int d = st.getInt("user_id");
            st1.setID().setText((String.valueOf(d+1)));
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
        
    public void getTableDataAttendance(AttendanceManagement at1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        String course = at1.getCombo().getSelectedItem().toString();
        ResultSet st = getStudent.getStatement("SELECT course_name, date, student_name, status FROM student, attendance, course where attendance.course_id = course.course_name and student.student_id = attendance.student_id");
        while(st.next())
        {
            at1.getTable().setValueAt(st.getString("student_name"), i, 0);
            at1.getTable().setValueAt(st.getString("course_name"), i, 1);
            at1.getTable().setValueAt(st.getString("date"), i, 2);
            at1.getTable().setValueAt(st.getString("status"), i, 3);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getTableDatResult(ResultManagement at1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        String course = at1.getCombo().getSelectedItem().toString();
        ResultSet st = getStudent.getStatement("SELECT course_name, student_name, course_result FROM student, result, course where result.course_id = course.course_name and student.student_id = result.student_id");
        while(st.next())
        {
            at1.getTable().setValueAt(st.getString("student_name"), i, 0);
            at1.getTable().setValueAt(st.getString("course_name"), i, 1);
            at1.getTable().setValueAt(st.getString("course_result"), i, 2);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getTableDataAttendanceSearch(AttendanceManagement at1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        String course = at1.getCombo().getSelectedItem().toString();
        ResultSet st = getStudent.getStatement("SELECT  course_name, date, student_name, status FROM student, attendance, course where attendance.course_id = course.course_name and student.student_id = attendance.student_id and course_name = '"+course+"'");
        while(st.next())
        {
            at1.getTable().setValueAt(st.getString("student_name"), i, 0);
            at1.getTable().setValueAt(st.getString("course_name"), i, 1);
            at1.getTable().setValueAt(st.getString("date"), i, 2);
            at1.getTable().setValueAt(st.getString("status"), i, 3);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getTableDataResultSearch(ResultManagement at1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        String course = at1.getCombo3().getSelectedItem().toString();
        ResultSet st = getStudent.getStatement("SELECT  course_name, student_name, course_result FROM student, result, course where result.course_id = course.course_name and student.student_id = result.student_id and course_name = '"+course+"'");
        while(st.next())
        {
            at1.getTable().setValueAt(st.getString("student_name"), i, 0);
            at1.getTable().setValueAt(st.getString("course_name"), i, 1);
            at1.getTable().setValueAt(st.getString("course_result"), i, 2);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getTableDataAddAttendance(AttendanceManagement at1)
    {
        int i=0;
        try{
        String  course = at1.getCombo2().getSelectedItem().toString();
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT DISTINCT student_name, student.student_id FROM student, course_student, course where course.course_name = '"+course+"' and course_student.student_id = student.student_id and course.course_id =course_student.course_id");
        while(st.next())
        {
            at1.getTable1().setValueAt(st.getString("student_id"), i, 0);
            at1.getTable1().setValueAt(st.getString("student_name"), i, 1);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
        
    }   
        public void getTableDataAddResult(ResultManagement at1)
    {
        int i=0;
        try{
        String  course = at1.getCombo2().getSelectedItem().toString();
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT DISTINCT student_name, student.student_id FROM student, course_student, course where course.course_name = '"+course+"' and course_student.student_id = student.student_id and course.course_id =course_student.course_id");
        while(st.next())
        {
            at1.getTable1().setValueAt(st.getString("student_id"), i, 0);
            at1.getTable1().setValueAt(st.getString("student_name"), i, 1);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
        
    }
    public void getTableDataCourse(CourseManagement cm1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT DISTINCT * FROM course");
        while(st.next())
        {
            cm1.tab().setValueAt(st.getInt("course_id"), i, 0);
            cm1.tab().setValueAt(st.getString("course_name"), i, 1);
            cm1.tab().setValueAt(st.getString("course_category"), i, 2);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getUserData(UserManagement cm1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT DISTINCT * FROM user");
        while(st.next())
        {
            cm1.tab().setValueAt(st.getInt("user_id"), i, 0);
            cm1.tab().setValueAt(st.getString("user_name"), i, 1);
            cm1.tab().setValueAt(st.getString("user_type"), i, 2);
            cm1.tab().setValueAt(st.getString("user_password"), i, 3);
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }

    public void getCourseName(AttendanceManagement am1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT DISTINCT course_name FROM course");
        while(st.next())
        {
            am1.getCombo().addItem(st.getString("course_name").toString());
            am1.getCombo2().addItem(st.getString("course_name").toString());
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getCourseNameR(ResultManagement am1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT DISTINCT course_name FROM course");
        while(st.next())
        {
            am1.getCombo2().addItem(st.getString("course_name").toString());
            am1.getCombo3().addItem(st.getString("course_name").toString());
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getCourseNameSC(student_course_enroll am1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT DISTINCT course_name FROM course");
        while(st.next())
        {
            am1.couc().addItem(st.getString("course_name").toString());
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getCourseNameSC1(student_course_enroll am1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT DISTINCT student_name FROM student");
        while(st.next())
        {
            am1.stdc().addItem(st.getString("student_name").toString());
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void getSTdid(student_course_enroll st1)
    {
        int i=0;
        try{
            
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("select student_id from student getLastRecord where student_name = '"+st1.stdc().getSelectedItem().toString()+"' ORDER BY student_id DESC LIMIT 1");
        while(st.next())
        {
            st1.sn().setText(String.valueOf(st.getInt("student_id")));
        }   
        }
        catch(Exception se)
        {
        }
    }
    public void LoginUser(Login st1)
    {
        int i=0;
        try{
            
        String name = st1.name().getText();
        String pass = st1.pass().getText().toString();
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("select user_type from user where user_name = 'Imaadh' and user_password = 'ok' ORDER BY user_id DESC LIMIT 1");
        while(st.next())
        {
            st1.getType(st.getString("user_type"));
            
            i++;
        }   
        }
        catch(Exception se)
        {
        }
    }    
}
