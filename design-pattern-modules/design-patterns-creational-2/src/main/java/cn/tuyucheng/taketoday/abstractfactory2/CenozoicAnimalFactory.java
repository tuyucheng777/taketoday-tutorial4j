package cn.tuyucheng.taketoday.abstractfactory2;

public class CenozoicAnimalFactory implements EraAnimalFactory {
   @Override
   public LandAnimal makeLandAnimal() {
      return new LandAnimal(AnimalEra.CENOZOIC, "Mammoth");
   }

   @Override
   public SkyAnimal makeSkyAnimal() {
      return new SkyAnimal(AnimalEra.CENOZOIC, "Terror bird");
   }

   Animal createAnimal(AnimalType type) {
      return switch (type) {
         case LAND -> makeLandAnimal();
         case SKY -> makeSkyAnimal();
      };
   }
}