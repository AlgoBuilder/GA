/**
 * @author AlgoBuilder
 * @see <a href="https://github.com/AlgoBuilder">Source Code</a>
 */
class Individual {
    // setChromosome -> setFitness -> breed

    private Chromosome chromosome = new Chromosome();
    private Individual setChromosome(Chromosome ch) {
        chromosome = ch;
        return this;
    }
    Chromosome getChromosome() {
        return chromosome;
    }

    private double fitness;
    Individual setFitness(double fit) {
        fitness = fit;
        return this;
    }
    Individual setFitness(FitnessFunction fitnessFunction) {
        fitness = fitnessFunction.getFitness(chromosome);
        return this;
    }
    double getFitness() {
        return fitness;
    }

    Individual breed(Individual mate, double p) {
        Chromosome crossover = this.chromosome.clone();
        for (int i=0; i<this.chromosome.size(); i++) {
            if (Math.random() < 0.5) crossover.setGene(i, mate.getChromosome().getGene(i).copy());
        }
        if (Math.random() < p) crossover.getGene((int) (chromosome.size() * Math.random())).mutate(); // random mutation
        return new Individual().setChromosome(crossover);
    }

    Individual makeRandom(Gene[] genes) {
        chromosome.randomize(genes);
        return this;
    }

    public Individual clone() {
        return new Individual().setFitness(fitness).setChromosome(chromosome.clone());
    }

}
