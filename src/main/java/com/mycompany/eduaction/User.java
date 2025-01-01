package com.mycompany.eduaction;




import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class User {
    
    private String  user_type, user_name, user_password;
    private int  user_id;

    public void setID(int id)
    {
        this.user_id = id;
    }
    public void setName(String name)
    {
        this.user_name = name;
    }
    public void setPassword(String password)
    {
        this.user_password = password;
    }
    public void setType(String type)
    {
        this.user_type = type;
    }
    public int getID()
    {
        return user_id;
    }
    public String getName()
    {
        return user_name;
    }
    public String getPassword()
    {
        return user_password;
    }
    public String getType()
    {
        return user_type;
    }
    
    public void getAUser()
    {
        try
        {
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT * FROM user WHERE user_name='"+user_name+"' AND user_password = '"+user_password+"'");
        while(st.next())
        {
        this.user_id = st.getInt("user_id");
        this.user_name = st.getString("user_name");
        this.user_type = st.getString("user_type");
        this.user_password = st.getString("user_password");
        }
        }
        catch(SQLException se)
        {
            
        }
                
    }
    public void setUserID(UserManagement u1)
    {
        try
        {
        DatabaseConnection getStudent = new DatabaseConnection();
        getStudent.getConnection();
        ResultSet st = getStudent.getStatement("SELECT max(user_id) FROM user");
        while(st.next())
        {
        int id = st.getInt("user_id");
        this.user_id = id + 1;
            JOptionPane.showMessageDialog(u1, id);
        }
        }
        catch(SQLException se)
        {
            
        }
    }
    public void addUser()
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("INSERT INTO user(user_id, user_name, user_type, user_password) values('"+user_id+"','"+user_name+"','"+user_type+"','"+user_password+"')");
    
                
    }
    
    public void updateUser()
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("UPDATE user SET user_id = '"+user_id+"', user_name = '"+user_name+"', user_type = '"+user_type+"', user_password = '"+user_password+"' WHERE user_id = '"+user_id+"'");    
                
    }
    
    public void deleteUser()
    {
        
        DatabaseConnection db = new DatabaseConnection();
        db.getConnection();
        db.getStatementUpdate("DELETE FROM user WHERE user_id = '"+user_id+"'");
                
    }
}
