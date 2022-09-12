package ga.overfullstack.testability;

import ga.overfullstack.MyStyle;
import org.immutables.value.Value;

@MyStyle
@Value.Immutable
public interface IDDef {

  int value();
}
