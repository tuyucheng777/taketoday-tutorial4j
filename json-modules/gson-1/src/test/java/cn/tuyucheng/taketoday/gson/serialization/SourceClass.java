package cn.tuyucheng.taketoday.gson.serialization;

public class SourceClass {
   private int intValue;
   private String stringValue;

   public SourceClass(final int intValue, final String stringValue) {
      this.intValue = intValue;
      this.stringValue = stringValue;
   }

   public int getIntValue() {
      return intValue;
   }

   public String getStringValue() {
      return stringValue;
   }

   @Override
   public String toString() {
      return "SourceClass{" + "intValue=" + intValue + ", stringValue='" + stringValue + '\'' + '}';
   }

   @Override
   public boolean equals(final Object o) {
      if (this == o)
         return true;
      if (!(o instanceof SourceClass that))
         return false;

      if (intValue != that.intValue)
         return false;
      return stringValue.equals(that.stringValue);
   }

   @Override
   public int hashCode() {
      int result = intValue;
      result = 31 * result + stringValue.hashCode();
      return result;
   }
}