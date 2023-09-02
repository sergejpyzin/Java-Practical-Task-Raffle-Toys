import java.util.Comparator;

public class Toy implements Comparable<Toy>{
    private String id;
    private String name;
    private String frequencyOfLoss;

    public Toy(String id, String name, String frequencyOfLoss) {
        this.id = id;
        this.name = name;
        this.frequencyOfLoss = frequencyOfLoss;
    }


    public String getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public String getFrequencyOfLoss() {
        return frequencyOfLoss;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrequencyOfLoss(String frequencyOfLoss) {
        this.frequencyOfLoss = frequencyOfLoss;
    }

    @Override
    public String toString() {
        return String.format("id: %s Наименование игрушки: %s шанс выпадения в процентах: %s", this.id, this.name, this.frequencyOfLoss);
    }

    @Override
    public int compareTo(Toy o) {
        return Comparator.comparing(Toy::getFrequencyOfLoss).thenComparing(Toy::getName).thenComparing(Toy::getId).compare(this, o);
    }
}
