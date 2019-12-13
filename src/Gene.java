import java.util.Arrays;

public class Gene<T extends Comparable> {
    private T value;
    public Gene setValue(T nval) {
        value = nval;
        return this;
    }
    public T getValue() {
        return value;
    }
    public void printClass() {
        System.out.println(value.getClass().getCanonicalName());
    }

    private T[] domain;
    public Gene setDomain(T[] d) {
        domain = d;
        return this;
    }
    public void printDomain() {
        System.out.println(Arrays.toString(domain));
    }
    public Gene getRandom() {
        value = domain[(int) (domain.length * Math.random())];
        return this;
    }
    public Gene mutate() {
        T oldValue = value;
        Gene newGene;
        do {
            newGene = getRandom();
        } while (newGene.getValue().compareTo(oldValue) == 0); // repeat until a random mutation occurs
        return this;
    }

    public Gene clone() {
        return new Gene().setDomain(domain).getRandom();
    }

    public Gene copy() {
        return new Gene().setDomain(domain).setValue(value);
    }

}
