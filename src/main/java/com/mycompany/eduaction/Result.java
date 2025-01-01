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
public class Result {
    
    private String course_id, student_id, test_type;
    private int result_id, course_result;
   
    public void setResultId(int id)
    {
        this.result_id = id;
    }
    public void setCourseId(String id)
    {
        this.course_id = id;
    }
    public void setStudentId(String id)
    {
        this.student_id = id;
    }
    public void setResult(int result)
    {
        this.course_result = result;
    }
    public void setTest(String test)
    {
        this.test_type = test;
    }
    public int getResultId()
    {
        return result_id;
    }
    public String getCourseId()
    {
        return course_id;
    }
    public String getStudentId()
    {
        return student_id;
    }
    public int getResult()
    {
        return course_result;
    }
    public String getTest()
    {
        return test_type;
    }
    
    public void getCResult()
    {
        try
        {
        DatabaseConnection getCResult = new DatabaseConnection();
        getCResult.getConnection();
        ResultSet st = getCResult.getStatement("SELECT * FROM result");
        while(st.next())
        {
        this.result_id = st.getInt("result_id");
        this.course_result = st.getInt("course_result");
        this.student_id = st.getString("student_id");
        this.course_id = st.getString("course_id");
        this.test_type = st.getString("test_type");
        }
        }
        catch(SQLException se)
        {
            
        }
                
    }
    
    public void addResult(ResultManagement at1)
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        int i = 0;
        while(at1.getTable1().getValueAt(i, 0)!=null)
        {
        this.setCourseId(at1.getCombo2().getSelectedItem().toString());
        this.setTest(at1.getCombo().getSelectedItem().toString());
        this.setResult(Integer.parseInt(at1.getTable1().getValueAt(i, 2).toString()));
        this.setStudentId(at1.getTable1().getValueAt(i, 0).toString());
        db.getTableDataResultD(this);
        db.getStatementUpdate("INSERT INTO result(result_id, course_result, student_id, course_id, test_type) values('"+result_id+"','"+course_result+"','"+student_id+"','"+course_id+"','"+test_type+"')");
        i++;
        }    
    }
    
    public void updateResult()
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("UPDATE result SET result_id = '"+result_id+"', course_result = '"+course_result+"', student_id = '"+student_id+"', course_id = '"+course_id+"', test_type = '"+test_type+"' WHERE result_id = '"+result_id+"'");    
         
    }
    
    public void deleteResult()
    {   
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("DELETE FROM result WHERE result_id = '"+result_id+"'");    
    }
}
