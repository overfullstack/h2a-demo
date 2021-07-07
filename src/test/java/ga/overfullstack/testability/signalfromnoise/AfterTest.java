package ga.overfullstack.testability.signalfromnoise;

import ga.overfullstack.testability.Fields;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static ga.overfullstack.testability.signalfromnoise.After.fieldMapping;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AfterTest {

  @Test
  void fillEntityObj() {
    final var egg = ImmutableEgg.of(ImmutableID.of(1), 10, "field1Value", null, "field3Value");
    var actualPairs = new HashMap<String, String>();
    After.fillEntityObj(egg, fieldMapping, actualPairs::put);

    var expectedPairs =
        Map.of(
            Fields.field1, "field1Value",
            Fields.field3, "field3Value");
    assertEquals(expectedPairs, actualPairs);
  }
}
