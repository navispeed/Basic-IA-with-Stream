package eu.navispeed;

public class Choice {
    public Integer present;
    public Integer wellPlaced;
    public int[] choice;

    public Choice(Integer present, Integer wellPlaced, int[] choice) {
        this.present = present;
        this.wellPlaced = wellPlaced;
        this.choice = choice;
    }
}
