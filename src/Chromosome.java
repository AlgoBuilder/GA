/**
 * @author AlgoBuilder
 * @see <a href="https://github.com/AlgoBuilder">Source Code</a>
 */
class Chromosome {
    private int size;
    int size() {
        return size;
    }

    private Gene[] chromosome;
    private Chromosome setChromosome(Gene[] g) {
        chromosome = new Gene[g.length];
        for (int i=0; i<g.length; i++) chromosome[i] = g[i].copy();
        size = g.length;
        return this;
    }
    public Gene[] getChromosome() {
        return chromosome;
    }
    void setGene(int i, Gene gene) {
        chromosome[i] = gene.copy();
    }
    Gene getGene(int i) {
        return chromosome[i];
    }

    void printChromosome() {
        for (int i=0; i<chromosome.length; i++) {
            if (i==0) System.out.print("[" + chromosome[i].getValue().toString() + ", ");
            else if (i<chromosome.length-1) System.out.print(chromosome[i].getValue().toString() + ", ");
            else System.out.print(chromosome[i].getValue().toString() + "]");
        }
    }

    public Chromosome clone() {
        return new Chromosome().setChromosome(this.chromosome);
    }

    void randomize(Gene[] genes) {
        // for default population
        chromosome = new Gene[genes.length];
        size = genes.length;
        for (int i=0; i<genes.length; i++) chromosome[i] = genes[i].clone();
    }

}
