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

    public rent(User user) {
        if (this.charge >= 20 && isBroken) {
            this.user = user.name;
            System.out.println("Scooter assigned to: " + this.user);
        } else if (this.charge >= 20 && !isBroken){
            throw new Exception("Scooter needs repaired");
        } else if (this.charge < 20) {
            throw new Exception("Scooter needs charged");
        }
    }

    public dock(String station){
        this.station = station;
        this.user = null;
        System.out.println("Scooter docked at: " + this.station + ".  We hope to see you again!");
    }

}