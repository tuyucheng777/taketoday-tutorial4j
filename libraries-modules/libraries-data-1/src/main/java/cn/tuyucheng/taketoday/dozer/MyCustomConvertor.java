package cn.tuyucheng.taketoday.dozer;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCustomConvertor implements CustomConverter {

   @Override
   public Object convert(Object dest, Object source, Class<?> arg2, Class<?> arg3) {
      switch (source) {
         case null -> {
            return null;
         }
         case Personne3 person -> {
            Date date = new Date(person.getDtob());
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            String isoDate = format.format(date);
            return new Person3(person.getName(), isoDate);

         }
         case Person3 person -> {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date date = null;
            try {
               date = format.parse(person.getDtob());

            } catch (ParseException e) {
               throw new MappingException("Converter MyCustomConvertor " + "used incorrectly:" + e.getMessage());
            }
            long timestamp = date.getTime();
            return new Personne3(person.getName(), timestamp);

         }
         default ->
               throw new MappingException("Converter MyCustomConvertor " + "used incorrectly. Arguments passed in were:" + dest + " and " + source);
      }
   }
}