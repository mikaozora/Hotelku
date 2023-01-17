public class Receptionist {
    String name;
    int id;
    int noTelp;
    String alamat;

    Receptionist(String name, int noTelp, String alamat){
        setName(name);
        setAlamat(alamat);
        setNoTelp(noTelp);
        this.id = (int) (Math.random()*10);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(int noTelp) {
        this.noTelp = noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    void view(){
        System.out.println("Name: " + name);
        System.out.println("Alamat: " + alamat);
        System.out.println("No Telepon: " + noTelp);
    }
}
