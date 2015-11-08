package hackable.rest;

/**
 * Created by shaun on 07/11/15.
 */
public class Creds {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String name;
    private String pass;

    @Override
    public String toString() {
        return "Creds{" +
                "name:'" + name + '\'' +
                "; pass:'" + pass + '\'' +
                '}';
    }
}
