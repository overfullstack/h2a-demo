package ga.overfullstack.exceptions;

import io.vavr.control.Either;

public class EitherInsteadOfException {

  int parse(String s) {
    if (s.matches("-?[0-9]+")) {
      return Integer.parseInt(s);
    }
    throw new NumberFormatException("Not a valid integer");
  }

  Either<NumberFormatException, Integer> parseWithEither(String s) {
    if (s.matches("-?[0-9]+")) {
      return Either.right(Integer.parseInt(s));
    }
    return Either.left(new NumberFormatException("Not a valid integer"));
  }

}
