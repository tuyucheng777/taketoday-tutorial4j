package cn.tuyucheng.taketoday.nullconversion;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ObjectsProvider implements ArgumentsProvider {

   @Override
   public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
            Arguments.of(null, "default"),
            Arguments.of("not null", "default")
      );
   }
}