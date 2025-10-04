package Model;

public class MobileGame extends Game {

    public MobileGame(String nama, String genre, int tahunRilis) {
        super(nama, genre, tahunRilis);
    }

    @Override
    public String getPlatform() {         
        return "Mobile";
    }

    @Override
    public String toString() {           
        return super.toString() + " | (Mobile)";
    }
}
