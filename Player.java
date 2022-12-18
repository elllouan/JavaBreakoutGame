
public class Player {

    public Player(String name){
        this.name = name;
    }

    private String name;
    
    public String getName() {
        return name;
    }

    public static void create(String name) {
        Player player = new Player(name);
    }

}
