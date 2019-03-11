package FC;
public enum Salle {
    S1 ("S1"),
    S2 ("S2"),
    S3 ("S3"),
    S4 ("S4"),
    S5 ("S5"),
    S6 ("S6"),
    S7 ("S7"),
    S8 ("S8");
    private String salle;
    private Salle (String salle){
        this.salle=salle;
        
    }
    public String toString() {
        return salle;
    }
}