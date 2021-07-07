package ga.overfullstack.mutability;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@SuppressWarnings("deprecation")
public class MutableDSAsOutputParams {
  private static final Logger logger = LoggerFactory.getLogger(MutableDSAsOutputParams.class);

  Date getEggLayingDate(int eggId) {
    // heavy operation
    return queryEggLayingDateFromDB(eggId);
  }

  private Date queryEggLayingDateFromDB(int eggId) {
    return new GregorianCalendar(2021, Calendar.JUNE, 1).getTime();
  }

  // Dependent component - 1
  boolean isLaidInFirstHalf(int eggId) {
    var layingDate = getEggLayingDate(eggId);
    if (layingDate.getDate() < 15) {
      return true;
    }
    return false;
  }

  // Dependent component - 2
  int calculateEggAge(int eggId, Date today) {
    return today.getDate() - getEggLayingDate(eggId).getDate();
  }

  /* --- ONE DAY ---*/
  boolean isLaidInFirstHalf1(int eggId) {
    var layingDate = getEggLayingDate(eggId);
    if (layingDate.getDate() < 15) {
      // It's just logging, let's reuse the same Date obj for month and year
      layingDate.setDate(15); // Mutation 👹
      logger.info("This egg was laid before: " + layingDate);
      return true;
    }
    return false;
  }

  /* --- ANOTHER DAY --*/
  private static final Map<Integer, Date> eggLayingDateCacheById = new HashMap<>();

  public Date getEggLayingDate1(int eggId) {
    return eggLayingDateCacheById.computeIfAbsent(eggId, this::queryEggLayingDateFromDB);
  }

  /** BUG 🐞 */
  void printEggAge() {
    var eggId = 0;
    if (isLaidInFirstHalf1(eggId)) {
      final var age = calculateEggAge(eggId, new Date());
      System.out.println(age);
    }
  }
}
