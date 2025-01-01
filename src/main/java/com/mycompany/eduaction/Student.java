package com.mycompany.eduaction;



import java.sql.*;

public class Student {
        
    private String student_name, student_adress, student_password; 
    private String student_age;
    private int  student_id;
    public void setName(String name)
    {
        this.student_name = name;
    }
    public void setPassword(String password)
    {
        this.student_password = password;
    }
    public void setId(int id)
    {
        this.student_id = id;
    }
    public void setAge(String age)
    {
        this.student_age = age;
    }
    public void setAdress(String adress)
    {
        this.student_adress = adress;
    }
    public String getName()
    {
        return student_name;
    }
    public String getPassword()
    {
        return student_password;
    }
    public int getId()
    {
        return student_id;
    }
    
    public String getAdress()
    {
        return student_adress;
    }
    public String getAge()
    {
        return student_age;
    }
    public ResultSet getAllStudent()
    {
        ResultSet rrst = null;
        try
        {
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT * FROM student");
        rrst = st;
        while(st.next())
        {
        this.student_id = st.getInt("student_id");
        this.student_name = st.getString("student_name");
        this.student_adress = st.getString("student_adress");
        this.student_password = st.getString("student_password");
        this.student_age = String.valueOf(st.getInt("student_age"));
        }
        }
        catch(SQLException se)
        {
            
        }
        return rrst;
    }
    public ResultSet getStudent()
    {
        ResultSet rrst = null;
        try
        {
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT * FROM student WHERE student_id = '"+student_id+"'");
        rrst = st;
        while(st.next())
        {
        this.student_id = st.getInt("student_id");
        this.student_name = st.getString("student_name");
        this.student_adress = st.getString("student_adress");
        this.student_password = st.getString("student_password");
        this.student_age = String.valueOf(st.getInt("student_age"));
        }
        }
        catch(SQLException se)
        {
            
        }
        return rrst;
    }
    
    public void addStudent()
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("INSERT INTO student(student_id, student_name, student_adress, student_password, student_age) values('"+student_id+"','"+student_name+"','"+student_adress+"','"+student_password+"','"+student_age+"')");
    }
    
    public void updateStudent()
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("UPDATE student SET student_id = '"+student_id+"', student_name = '"+student_name+"', student_adress = '"+student_adress+"', student_password = '"+student_password+"', student_age = '"+student_age+"' WHERE student_id = '"+student_id+"'");    
    }
    
    public void deleteStudent()
    {
        
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("DELETE FROM student WHERE student_id = '"+student_id+"'");
         
    }
    
    
}
