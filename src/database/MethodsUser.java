/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class MethodsUser {
    
    private Connection con;
    int id=0, type_id;
    String name,last_name, username, email, password, phone;
    int admin_id;
    
    Conection conex=new Conection();
    PreparedStatement stmt;
    ResultSet rs;
   
    public int consultID(String email){
        
        this.email=email;
        String clave="" ;
        
        try{
            con=conex.getConnection();
            stmt= con.prepareStatement("SELECT id FROM user WHERE email=?");
            stmt.setString(1,email);
            rs=stmt.executeQuery();
            
            if (rs.next()) {
            clave=rs.getString("id");
            JOptionPane.showMessageDialog(null, "El id es :" +clave);
            id=Integer.parseInt(clave);//valor para return
            
            } else {
            JOptionPane.showMessageDialog(null, "No existe una persona con ese correo");
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }       
        return id;
    }
    
    
    public void update(int id,String name, String last_name, String email, String phone, int admin_id){
        
        this.id=id;
        this.name=name;
        this.last_name=last_name;
        this.email=email;
        this.phone=phone;
        this.admin_id=admin_id;
        
        try{
            con=conex.getConnection();
            stmt= con.prepareStatement("UPDATE contact SET name=?, last_name=?, email=?, /*phone_number*/=? where id=? and admin_id=?");
            stmt.setString(1,name);
            stmt.setString(2,last_name);
            stmt.setString(3,email);
            stmt.setString(4,phone);
            stmt.setInt(5,id);
            stmt.setInt(6,admin_id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario actualizado");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
    public boolean login(String email,String password){
        
        try{
            con=conex.getConnection();
            stmt= con.prepareStatement("SELECT email, password FROM admin WHERE email=? AND password=?");
            stmt.setString(1,email);
            stmt.setString(2,password);
            rs=stmt.executeQuery();
            
            if (rs.next()) {
            this.email=rs.getString("email");
            this.password=rs.getString("password");
            JOptionPane.showMessageDialog(null,"BEM-VINDO AO SISTEMA");  
            return true;
            
            } else {
            JOptionPane.showMessageDialog(null, "Não há ninguém com esse e-mail");
            return false;
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return false;
        }       
    }
    
    public int getId(String email, String password){
        try{
            con=conex.getConnection();
            stmt= con.prepareStatement("SELECT id FROM admin WHERE email=? AND password=?");
            stmt.setString(1,email);
            stmt.setString(2,password);
            rs=stmt.executeQuery();
            if (rs.next()) {
                int adminId = rs.getInt("id");
                return adminId;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return 0;
        }
        return 0;
    } 
    
    public boolean register(String name,String last_name, String username, String email,String password){
        
        this.name=name;
        this.last_name=last_name;
        this.username=username;
        this.email=email;
        this.password=password;
        
        // INSERT INTO user (name, last_name, email,password, type_id) VALUES ('Carlos', 'Galindo', 'carlos@gmail.com', aes_encrypt('Carlos123', 'password'), 1);
        try{
            con=conex.getConnection();
            stmt= con.prepareStatement("INSERT INTO admin (name,last_name,username,email,password) VALUES (?,?,?,?,?)");
            stmt.setString(1,name);
            stmt.setString(2,last_name);
            stmt.setString(3,username);
            stmt.setString(4, email);
            stmt.setString(5, password);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "O usuário foi adicionado com sucesso");
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return false;
        }
    }
    
    public String getName(String email, String password){
        try{
            con=conex.getConnection();
            stmt= con.prepareStatement("SELECT name FROM admin WHERE email=? AND password=?");
            stmt.setString(1,email);
            stmt.setString(2,password);
            rs=stmt.executeQuery();
            if (rs.next()) {
                String adminName = rs.getString("name");
                return adminName;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return null;
        }
        return null;
    }

    public boolean addContact(String name,String last_name,String email,String phone, int admin_id){
        
        this.name=name;
        this.last_name=last_name;
        this.email=email;
        this.phone=phone;
        this.admin_id=admin_id;
        
        // INSERT INTO user (name, last_name, email,password, type_id) VALUES ('Carlos', 'Galindo', 'carlos@gmail.com', aes_encrypt('Carlos123', 'password'), 1);
        try{
            con=conex.getConnection();
            stmt= con.prepareStatement("INSERT INTO contact (name,last_name,email,phone_number, admin_id) VALUES (?,?,?,?,?)");
            stmt.setString(1,name);
            stmt.setString(2,last_name);
            stmt.setString(3,email);
            stmt.setString(4, phone);
            stmt.setInt(5, admin_id);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Foi adicionado ao contato");
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return false;
        }
    }    
    
    public List<String> allContacts(int adminId){
        List<String> contactDetailsList = new ArrayList<>();
        try {
            this.admin_id = adminId;
            con = conex.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT name, last_name, email, phone_number FROM contact WHERE admin_id=?");
            stmt.setInt(1, admin_id); // Corregir el índice del parámetro
            ResultSet rs = stmt.executeQuery(); // Ejecutar la consulta

            while (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");

                // Construir la cadena con los detalles del contacto y agregarla a la lista
                String contactDetails = name + "\n" + lastName + "\n" + email + "\n" + phoneNumber + "\n";
                contactDetailsList.add(contactDetails);
            }

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cerrar la conexión
                }
            } catch (SQLException e) {
                // Manejo de errores al cerrar la conexión
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return contactDetailsList; // Devolver la lista de detalles de los contactos
    }
    
    public boolean deleteContact(String email, int admin_id){        
        try{
            this.email=email;
            this.admin_id=admin_id;
            con=conex.getConnection();
            stmt= con.prepareStatement("DELETE FROM contact WHERE email=? and admin_id=?");
            stmt.setString(1,email);
            stmt.setInt(2, admin_id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário excluído");
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return false;
        }
    }
    
    public List<String> oneContact(String email, int admin_id){
        List<String> contactDetailsList = new ArrayList<>();
        try {
            this.email = email;
            this.admin_id = admin_id;

            con = conex.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT name, last_name, email, phone_number FROM contact WHERE email=? and admin_id=?");
            stmt.setString(1, email);
            stmt.setInt(2, admin_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String emailC = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");

                // Construir la cadena con los detalles del contacto y agregarla a la lista
                String contactDetails = name + "\n" + lastName + "\n" + emailC + "\n" + phoneNumber + "\n";
                contactDetailsList.add(contactDetails);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cerrar la conexión
                }
            } catch (SQLException e) {
                // Manejo de errores al cerrar la conexión
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return contactDetailsList;
    }
    
    public List<String> allContactsUpdate(int adminId){
        List<String> contactDetailsList = new ArrayList<>();
        try {
            this.admin_id = adminId;
            con = conex.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT id, name, last_name, email, phone_number FROM contact WHERE admin_id=?");
            stmt.setInt(1, admin_id); // Corregir el índice del parámetro
            ResultSet rs = stmt.executeQuery(); // Ejecutar la consulta

            while (rs.next()) {
                String id=rs.getString("id");
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");

                // Construir la cadena con los detalles del contacto y agregarla a la lista
                String contactDetails = id + "\n" + name + "\n" + lastName + "\n" + email + "\n" + phoneNumber + "\n";
                contactDetailsList.add(contactDetails);
            }

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cerrar la conexión
                }
            } catch (SQLException e) {
                // Manejo de errores al cerrar la conexión
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return contactDetailsList; // Devolver la lista de detalles de los contactos
    }
    
    public List<String> getUpdate(int id, int admin_id){
        List<String> contactDetailsList = new ArrayList<>();
        try {
            this.id=id;
            this.admin_id=admin_id;

            con = conex.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT name, last_name, email, phone_number FROM contact WHERE id=? and admin_id=?");
            stmt.setInt(1, id);
            stmt.setInt(2, admin_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String emailC = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");

                // Agregar cada valor individualmente a la lista
                contactDetailsList.add(name);
                contactDetailsList.add(lastName);
                contactDetailsList.add(emailC);
                contactDetailsList.add(phoneNumber);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close(); // Cerrar la conexión
                }
            } catch (SQLException e) {
                // Manejo de errores al cerrar la conexión
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return contactDetailsList;
    }    
}

