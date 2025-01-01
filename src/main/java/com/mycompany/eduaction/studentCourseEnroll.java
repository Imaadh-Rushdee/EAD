package com.mycompany.eduaction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Imaadh
 */
public class studentCourseEnroll {
    private int cs_id, student_id, course_id;
    
    public void setCSID(int id)
    {
        this.cs_id = id;
    }
    public void setstdID(int id)
    {
        this.student_id = id;
    }
    public void setCourID(int id)
    {
        this.course_id = id;
    }
    public int getCSID()
    {
        return cs_id;
    }
    public int getStdID()
    {
        return student_id;
    }
    public int getCouID()
    {
        return course_id;
    }
    public void addEnroll()
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getTableDataCsID(this);
        db.getStatementUpdate("Insert into course_student(csid, student_id, course_id) values('"+cs_id+"','"+student_id+"', '"+course_id+"')");
    }
    public void deleteEnroll()
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("delete from course_student where csid = '"+cs_id+"'");
    }
}
