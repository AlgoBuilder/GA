public class SampleImplementation {

    public static void main(String[] args) {

        // Gene domains
        Integer[] domain_1 = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        Integer[] domain_2 = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        Integer[] domain_3 = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        Integer[] domain_4 = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        Integer[] domain_5 = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        Integer[] domain_6 = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        Integer[] domain_7 = {0, 1, 2, 3, 4, 5, 7, 8, 9};

        // initialize gene
        Gene[] genes = new Gene[7];
        genes[0] = new Gene().setDomain(domain_1);
        genes[1] = new Gene().setDomain(domain_2);
        genes[2] = new Gene().setDomain(domain_3);
        genes[3] = new Gene().setDomain(domain_4);
        genes[4] = new Gene().setDomain(domain_5);
        genes[5] = new Gene().setDomain(domain_6);
        genes[6] = new Gene().setDomain(domain_7);

        int num = 10; // number of individuals in a generation
        int generations = 8; // number of generations

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm()
                .setFitnessFunction(new SampleFitnessFunction()).setGeneDomain(genes).setGenSize(num)
                .initializePopulation();

        // output "Average fitness" and "Best fitness" per generation
        System.out.println("Avg\tBest");

        for (int i=0; i<generations; i++) {
            System.out.println("Gen. " + i + ":\t" + + geneticAlgorithm.getCurrentPopulation().getPopFitness() / num
                    + "\t" + geneticAlgorithm.getCurrentPopulation().getFittest().getFitness());
            if (i != generations - 1)
                geneticAlgorithm.getNextGeneration(0.2);
        }

        // info on fittest @generations
        System.out.print("---------------------\nFittest chromosome:\t");
        geneticAlgorithm.getCurrentPopulation().getFittest().getChromosome().printChromosome();


    }
}
