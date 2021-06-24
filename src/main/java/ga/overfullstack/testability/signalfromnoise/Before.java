package ga.overfullstack.testability.signalfromnoise;

import ga.overfullstack.hellorealworld.EggEntity;
import ga.overfullstack.testability.Fields;
import org.immutables.value.Value;
import org.springframework.lang.Nullable;

public class Before {
  void fillEntityObj(Egg egg, EggEntity eggEntity) {
    if (egg.field1() != null) {
      eggEntity.put(Fields.field1, egg.field1());
    }
    if (egg.field2() != null) {
      eggEntity.put(Fields.field2, egg.field2());
    }
    if (egg.field3() != null) {
      eggEntity.put(Fields.field3, egg.field3());
    }
  }

  @Value.Style(allParameters = true)
  @Value.Immutable
  interface ID {
    int id();
  }

  @Value.Style(allParameters = true)
  @Value.Immutable
  interface Egg {
    ID id();

    int age();

    String field1();

    @Nullable
    String field2();

    String field3();
  }
}
