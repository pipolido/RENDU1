import java.sql.*;  


public class JDBCExample {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/rendu01";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public void selectUser(){
        String selectSql= "select * from users";

        try(Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectSql)) {
            while(resultSet.next()){
                int id = resultSet.getInt("id_user");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String type = resultSet.getString("type");
                System.out.printf("ID:%d , Nom:%s , Prenom:%s , Email:%s , Type:%s%n", id, nom, prenom, email, type);
            }
        } catch(SQLException e){
            System.out.println("Erreur(Select)!");
            e.printStackTrace();
        }
    }

    public void insertUser(String nom,String prenom,String email,String type){
        String insertSql = "insert into users (nom,prenom,email,type) values(?,?,?,?)";
        try(Connection connection=getConnection();
        PreparedStatement ps = connection.prepareStatement(insertSql)) {
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setString(3,email);
            ps.setString(4,type);
            int rowsAffected = ps.executeUpdate();

            System.out.println(rowsAffected + "row affected");
        } catch(SQLException e){
            System.out.println("Erreur(Insert)!");
            e.printStackTrace();
        }
    }

    public void updateUser(int id,String novNom,String novPrenom,String novEmail,String novType){
        String updateSql = "update users set nom = ?,prenom = ? , email=?,type=? where id_user = ?";
        try(Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(updateSql)) {
            
            ps.setString(1,novNom);
            ps.setString(2,novPrenom);
            ps.setString(3,novEmail);
            ps.setString(4,novType);
            ps.setInt(5,id);
            int rowsAffected = ps.executeUpdate();

            System.out.println(rowsAffected + "row updated");

        } catch(SQLException e){
            System.out.println("Erreur(Update)!");
            e.printStackTrace();
        }
    }

    public void deleteUser(int id ){
        String deleteSql = "delete from users where id_user = ?";
        try(Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(deleteSql)) {
            ps.setInt(1,id);
            int rowsAffected = ps.executeUpdate();

            System.out.println(rowsAffected + "row deleted");

        } catch (SQLException e){
            System.out.println("Erreur(Delete)!");
            e.printStackTrace();
        }
    }

    public void selectEvents() {
        String sql = "SELECT * FROM events";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Events:");
            while (resultSet.next()) {
                System.out.printf("ID: %d, Name: %s, Date: %s, Description: %s, User ID: %d%n",
                        resultSet.getInt("id_event"),
                        resultSet.getString("nom_event"),
                        resultSet.getTimestamp("date_event"),
                        resultSet.getString("description"),
                        resultSet.getInt("id_user"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertEvent(String nomEvent, String description, int idUser) {
        String sql = "INSERT INTO events (nom_event, description, id_user) VALUES ( ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nomEvent);
            ps.setString(2, description);
            ps.setInt(3, idUser);
            ps.executeUpdate();
            System.out.println("Event inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEvent(int id, String nomEvent, String description, int idUser) {
        String sql = "UPDATE events SET nom_event = ?, description = ?, id_user = ? WHERE id_event = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nomEvent);
            ps.setString(2, description);
            ps.setInt(3, idUser);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Event updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(int id) {
        String sql = "DELETE FROM events WHERE id_event = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Event deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void selectReservations() {
        String sql = "SELECT * FROM reservation";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Reservations:");
            while (resultSet.next()) {
                System.out.printf("ID: %d, User ID: %d, Event ID: %d, Salle ID: %d, Terrain ID: %d, Date: %s%n",
                        resultSet.getInt("id_reservation"),
                        resultSet.getInt("id_user"),
                        resultSet.getInt("id_event"),
                        resultSet.getInt("id_salle"),
                        resultSet.getInt("id_terrain"),
                        resultSet.getTimestamp("date_reservation"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertReservation(int idUser, int idEvent, int idSalle, int idTerrain,String date_reservation) {
        String sql = "INSERT INTO reservation (id_user, id_event, id_salle, id_terrain,date_reservation) VALUES (?, ?, ?, ? ,? )";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idUser);
            ps.setInt(2, idEvent);
            ps.setInt(3, idSalle);
            ps.setInt(4, idTerrain);
            ps.setString(5, date_reservation);
            
            ps.executeUpdate();
            System.out.println("Reservation inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReservation(int id, int idUser, int idEvent, int idSalle, int idTerrain) {
        String sql = "UPDATE reservation SET id_user = ?, id_event = ?, id_salle = ?, id_terrain = ? WHERE id_reservation = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idUser);
            ps.setInt(2, idEvent);
            ps.setInt(3, idSalle);
            ps.setInt(4, idTerrain);
            ps.setInt(6, id);
            ps.executeUpdate();
            System.out.println("Reservation updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReservation(int id) {
        String sql = "DELETE FROM reservation WHERE id_reservation = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Reservation deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void selectSalles() {
        String sql = "SELECT * FROM salles";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Salles:");
            while (resultSet.next()) {
                System.out.printf("ID: %d, Nom: %s, Capacite: %d%n",
                        resultSet.getInt("id_salle"),
                        resultSet.getString("nom_salle"),
                        resultSet.getInt("capacite"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSalle(String nomSalle, int capacite) {
        String sql = "INSERT INTO salles (nom_salle, capacite) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nomSalle);
            ps.setInt(2, capacite);
            ps.executeUpdate();
            System.out.println("Salle inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSalle(int id, String nomSalle, int capacite) {
        String sql = "UPDATE salles SET nom_salle = ?, capacite = ? WHERE id_salle = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nomSalle);
            ps.setInt(2, capacite);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Salle updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSalle(int id) {
        String sql = "DELETE FROM salles WHERE id_salle = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Salle deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void selectTerrains() {
        String sql = "SELECT * FROM terrains";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Terrains:");
            while (resultSet.next()) {
                System.out.printf("ID: %d, Nom: %s, type: %s%n",
                        resultSet.getInt("id_terrain"),
                        resultSet.getString("nom_terrain"),
                        resultSet.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTerrain(String nomTerrain, String type) {
        String sql = "INSERT INTO terrains (nom_terrain, type) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nomTerrain);
            ps.setString(2, type);
            ps.executeUpdate();
            System.out.println("Terrain inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTerrain(int id, String nomTerrain, String type) {
        String sql = "UPDATE terrains SET nom_terrain = ?, type = ? WHERE id_terrain = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nomTerrain);
            ps.setString(2, type);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Terrain updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTerrain(int id) {
        String sql = "DELETE FROM terrains WHERE id_terrain = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Terrain deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 
}