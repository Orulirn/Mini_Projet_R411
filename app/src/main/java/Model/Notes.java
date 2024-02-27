package Model;



public class Notes {

    private int id;

    private String titre;
    private String body;

    public Notes() {
    }

    public Notes(int id, String titre, String body) {
        this.id = id;
        this.titre = titre;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
