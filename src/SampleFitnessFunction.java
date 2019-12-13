public class SampleFitnessFunction extends FitnessFunction {
    // Give points for odds
    public double getFitness(Chromosome chromosome) {
        // over-write this function
        double points = 0.0;
        for (int i=0; i<chromosome.size(); i++) if ((int) chromosome.getGene(i).getValue() % 2 == 1) points++;
        return points;
    }
}
