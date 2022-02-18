package ga.overfullstack.hellorealworld;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Before {

  void eggService(List<Egg> eggsFromRequest) {
    var failureMap = new HashMap<ID, Failure>();
    filterDuplicates(failureMap, eggsFromRequest);

    var nonDuplicateEggs = new ArrayList<Egg>();
    for (Egg egg : eggsFromRequest) {
      if (!failureMap.containsKey(egg.getId())) {
        nonDuplicateEggs.add(egg);
      }
    }

    validate(failureMap, nonDuplicateEggs);

    var validEggs = new ArrayList<Egg>();
    for (Egg egg : nonDuplicateEggs) {
      if (!failureMap.containsKey(egg.getId())) {
        nonDuplicateEggs.add(egg);
      }
    }

    var eggEntityObjs = toEntityObjs(validEggs);

    try {
      bulkInsertIntoDB(eggEntityObjs);
    } catch (DMLOperationException ex) {
      handlePartialFailures(failureMap, ex);
    }

    // Prepare response from `failureMap` and db insertion results
  }

  // Dummy Function
  private void handlePartialFailures(HashMap<ID, Failure> failureMap, DMLOperationException ex) {
  }

  // Dummy Function
  void filterDuplicates(Map<ID, Failure> failureMap, List<Egg> eggsFromRequest) {
  }

  // Dummy Function
  void validate(Map<ID, Failure> failureMap, List<Egg> nonDuplicateEggs) {
  }

  // Dummy Function
  List<EggEntity> toEntityObjs(List<Egg> validEggs) {
    return new ArrayList<>();
  }

  // Dummy Function
  void bulkInsertIntoDB(List<EggEntity> eggEntityObjs) throws DMLOperationException {
  }

  enum Failure {
    ROTTEN,
    FIELD_1_ERROR
  }

  static class ID {

    int value;

    ID(int value) {
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      ID id = (ID) o;

      return value == id.value;
    }

    @Override
    public int hashCode() {
      return value;
    }
  }

  private static class Egg {

    private ID id;
    private Date date;

    private Egg(ID id, Date date) {
      this.id = id;
      this.date = date;
    }

    public ID getId() {
      return id;
    }

    public Date getDate() {
      return date;
    }

    @Override
    public String toString() {
      return "Egg{" + "id=" + id + ", date=" + date + '}';
    }
  }

  private static class DMLOperationException extends Exception {

  }
}
