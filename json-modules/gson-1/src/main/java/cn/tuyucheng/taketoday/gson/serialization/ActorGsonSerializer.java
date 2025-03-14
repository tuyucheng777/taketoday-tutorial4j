package cn.tuyucheng.taketoday.gson.serialization;

import cn.tuyucheng.taketoday.gson.entities.ActorGson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.List;

public class ActorGsonSerializer implements JsonSerializer<ActorGson> {

   private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

   @Override
   public JsonElement serialize(ActorGson actor, Type type, JsonSerializationContext jsonSerializationContext) {
      JsonObject actorJsonObj = new JsonObject();
      actorJsonObj.addProperty("<strong>IMDB Code</strong>", actor.getImdbId());
      actorJsonObj.addProperty("<strong>Date Of Birth</strong>", actor.getDateOfBirth() != null ? sdf.format(actor.getDateOfBirth()) : null);
      actorJsonObj.addProperty("<strong>N° Film:</strong> ", actor.getFilmography() != null ? actor.getFilmography().size() : null);
      actorJsonObj.addProperty("filmography", actor.getFilmography() != null ? convertFilmography(actor.getFilmography()) : null);

      return actorJsonObj;
   }

   private String convertFilmography(List<String> filmography) {
      return String.join("-", filmography);
   }
}