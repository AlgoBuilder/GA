public class Population {
    private Individual[] individuals;
    public Population setIndividuals(Individual[] people) {
        individuals = people;
        return this;
    }
    public Individual getIndividual(int i) {
        return individuals[i];
    }
    public Population setIndividual(int i, Individual individual) {
        individuals[i] = individual.clone();
        return this;
    }

    private double popFitness;
    public double getPopFitness() {
        return popFitness;
    }
    public Population setPopFitness() {
        for (int i=0; i<individuals.length; i++) {
            popFitness += individuals[i].setFitness(fitnessFunction.getFitness(individuals[i].getChromosome())).getFitness();
        }
        return this;
    }

    private FitnessFunction fitnessFunction;
    public Population setFitnessFunction(FitnessFunction fitFn) {
        fitnessFunction = fitFn;
        return this;
    }

    private double mutation;
    public Population setMutation(double m) {
        mutation = m;
        return this;
    }

    public Population initialize(Gene[] genes, int size) {
        individuals = new Individual[size];
        // randomly generate individuals' genetic makeup
        for (int i=0; i<size; i++) {
            individuals[i] = new Individual().makeRandom(genes).setFitness(fitnessFunction);
            popFitness += individuals[i].getFitness();
        }
        return setFittest();
    }

    public Population reproduce() {
        Individual[] pop = new Individual[individuals.length];
        for (int i=0; i<individuals.length; i++)  {
            pop[i] = makeChild();
        }
        Population nextGen = new Population().setFitnessFunction(fitnessFunction).setIndividuals(pop).setPopFitness().setFittest();
        return nextGen.setIndividual(nextGen.least_fit, this.getFittest()).setFittest();
    }

    private Individual makeChild() {
        int draw1 = (int) (individuals.length * Math.random());
        int draw2 = draw1;
        do {
            draw2 = (int) (individuals.length * Math.random());
        }
        while (draw1 == draw2);
        return individuals[draw1].breed(individuals[draw2], mutation).setFitness(fitnessFunction);
    }

    private Individual fittest;
    private int least_fit;
    public Population setFittest() {
        fittest = individuals[0];
        least_fit = 0;
        for (int i=1; i<individuals.length; i++) {
            if (fittest.getFitness() < individuals[i].getFitness()) fittest = individuals[i];
            if (individuals[least_fit].getFitness() > individuals[i].getFitness()) least_fit = i;
        }
        return this;
    }
    public Individual getFittest() {
        return fittest;
    }
    public int getLeast_fit() {
        return least_fit;
    }

    public Population clone() {
        return new Population().setFitnessFunction(fitnessFunction).setIndividuals(individuals);
    }

}
