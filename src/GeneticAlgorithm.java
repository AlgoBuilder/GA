/**
 * @author AlgoBuilder
 * @see <a href="https://github.com/AlgoBuilder">Source Code</a>
 */
public class GeneticAlgorithm {
    private int genSize;
    public GeneticAlgorithm setGenSize(int n) {
        genSize = n;
        return this;
    }

    private Gene[] geneDomain;
    public GeneticAlgorithm setGeneDomain(Gene[] genes) {
        geneDomain = genes;
        return this;
    }

    private FitnessFunction fitnessFunction;
    public GeneticAlgorithm setFitnessFunction(FitnessFunction fitFn) {
        fitnessFunction = fitFn;
        return this;
    }

    private Population currentPopulation;
    public GeneticAlgorithm initializePopulation() {
        // requires geneDomain, genSize, fitnessFunction as prior input
        currentPopulation = new Population()
                .setFitnessFunction(fitnessFunction)
                .initialize(geneDomain, genSize);
        return this;
    }
    public Population getCurrentPopulation() {
        return currentPopulation;
    }

    public GeneticAlgorithm getNextGeneration(double mutationRate) {
        currentPopulation = currentPopulation.setMutation(mutationRate).reproduce();
        return this;
    }

}
