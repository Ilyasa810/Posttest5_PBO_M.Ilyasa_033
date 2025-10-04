package Model;

public abstract class Game {   
    private String nama;
    private String genre;
    private int tahunRilis;

    public Game(String nama, String genre, int tahunRilis) {
        this.nama = nama;
        this.genre = genre;
        this.tahunRilis = tahunRilis;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getTahunRilis() { return tahunRilis; }
    public void setTahunRilis(int tahunRilis) { this.tahunRilis = tahunRilis; }

    
    public abstract String getPlatform();

    @Override
    public String toString() {
        return nama + " | " + genre + " | " + tahunRilis;
    }
}
