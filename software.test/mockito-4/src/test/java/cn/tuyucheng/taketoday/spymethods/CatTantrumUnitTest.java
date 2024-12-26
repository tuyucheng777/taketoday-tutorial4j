package cn.tuyucheng.taketoday.spymethods;

import cn.tuyucheng.taketoday.spymethods.CatTantrum.CatAction;
import cn.tuyucheng.taketoday.spymethods.CatTantrum.HumanReaction;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTantrumUnitTest {

   @Test
   public void givenMockMethodHumanReactions_whenCatActionBite_thenHumanReactionsBiteBack() {
      // Given
      CatTantrum catTantrum = new CatTantrum();
      CatTantrum catTantrum1 = Mockito.spy(catTantrum);
      Mockito.doReturn(HumanReaction.BITE_BACK).when(catTantrum1).biteCatBack();

      // When
      HumanReaction humanReaction1 = catTantrum1.whatIsHumanReaction(CatAction.BITE);

      // Then
      assertEquals(HumanReaction.BITE_BACK, humanReaction1);
   }
}