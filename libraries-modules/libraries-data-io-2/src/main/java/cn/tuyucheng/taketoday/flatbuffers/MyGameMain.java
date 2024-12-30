package cn.tuyucheng.taketoday.flatbuffers;

import static cn.tuyucheng.taketoday.flatbuffers.MyGame.terrains.Terrain.addColor;
import static cn.tuyucheng.taketoday.flatbuffers.MyGame.terrains.Terrain.addEffects;
import static cn.tuyucheng.taketoday.flatbuffers.MyGame.terrains.Terrain.addNavigation;
import static cn.tuyucheng.taketoday.flatbuffers.MyGame.terrains.Terrain.endTerrain;
import static cn.tuyucheng.taketoday.flatbuffers.MyGame.terrains.Terrain.startTerrain;

import java.nio.ByteBuffer;

import cn.tuyucheng.taketoday.flatbuffers.MyGame.terrains.Color;
import com.google.flatbuffers.FlatBufferBuilder;

import cn.tuyucheng.taketoday.flatbuffers.MyGame.terrains.Effect;
import cn.tuyucheng.taketoday.flatbuffers.MyGame.terrains.Terrain;

public class MyGameMain {

   public byte[] serialiseDesertTerrainData() {
      int INITIAL_BUFFER = 1024;
      FlatBufferBuilder builder = new FlatBufferBuilder(INITIAL_BUFFER);

      int sandstormOffset = builder.createString("Sandstorm");
      short damage = 3;
      int sandStorm = Effect.createEffect(builder, sandstormOffset, damage);

      int droughtOffset = builder.createString("Drought");
      short damageDrought = 1;
      int drought = Effect.createEffect(builder, droughtOffset, damageDrought);
      int[] effects = new int[2];
      effects[0] = sandStorm;
      effects[1] = drought;

      byte color = Color.Brown;
      int terrainName = builder.createString("Desert");
      int navigationName = builder.createString("south");

      int effectOffset = Terrain.createEffectsVector(builder, effects);

      startTerrain(builder);
      Terrain.addName(builder, terrainName);
      addColor(builder, color);
      addNavigation(builder, navigationName);
      addEffects(builder, effectOffset);
      int desert = endTerrain(builder);
      builder.finish(desert);

      return builder.sizedByteArray();
   }

   public Terrain deserialiseDataToTerrain(byte[] buffer) {
      ByteBuffer buf = ByteBuffer.wrap(buffer);
      return Terrain.getRootAsTerrain(buf);
   }

   public Effect.Vector deserialiseDataToEffect(byte[] buffer) {
      ByteBuffer buf = ByteBuffer.wrap(buffer);

      return Terrain.getRootAsTerrain(buf)
            .effectsVector();
   }
}