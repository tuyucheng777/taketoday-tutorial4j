package cn.tuyucheng.taketoday.algorithms.ga.jenetics;

import org.jenetics.*;
import org.jenetics.engine.Engine;
import org.jenetics.engine.EvolutionStatistics;

import java.util.stream.Stream;

import static org.jenetics.engine.EvolutionResult.toBestPhenotype;
import static org.jenetics.engine.limit.bySteadyFitness;

// The main class.
public class Knapsack {

   public static void main(String[] args) {
      int nItems = 15;
      double ksSize = nItems * 100.0 / 3.0;

      KnapsackFF ff = new KnapsackFF(Stream.generate(KnapsackItem::random)
            .limit(nItems)
            .toArray(KnapsackItem[]::new), ksSize);

      Engine<BitGene, Double> engine = Engine.builder(ff, BitChromosome.of(nItems, 0.5))
            .populationSize(500)
            .survivorsSelector(new TournamentSelector<>(5))
            .offspringSelector(new RouletteWheelSelector<>())
            .alterers(new Mutator<>(0.115), new SinglePointCrossover<>(0.16))
            .build();

      EvolutionStatistics<Double, ?> statistics = EvolutionStatistics.ofNumber();

      Phenotype<BitGene, Double> best = engine.stream()
            .limit(bySteadyFitness(7))
            .limit(100)
            .peek(statistics)
            .collect(toBestPhenotype());

      System.out.println(statistics);
      System.out.println(best);
   }
}