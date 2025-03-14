package cn.tuyucheng.taketoday.measurement;

import org.junit.Test;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.MetricPrefix;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.Volume;

import static org.junit.Assert.assertEquals;
import static tec.units.ri.unit.Units.*;

public class WaterTankUnitTest {

   @Test
   public void givenQuantity_whenGetUnitAndConvertValue_thenSuccess() {
      WaterTank waterTank = new WaterTank();
      waterTank.setCapacityMeasure(Quantities.getQuantity(9.2, LITRE));
      assertEquals(LITRE, waterTank.getCapacityMeasure().getUnit());

      Quantity<Volume> waterCapacity = waterTank.getCapacityMeasure();
      double volumeInLitre = waterCapacity.getValue().doubleValue();
      assertEquals(9.2, volumeInLitre, 0.0f);

      double volumeInMilliLitre = waterCapacity.to(MetricPrefix.MILLI(LITRE)).getValue().doubleValue();
      assertEquals(9200.0, volumeInMilliLitre, 0.0f);

      // compilation error
      // volumeInMilliLitre = waterCapacity.to(MetricPrefix.MILLI(KILOGRAM));

      Unit<Length> Kilometer = MetricPrefix.KILO(METRE);

      // compilation error
      // Unit<Length> Centimeter = MetricPrefix.CENTI(LITRE);
   }

   @Test
   public void givenUnit_whenAlternateUnit_ThenGetAlternateUnit() {
      Unit<Pressure> PASCAL = NEWTON.divide(METRE.pow(2)).alternate("Pa").asType(Pressure.class);
      assertEquals(SimpleUnitFormat.getInstance().parse("Pa"), PASCAL);
   }

   @Test
   public void givenUnit_whenProduct_ThenGetProductUnit() {
      Unit<Area> squareMetre = METRE.multiply(METRE).asType(Area.class);
      Quantity<Length> line = Quantities.getQuantity(2, METRE);
      assertEquals(line.multiply(line).getUnit(), squareMetre);
   }

   @Test
   public void givenMeters_whenConvertToKilometer_ThenConverted() {
      double distanceInMeters = 50.0;
      UnitConverter metreToKilometre = METRE.getConverterTo(MetricPrefix.KILO(METRE));
      double distanceInKilometers = metreToKilometre.convert(distanceInMeters);
      assertEquals(0.05, distanceInKilometers, 0.00f);
   }

   @Test
   public void givenSymbol_WhenCompareToSystemUnit_ThenSuccess() {
      assertEquals(SimpleUnitFormat.getInstance().parse("kW"), MetricPrefix.KILO(WATT));
      assertEquals(SimpleUnitFormat.getInstance().parse("ms"), SECOND.divide(1000));
   }

   @Test
   public void givenUnits_WhenAdd_ThenSuccess() {
      Quantity<Length> total = Quantities.getQuantity(2, METRE).add(Quantities.getQuantity(3, METRE));
      assertEquals(5, total.getValue().intValue());

      // compilation error
      // Quantity<Length> total = Quantities.getQuantity(2, METRE).add(Quantities.getQuantity(3, LITRE));

      Quantity<Length> totalKm = Quantities.getQuantity(2, METRE).add(Quantities.getQuantity(3, MetricPrefix.KILO(METRE)));
      assertEquals(3002, totalKm.getValue().intValue());
   }
}