package cn.tuyucheng.taketoday.patterns;


import cn.tuyucheng.taketoday.patterns.data.Roll;
import cn.tuyucheng.taketoday.patterns.data.Strategies;
import cn.tuyucheng.taketoday.patterns.data.Strategies.*;
import cn.tuyucheng.taketoday.patterns.data.Strategy;
import cn.tuyucheng.taketoday.patterns.data.Turn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static cn.tuyucheng.taketoday.patterns.ScoringRules.*;

public class Yahtzee {

   private Yahtzee() {
   }

   static Supplier<Integer> diceValueGenerator = () -> ThreadLocalRandom.current().nextInt(1, 7);

   static Roll roll() {
      List<Integer> dice = IntStream.rangeClosed(1, 5)
            .mapToObj(_ -> randomDieValue())
            .toList();
      return new Roll(dice, 1);
   }

   static Roll rerollValues(Roll roll, Integer... values) {
      List<Integer> valuesToReroll = new ArrayList<>(List.of(values));
      if (roll.rollCount() >= 3) {
         throw new IllegalStateException("You can re-roll 3 times at most.");
      }
      if (!new HashSet<>(roll.dice()).containsAll(valuesToReroll)) {
         throw new IllegalStateException("You can re-roll dice values which are not from the original roll.");
      }
      List<Integer> newDice = roll.dice().stream().map(it -> {
         if (!valuesToReroll.contains(it)) {
            return it;
         }
         valuesToReroll.remove(it);
         return randomDieValue();
      }).toList();

      return new Roll(newDice, roll.rollCount() + 1);
   }

   static Turn chooseStrategy(Roll roll, String strategyStr) {
      Strategy strategy = Strategies.fromString(strategyStr);
      return new Turn(roll, strategy);
   }

   static int score(Turn turn) {
      var dices = turn.roll().dice();
      return switch (turn.strategy()) {
         case Ones _ -> specificValue(dices, 1);
         case Twos _ -> specificValue(dices, 2);
         case OnePair _ -> pairs(dices, 1);
         case TwoPairs _ -> pairs(dices, 2);
         case ThreeOfaKind _ -> moreOfSameKind(dices, 3);
      };
   }

   private static Integer randomDieValue() {
      return diceValueGenerator.get();
   }
}