import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
public class Toy implements Comparable<Toy>{
    private Integer id;
    private String name;
    private Integer frequencyOfLoss;

    /**
     * Метод создания экземпляра класса Toy
     * @param id - целочисленное значение поля id
     * @param name - строковое значение поля name
     * @param frequencyOfLoss - целочисленное значение поля frequencyOfLoss
     * */
    public Toy(Integer id, String name, Integer frequencyOfLoss) {
        this.id = id;
        this.name = name;
        this.frequencyOfLoss = frequencyOfLoss;
    }

    /**
     * Переопределенный метод класса Object
     * возвращает строковое представление экземпляра класса
     * */
    @Override
    public String toString() {
        return String.format("id: %d Наименование игрушки: %s шанс выпадения в процентах: %d", this.id, this.name, this.frequencyOfLoss);
    }

    /**
     * Переопределенный метод интерфейса Comparable
     * возвращает целочисленный результат сравнения двух экземпляров класса Toy
     * @param o - экземпляр класса Toy
     * */
    @Override
    public int compareTo(Toy o) {
        return Comparator.comparing(Toy::getFrequencyOfLoss).thenComparing(Toy::getName).thenComparing(Toy::getId).compare(this, o);
    }
}
