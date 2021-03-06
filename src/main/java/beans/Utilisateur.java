package beans;

import dao.DaoFactory;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    private int id;
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private String email;
    private Blob imageProfile = null;
    private boolean administrateur;
    private List<Integer> amis;

    public Utilisateur(int id, String login, String password, String nom, String prenom, Date date_naissance, boolean administrateur) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.email = null;
        this.administrateur = administrateur;
        this.amis = new ArrayList<>();
    }

    public Utilisateur(int id, String login, String nom, String prenom, Date date_naissance, boolean administrateur) {
        this.id = id;
        this.login = login;
        this.password = "";
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.email = null;
        this.administrateur = administrateur;
    }

    public Utilisateur(int id, String login, String password, String nom, String prenom, Date date_naissance, String email, boolean administrateur) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.email = email;
        this.administrateur = administrateur;
    }

    public Utilisateur(int id, String login, String nom, String prenom, Date date_naissance, String email, boolean administrateur) {
        this.id = id;
        this.login = login;
        this.password = "";
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.email = email;
        this.administrateur = administrateur;
    }

    public Utilisateur(int id, String login, String password, String nom, String prenom, Date date_naissance, String email, InputStream inputStreamImage, boolean administrateur) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.email = email;
        if(inputStreamImage!=null){
            try {
                this.imageProfile = DaoFactory.getInstance().getConnection().createBlob();
                this.imageProfile.setBytes(1, IOUtils.toByteArray(inputStreamImage));
            } catch (SQLException | IOException throwables) {
                this.imageProfile = null;
            }
        }
        else this.imageProfile = null;
        this.administrateur = administrateur;
    }

    public Utilisateur(int id, String login, String nom, String prenom, Date date_naissance, String email, InputStream inputStreamImage, boolean administrateur) {
        this.id = id;
        this.login = login;
        this.password = "";
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.email = email;
        if(inputStreamImage!=null){
            try {
                this.imageProfile = DaoFactory.getInstance().getConnection().createBlob();
                this.imageProfile.setBytes(1, IOUtils.toByteArray(inputStreamImage));
            } catch (SQLException | IOException throwables) {
                this.imageProfile = null;
            }
        }
        else this.imageProfile = null;
        this.administrateur = administrateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getImageProfile() {
        return imageProfile;
    }

    public String getImageArrayString()
    {
        return String.valueOf(this.imageProfile);
    }

    public void setImageProfile(Blob imageProfile) {
        this.imageProfile = imageProfile;
    }

    public boolean isAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

    public List<Integer> getAmis() {
        return amis;
    }

    public void setAmis(List<Integer> amis) {
        this.amis = amis;
    }
}
