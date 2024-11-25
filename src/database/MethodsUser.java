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
 * @author mauro
 */
public class MethodsUser {

    private Connection con;
    int id = 0, type_id;
    String name, last_name, username, email, password, phone, age_range, city, targeted_gender;
    int admin_id;

    Conection conex = new Conection();
    PreparedStatement stmt;
    ResultSet rs;
    private String nunsort;
    private String phone_nunber;
    private String brinde;
    private String phone_number;
    
 
// CONSULTID
    public int consultID(String email) {

        this.email = email;
        String clave = "";

        try {
            con = conex.getConnection();
            stmt = con.prepareStatement("SELECT id FROM user WHERE email=?");
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                clave = rs.getString("id");
                JOptionPane.showMessageDialog(null, "O id é:" + clave);
                id = Integer.parseInt(clave);

            } else {
                JOptionPane.showMessageDialog(null, "Não existe uma pessoa com esse e-mail");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
        }
        return id;
    }// FIM CONSULTID
// TOTAL ID
    public int totalID(String id) {
        int total = 0; // Variável para contar o número total de IDs

        try {
            con = conex.getConnection();
            stmt = con.prepareStatement("SELECT count(*) AS total FROM contact");
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                total = rs.getInt("total"); // Obtem o total
                JOptionPane.showMessageDialog(null, "Existem " + total + " Participantes");
            } else {
                JOptionPane.showMessageDialog(null, "Não existe uma pessoa com esse ID");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        } finally {
            // Fechar recursos, se necessário
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return total; // Retorna o total
    }// FIM TOTAL ID
// UPDATE
    public void update(int id, String name, String last_name, String email, String phone, String numsort, String brinde1, int admin_id) {

        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.admin_id = admin_id;

        try {
            con = conex.getConnection();
            stmt = con.prepareStatement("UPDATE contact SET name=?, last_name=?, email=?, phone_number=? where id=? and admin_id=?");
            stmt.setString(1, name);
            stmt.setString(2, last_name);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setInt(5, id);
            stmt.setInt(6, admin_id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario atualizado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
        }
    }// FIM UPDATE
// LOGIN
    public boolean login(String email, String password) {

        try {
            con = conex.getConnection();
            stmt = con.prepareStatement("SELECT email, password FROM admin WHERE email=? AND password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                this.email = rs.getString("email");
                this.password = rs.getString("password");
                JOptionPane.showMessageDialog(null, "BEM-VINDO AO SISTEMA");
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "Não há ninguém com esse e-mail");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return false;
        }
    }// FIM LOGIN
// GETID
    public int getId(String email, String password) {
        try {
            con = conex.getConnection();
            stmt = con.prepareStatement("SELECT id FROM admin WHERE email=? AND password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
//                int adminId = rs.getInt("id");
                int adminId = 1;
                return adminId;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return 0;
        }
        return 0;
    }// FIM GETID
// REGISTER
    public boolean register(String name, String last_name, String username, String email, String password) {

        this.name = name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;

        try {
            con = conex.getConnection();
            stmt = con.prepareStatement("INSERT INTO admin (name,last_name,username,email,password) VALUES (?,?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, last_name);
            stmt.setString(3, username);
            stmt.setString(4, email);
            stmt.setString(5, password);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "O usuário foi adicionado com sucesso");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return false;
        }
    }// FIM REGISTER
// GETNAME
    public String getName(String email, String password) {
        try {
            con = conex.getConnection();
            stmt = con.prepareStatement("SELECT name FROM admin WHERE email=? AND password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                String adminName = rs.getString("name");
                return adminName;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return null;
        }
        return null;
    }// FIM GETNAME
// ADDCONTACT
    public boolean addContact(String name, String last_name, String email, String phone, int admin_id) {

        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.admin_id = admin_id;

        try {
            con = conex.getConnection();
            stmt = con.prepareStatement("INSERT INTO contact (name,last_name,email,phone_number, admin_id) VALUES (?,?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, last_name);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setInt(5, admin_id);
            stmt.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return false;
        }
    }// FIM ADDCONTACT
// ADDPROD
    public boolean addProd(String name, String age_range, String city, String targeted_gender, int admin_id) {

        this.name = name;
        this.age_range = age_range;
        this.city = city;
        this.targeted_gender = targeted_gender;
        this.admin_id = admin_id;

        try {
            con = conex.getConnection();
            stmt = con.prepareStatement("INSERT INTO produtos (name,age_range,city,targeted_gender, admin_id) VALUES (?,?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, age_range);
            stmt.setString(3, city);
            stmt.setString(4, targeted_gender);
            stmt.setInt(5, admin_id);
            stmt.executeUpdate();

//            JOptionPane.showMessageDialog(null, "Produto adicionado");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return false;
        }
    }// FIM ADDPROD

// ALLCONTACTS
    public List<String> allContacts(int adminId) {
        List<String> contactDetailsList = new ArrayList<>();
        try {
            this.admin_id = adminId;
            con = conex.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT name, last_name, email, phone_number FROM contact WHERE admin_id=?");
            stmt.setInt(1, admin_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");

                String contactDetails = name + "\n" + lastName + "\n" + email + "\n" + phoneNumber + "\n";
                contactDetailsList.add(contactDetails);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return contactDetailsList;
    }// FIM ALLCONTACTS
// DELETECOMTACT
    public boolean deleteContact(String email, int admin_id) {
        try {
            this.email = email;
            this.admin_id = admin_id;
            con = conex.getConnection();
            stmt = con.prepareStatement("DELETE FROM contact WHERE email=? and admin_id=?");
            stmt.setString(1, email);
            stmt.setInt(2, admin_id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário excluído");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return false;
        }
    }// FIM DELETECOMTACT
// ONE CONTACT
    public List<String> oneContact(String email, int admin_id) {
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

                String contactDetails = name + "\n" + lastName + "\n" + emailC + "\n" + phoneNumber + "\n";
                contactDetailsList.add(contactDetails);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return contactDetailsList;
    }// FIM ONE CONTACT
// ALLCONTACTUPDATE
    public List<String> allContactsUpdate(int adminId) {
        List<String> contactDetailsList = new ArrayList<>();
        try {
            this.admin_id = adminId;
            con = conex.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT id, name, last_name, email, phone_number FROM contact WHERE admin_id=?");
            stmt.setInt(1, admin_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");

                String contactDetails = id + "\n" + name + "\n" + lastName + "\n" + email + "\n" + phoneNumber + "\n";
                contactDetailsList.add(contactDetails);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return contactDetailsList;
    }// FIM ALLCONTACTUPDATE
// GETUPDATE
    public List<String> getUpdate(int id, int admin_id) {
        List<String> contactDetailsList = new ArrayList<>();
        try {
            this.id = id;
            this.admin_id = admin_id;

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
                    con.close();
                }
            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return contactDetailsList;
    }// FIM GETUPDATE
// UPDATEVENCEDOR
    public boolean updateVencedor(String name, String last_name, String phone_number, String email, String brinde, String nunsort, int admin_id) {

        this.name = name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.brinde = brinde;
        this.nunsort = nunsort;
        this.admin_id = admin_id;

        try {
            con = conex.getConnection();
            stmt = con.prepareStatement("INSERT INTO ganhadores (name,last_name,phone_number,email,brinde,nunsort,admin_id) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, last_name);
            stmt.setString(3, phone_number);
            stmt.setString(4, email);
            stmt.setString(5, brinde);
            stmt.setString(6, nunsort);
            stmt.setInt(7, admin_id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:" + e.getMessage());
            return false;
        }
    }// FIM UPDATEVENCEDOR
// CONSULTA GANHADORES
    public List<String> allWinner(int adminId) {
        List<String> winnerDetailsList = new ArrayList<>();
        try {
            this.admin_id = adminId;
            con = conex.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT name, last_name, phone_number, email, brinde, nunsort, created_at FROM ganhadores WHERE admin_id=? ORDER BY created_at DESC");
            stmt.setInt(1, admin_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("name");
                String sobrenome = rs.getString("last_name");
                String telefone = rs.getString("phone_number");
                String email = rs.getString("email");
                String brinde = rs.getString("brinde");
                String n_sorteado = rs.getString("nunsort");
                String sort_em = rs.getString("created_at");

                String contactDetails = nome + "\n" + sobrenome + "\n" + telefone + "\n" + email + "\n" + brinde + "\n" + n_sorteado + "\n" + sort_em + "\n";
                winnerDetailsList.add(contactDetails);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }

        return winnerDetailsList;
    }// FIMCONSULTA GANHADORES

}
