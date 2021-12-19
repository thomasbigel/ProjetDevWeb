package dao;

import beans.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDao {
    private final DaoFactory daoFactory;

    public UtilisateurDao(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public void ajouter(Utilisateur utilisateur){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO Utilisateur(login, `password`, nom, prenom, date_naissance, administrateur) VALUES(?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, utilisateur.getLogin());
            preparedStatement.setString(2, utilisateur.getPassword()); //A hasher plus tard
            preparedStatement.setString(3, utilisateur.getNom());
            preparedStatement.setString(4, utilisateur.getPrenom());
            preparedStatement.setString(5, utilisateur.getDate_naissance().toString());
            preparedStatement.setString(6, String.valueOf(utilisateur.isAdministrateur() ? 1 : 0));

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Echec insertion d'utilisateur, pas de ligne ajoutée");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    utilisateur.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Echec insertion d'utilisateur, pas d'id obetenu");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void supprimer(Utilisateur utilisateur) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM UTILISATEUR WHERE id=?;");
            preparedStatement.setString(1, String.valueOf(utilisateur.getId()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Utilisateur> getAll() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM Utilisateur;");

            while (resultat.next()) {
                int id = resultat.getInt("id");
                String login = resultat.getString("login");
                String password = resultat.getString("password");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                Date date_naissance = resultat.getDate("date_naissance");
                Boolean administrateur = resultat.getBoolean("administrateur");

                Utilisateur utilisateur = new Utilisateur(id, login, password, nom, prenom, date_naissance, administrateur);

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }
}