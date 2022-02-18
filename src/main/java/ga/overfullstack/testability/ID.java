package ga.overfullstack.testability;

import org.immutables.value.Value;

@Value.Style(allParameters = true)
@Value.Immutable
public
interface ID {

  int value();
}
