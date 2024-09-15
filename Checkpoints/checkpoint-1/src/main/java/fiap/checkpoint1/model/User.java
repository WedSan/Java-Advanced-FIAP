package fiap.checkpoint1.model;

public class User {

    private static long idCounter = 0;

    private long id;

    private String name;

    private String email;

    public User(String name, String email) {
        this.id = ++idCounter;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
