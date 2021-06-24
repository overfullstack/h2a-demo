package ga.overfullstack.testability.signalfromnoise;

import ga.overfullstack.testability.Fields;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class After {
  static final Map<String, Function<ImmutableEgg, String>> fieldMapping =
      Map.of(
          Fields.field1, ImmutableEgg::field1,
          Fields.field2, ImmutableEgg::field2,
          Fields.field3, ImmutableEgg::field3);

  static void fillEntityObj(ImmutableEgg egg, BiConsumer<String, String> filler) {
    fieldMapping.forEach(
        (fieldId, valueMapper) -> {
          final var fieldValue = valueMapper.apply(egg);
          if (fieldValue != null) {
            filler.accept(fieldId, fieldValue);
          }
        });
  }
}
