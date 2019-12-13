public class Individual {
    // setChromosome -> setFitness -> breed

    private Chromosome chromosome = new Chromosome();
    public Individual setChromosome(Chromosome ch) {
        chromosome = ch;
        return this;
    }
    public Chromosome getChromosome() {
        return chromosome;
    }

    private double fitness;
    public Individual setFitness(double fit) {
        fitness = fit;
        return this;
    }
    public Individual setFitness(FitnessFunction fitnessFunction) {
        fitness = fitnessFunction.getFitness(chromosome);
        return this;
    }
    public double getFitness() {
        return fitness;
    }

    public Individual breed(Individual mate, double p) {
        Chromosome crossover = this.chromosome.clone();
        for (int i=0; i<this.chromosome.size(); i++) {
            if (Math.random() < 0.5) crossover.setGene(i, mate.getChromosome().getGene(i).copy());
        }
        if (Math.random() < p) crossover.getGene((int) (chromosome.size() * Math.random())).mutate(); // random mutation
        return new Individual().setChromosome(crossover);
    }

    public Individual makeRandom(Gene[] genes) {
        chromosome.randomize(genes);
        return this;
    }

    public Individual clone() {
        return new Individual().setFitness(fitness).setChromosome(chromosome.clone());
    }

}
