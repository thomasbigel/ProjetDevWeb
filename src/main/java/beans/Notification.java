package beans;

public class Notification {
    private int id;
    private int id_utilisateur;
    private int type_notif;
    private String contenu;

    public Notification(int id, int id_utilisateur, int type_notif, String contenu) {
        this.id = id;
        this.id_utilisateur = id_utilisateur;
        this.type_notif = type_notif;
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getType_notif() {
        return type_notif;
    }

    public void setType_notif(int type_notif) {
        this.type_notif = type_notif;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}