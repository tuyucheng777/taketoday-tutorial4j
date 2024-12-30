package flatbuffers;

import cn.tuyucheng.taketoday.flatbuffers.MyGame.terrains.Color;
import cn.tuyucheng.taketoday.flatbuffers.MyGame.terrains.Terrain;
import org.junit.Assert;
import org.junit.Test;

import cn.tuyucheng.taketoday.flatbuffers.MyGameMain;

import cn.tuyucheng.taketoday.flatbuffers.MyGame.terrains.Effect;

public class FlatBufferGameUnitTest {

   @Test
   public void givenTerrainEffect_whenSerialisedWithValues_returnBytes() {
      MyGameMain myGame = new MyGameMain();
      byte[] bytes = myGame.serialiseDesertTerrainData();
      Assert.assertNotNull(bytes);
   }

   @Test
   public void givenSerialisedBytes_whenDeSerialised_returnsTerrain() {
      MyGameMain myGame = new MyGameMain();
      byte[] bytes = myGame.serialiseDesertTerrainData();

      Terrain terrain = myGame.deserialiseDataToTerrain(bytes);
      Assert.assertNotNull(terrain);
      Assert.assertEquals(terrain.name(), "Desert");
      Assert.assertEquals(terrain.navigation(), "south");
      Assert.assertEquals(Color.name(terrain.color()), "Brown");
   }

   @Test
   public void givenSerialisedBytes_whenDeSerialised_returnsTerrainEffect() {
      MyGameMain myGame = new MyGameMain();
      byte[] bytes = myGame.serialiseDesertTerrainData();

      Effect.Vector effectsVector = myGame.deserialiseDataToEffect(bytes);
      Assert.assertNotNull(effectsVector);
      Assert.assertEquals(effectsVector.get(0).name(), "Sandstorm");
      Assert.assertEquals(effectsVector.get(1).name(), "Drought");

      Assert.assertEquals(effectsVector.get(1).damage(), 1);
   }
}