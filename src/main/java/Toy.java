import java.util.UUID;

public class Toy {
    private final String id;
    private String name;
    private Double frequencyOfLoss;

    public Toy(String name, Double frequencyOfLoss) {
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

    public Double getFrequencyOfLoss() {
        return frequencyOfLoss;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrequencyOfLoss(Double frequencyOfLoss) {
        this.frequencyOfLoss = frequencyOfLoss;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", frequencyOfLoss=" + frequencyOfLoss +
                '}';
    }
}
