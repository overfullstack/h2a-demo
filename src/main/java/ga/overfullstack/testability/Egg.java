package ga.overfullstack.testability;

import org.immutables.value.Value;

@Value.Style(allParameters = true)
@Value.Immutable
interface Egg {

  ID id();

  int age();

  String field1();

  String field2();

  String field3();
}
