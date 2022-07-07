package ga.overfullstack.testability.signalfromnoise;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import ga.overfullstack.hellorealworld.EggEntity;
import ga.overfullstack.testability.Fields;
import org.junit.jupiter.api.Test;

class BeforeTest {

  @Test
  void mapToEntityObjTest() {
    // * `EggEntity` Object can't be instantiated in a Unit test context.
    final var mockEggEntity = mock(EggEntity.class);
    final var egg =
        ImmutableEgg.of(ImmutableID.of(1), 10, "field1Value", "field2Value", "field3Value");
    new Before().fillEntityObj(egg, mockEggEntity);
    verify(mockEggEntity).put(Fields.field1, "field1Value");
    verify(mockEggEntity, never()).put(Fields.field2, null);
    verify(mockEggEntity).put(Fields.field3, "field3Value");
  }
}
