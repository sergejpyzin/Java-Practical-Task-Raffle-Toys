import java.util.UUID;

public class Toy implements Comparable<Toy>{
    private final String id;
    private String name;
    private Integer frequencyOfLoss;

    public Toy(String name, int frequencyOfLoss) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.frequencyOfLoss = frequencyOfLoss;
    }

    public Toy() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public int getFrequencyOfLoss() {
        return frequencyOfLoss;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrequencyOfLoss(int frequencyOfLoss) {
        this.frequencyOfLoss = frequencyOfLoss;
    }

    @Override
    public String toString() {
        return String.format("id:%s %s вероятность: %d", this.id, this.name, this.frequencyOfLoss);
    }

    @Override
    public int compareTo(Toy o) {
        return this.frequencyOfLoss.compareTo(o.frequencyOfLoss);
    }
}
