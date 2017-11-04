/*Copyright  © 2017 BUWANEKA DE SILVA

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files
(the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge,
publish, distribute, sublicense, and / or sell copies of the Software, and to permit persons to whom the Software is furnished to
do so, subject to the following conditions :The above copyright notice and this permission notice shall be included in all copies
or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/
package LM;

import java.sql.*;
import javax.swing.JOptionPane;


public class Student {
    private int ID;
    private String Name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public void InsertStudent(Student nwStd)
    {
        DBConnection db;
        Connection dbcon;
        
        try{
            db = new DBConnection();
            dbcon = db.connect();
            
            Statement stmt = dbcon.createStatement();
            stmt.executeUpdate("Insert into student values("+nwStd.getID()+",'"+nwStd.getName()+"')");            
            dbcon.close();
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage()+"\nInsert data unsuccessful!" );
        }
    }
    
    public void UpdateStudent(Student nwStd)
    {
        DBConnection db;
        Connection dbcon;
        
        try{
            db = new DBConnection();
            dbcon = db.connect();
            
            Statement stmt = dbcon.createStatement();
            stmt.executeUpdate("update student set sname='"+nwStd.getName()+"' WHERE sid='"+nwStd.getID()+"'");            
            dbcon.close();
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage()+"\nUpdate data unsuccessful!" );
        }
    }
    
    public void DeleteStudent(Student nwStd)
    {
        DBConnection db;
        Connection dbcon;
        
        try{
            db = new DBConnection();
            dbcon = db.connect();
            
            Statement stmt = dbcon.createStatement();
            stmt.executeUpdate("Delete from student WHERE sid='"+nwStd.getID()+"'");            
            dbcon.close();
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage()+"\nDelete data unsuccessful!" );
        }
    }
}