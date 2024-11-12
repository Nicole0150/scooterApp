public class Scooter {
    public String station;
    public String user;
    public static int nextSerial = 1;
    public int serial;
    public int charge;
    public boolean isBroken;

    public Scooter (String station){
        this.station = station;
        this.user = null;
        this.serial = Scooter.nextSerial++;
        this.charge = 100;
        this.isBroken = false;
    }

    public void rent(User user) {
        if (this.charge >= 20 && isBroken) {
            this.user = user.username;
            System.out.println("Scooter assigned to: " + this.user);
        } else if (this.charge >= 20 && !isBroken){
            System.out.println("Scooter needs repaired");
        } else if (this.charge < 20) {
            System.out.println("Scooter needs charged");
        }
    }

    public void dock(String station){
        this.station = station;
        this.user = null;
        System.out.println("Scooter docked at: " + this.station + ".  We hope to see you again!");
    }

}