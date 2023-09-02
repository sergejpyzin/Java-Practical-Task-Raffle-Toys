import java.util.Comparator;

public class Toy implements Comparable<Toy>{
    private Integer id;
    private String name;
    private Integer frequencyOfLoss;

    public Toy(Integer id, String name, Integer frequencyOfLoss) {
        this.id = id;
        this.name = name;
        this.frequencyOfLoss = frequencyOfLoss;
    }


    public Integer getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public Integer getFrequencyOfLoss() {
        return frequencyOfLoss;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFrequencyOfLoss(Integer frequencyOfLoss) {
        this.frequencyOfLoss = frequencyOfLoss;
    }

    @Override
    public String toString() {
        return String.format("id: %d Наименование игрушки: %s шанс выпадения в процентах: %d", this.id, this.name, this.frequencyOfLoss);
    }

    @Override
    public int compareTo(Toy o) {
        return Comparator.comparing(Toy::getFrequencyOfLoss).thenComparing(Toy::getName).thenComparing(Toy::getId).compare(this, o);
    }
}
