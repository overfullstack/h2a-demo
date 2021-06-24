package ga.overfullstack.hellorealworld;

import java.util.*;

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

    private void handlePartialFailures(HashMap<ID, Failure> failureMap, DMLOperationException ex) {
      
    }

    void filterDuplicates(Map<ID, Failure> failureMap, List<Egg> eggsFromRequest) {}

  void validate(Map<ID, Failure> failureMap, List<Egg> nonDuplicateEggs) {}

  List<EggEntity> toEntityObjs(List<Egg> validEggs) {
    return new ArrayList<>();
  }

  void bulkInsertIntoDB(List<EggEntity> eggEntityObjs) throws DMLOperationException {}

  static class ID {
    int id;

    ID(int id) {
      this.id = id;
    }
  }

  private static class Egg {
    private int id;
    private Date date;

    private Egg(int id, Date date) {
      this.id = id;
      this.date = date;
    }

    public int getId() {
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

  enum Failure {
    ROTTEN,
    FIELD_1_ERROR
  }

  private static class DMLOperationException extends Exception {}
}
