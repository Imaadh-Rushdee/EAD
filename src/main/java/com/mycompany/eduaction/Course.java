package com.mycompany.eduaction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Imaadh
 */
public class Course {
    
    private String  course_name, course_category;
    private int course_id;
    
    public void setName(String name)
    {
        this.course_name = name;
    }
    public void setId(int id)
    {
        this.course_id = id;
    }
    public void setCategory(String category)
    {
        this.course_category = category;
    }
    public String getName()
    {
        return course_name;
    }
    public int getId()
    {
        return course_id;
    }
    public String getCategory()
    {
        return course_category;
    }
    
    public ResultSet getCourse()
    {
        ResultSet st = null;
        try
        {
        DatabaseConnection getCourse = new DatabaseConnection();
        getCourse.getConnection();
        st = getCourse.getStatement("SELECT * FROM course");
        while(st.next())
        {
        this.course_id = st.getInt("course_id");
        this.course_name = st.getString("course_name");
        this.course_category = st.getString("course_category");
        }
        }
        catch(SQLException se)
        {
            
        }
        return st;
                
    }
    
    public void addCourse()
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("INSERT INTO course(course_id, course_name, course_category) values('"+course_id+"','"+course_name+"','"+course_category+"')");
        
    }
    
    public void updateCourse()
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("UPDATE course SET course_id = '"+course_id+"', course_name = '"+course_name+"', course_category = '"+course_category+"' WHERE course_id = '"+course_id+"'");    
          
    }
    
    public void deleteCourse()
    {   
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("DELETE FROM course WHERE course_id = '"+course_id+"'");
    
    }
    
}
