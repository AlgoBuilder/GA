import java.util.Arrays;

/**
 * @author AlgoBuilder
 * @see <a href="https://github.com/AlgoBuilder">Source Code</a>
 */
class Gene<T extends Comparable> {
    private T value;
    private Gene setValue(T nval) {
        value = nval;
        return this;
    }
    T getValue() {
        return value;
    }
    public void printClass() {
        System.out.println(value.getClass().getCanonicalName());
    }

    private int location;
    public int getLocation() {
        return location;
    }
    private Gene setLocation(int n) {
        location = n;
        return this;
    }

    private T[] domain;
    Gene setDomain(T[] d) {
        domain = d;
        return this;
    }
    public void printDomain() {
        System.out.println(Arrays.toString(domain));
    }
    private Gene getRandom() {
        location = (int) (domain.length * Math.random());
        value = domain[location];
        return this;
    }
    void mutate() {
        T oldValue = value;
        Gene newGene;
        do {
            newGene = getRandom();
        } while (newGene.getValue().compareTo(oldValue) == 0); // repeat until a random mutation occurs
    }

    public Gene clone() {
        return new Gene().setDomain(domain).getRandom();
    }

    Gene copy() {
        return new Gene().setDomain(domain).setValue(value).setLocation(location);
    }

}
