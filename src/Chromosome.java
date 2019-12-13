public class Chromosome {
    private int size;
    public int size() {
        return size;
    }

    private Gene[] chromosome;
    public Chromosome setChromosome(Gene[] g) {
        chromosome = new Gene[g.length];
        for (int i=0; i<g.length; i++) chromosome[i] = g[i].copy();
        size = g.length;
        return this;
    }
    public Gene[] getChromosome() {
        return chromosome;
    }
    public void setGene(int i, Gene gene) {
        chromosome[i] = gene.copy();
    }
    public Gene getGene(int i) {
        return chromosome[i];
    }

    public void printChromosome() {
        for (int i=0; i<chromosome.length; i++) {
            if (i==0) System.out.print("[" + chromosome[i].getValue().toString() + ", ");
            else if (i<chromosome.length-1) System.out.print(chromosome[i].getValue().toString() + ", ");
            else System.out.print(chromosome[i].getValue().toString() + "]");
        }
    }

    public Chromosome clone() {
        return new Chromosome().setChromosome(this.chromosome);
    }

    public Chromosome randomize(Gene[] genes) {
        // for default population
        chromosome = new Gene[genes.length];
        size = genes.length;
        for (int i=0; i<genes.length; i++) chromosome[i] = genes[i].clone();
        return this;
    }

}
