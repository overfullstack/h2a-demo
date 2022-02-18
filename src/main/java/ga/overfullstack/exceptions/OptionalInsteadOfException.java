package ga.overfullstack.exceptions;

import static ga.overfullstack.exceptions.OptionalInsteadOfException.Access.ACCESS_1;
import static ga.overfullstack.exceptions.OptionalInsteadOfException.Access.ACCESS_2;
import static ga.overfullstack.exceptions.OptionalInsteadOfException.Access.ACCESS_3;

import java.util.Optional;

/**
 * Dummy code for Obstacle-1 Throw away exceptions.
 */
public class OptionalInsteadOfException {

  void verifyUserAccess(String userId) throws NoAccessException {
    if (!hasAccess1(userId)) {
      throw new NoAccessException(ACCESS_1);
    }
    if (!hasAccess2(userId)) {
      throw new NoAccessException(ACCESS_2);
    }
    if (!hasAccess3(userId)) {
      throw new NoAccessException(ACCESS_3);
    }
  }

  Optional<NoAccessException> verifyUserAccessWithAdt(String userId) {
    if (!hasAccess1(userId)) {
      return Optional.of(new NoAccessException(ACCESS_1));
    }
    if (!hasAccess2(userId)) {
      return Optional.of(new NoAccessException(ACCESS_2));
    }
    if (!hasAccess3(userId)) {
      return Optional.of(new NoAccessException(ACCESS_3));
    }
    return Optional.empty();
  }

  // Dummy function
  private boolean hasAccess3(String userId) {
    return false;
  }

  // Dummy function
  private boolean hasAccess2(String userId) {
    return false;
  }

  // Dummy function
  private boolean hasAccess1(String userId) {
    return false;
  }

  enum Access {
    ACCESS_1,
    ACCESS_2,
    ACCESS_3
  }

  private static class NoAccessException extends Exception {

    NoAccessException(Access access3) {
    }
  }
}
