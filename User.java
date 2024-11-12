public class User{
    public String username;
    public String password;
    public int age;
    public boolean loggedIn;

    public User(String username, String password, int age){
        this.username = username;
        this.password = password;
        this.age = age;
        this.loggedIn = false;
    }

    public void login(String password){
        if (this.password.equals(password)){
            this.loggedIn = true;
            System.out.println("You are logged in!");
        } else {
            System.out.println("Error: invalid password");
        }
    }

    public void logout(){
        this.loggedIn = false;
        System.out.println("Logged out");
    }
}