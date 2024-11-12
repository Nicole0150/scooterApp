import java.util.HashMap;

public class ScooterApp{
    private HashMap<String, Scooter[]> stations;
    private HashMap<String, User> registeredUsers;

    public ScooterApp() {
        stations = new HashMap<>();
        stations.put("Partick", new Scooter[0]);
        stations.put("Queen St", new Scooter[0]);
        stations.put("Central", new Scooter[0]);

        registeredUsers = new HashMap<>();
    }

    public void registerUser(String username, String password, int age){
        if(!registeredUsers.containsKey(username)){
            User newUser = new User(username, password, age);
            registeredUsers.put(username, newUser);
            System.out.println("Registered " + username + " successfully.");
        } else{
            System.out.println("User " + username + " already registered.");
        }
    }

    public void loginUser(String username, String password){
        User user = registeredUsers.get(username);
        if(user != null){
            user.login(password);
        } else{
            System.out.println("Username doesn't exist.");
        }
    }

    public void logoutUser(String username){
        User user = registeredUsers.get(username);
        if(user != null){
            user.logout();
        } else{
            System.out.println("Username doesn't exist.");
        }
    }

    public Scooter createScooter(String station){
        if (!stations.containsKey(station)){
            throw new IllegalArgumentException("Station doesn't exist.");
        }

        //Going to start writing comments for the hashmap methods as I am just learning this and want to have notes in case I forget what code does.
        Scooter newScooter = new Scooter(station);
        //get the current array of scooters for that station
        Scooter[] currentScooters = stations.get(station);
        //new array + 1 space for the new scooter
        Scooter[] newArr = new Scooter[currentScooters.length + 1];
        //use System.arraycopy which copies elements from one array to another
        System.arraycopy(currentScooters, 0, newArr, 0, currentScooters.length);
        //param 1 = source from which we copy
        //param 2 = starting position tp begin copy
        //param 3 = destination of copies
        //param 4 = starting position of destination
        //param 5 = no of elements to be copied
        newArr[currentScooters.length] = newScooter;
        //this accesses the new array at the last possible point and adds in the newScooter, like .push
        stations.put(station, newArr);
        //replaces the stations list of scooters
        System.out.println("New Scooter created!");
        return newScooter;
        //made mistake this bit of code should be in the dock method, will fix next time 
        //this method should only assign a new scooter not the station it's docked at 

    }
}