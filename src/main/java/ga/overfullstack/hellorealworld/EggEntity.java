package ga.overfullstack.hellorealworld;

import java.util.HashMap;
import java.util.Map;

/** A dummy legacy class */
public class EggEntity {

  private final Map<String, String> data = new HashMap<>();

  public void put(String field, String value) {
    data.put(field, value);
  }

  public String get(String field) {
    return data.get(field);
  }
}
