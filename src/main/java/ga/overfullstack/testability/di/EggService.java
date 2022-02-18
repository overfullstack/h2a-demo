package ga.overfullstack.testability.di;

import ga.overfullstack.hellorealworld.EggEntity;
import ga.overfullstack.testability.ID;
import ga.overfullstack.testability.ImmutableID;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class EggService {

  private static final String EGG_REPO = "EggRepo";
  private static final String EGG_INSERTER = "EggInserter";

  @Autowired
  public EggService(@Qualifier(EGG_REPO) EggRepo eggRepo) {
  }

  @Autowired
  public EggService(@Qualifier(EGG_INSERTER) Function<EggEntity, ID> dbInserter) {
  }

  // Main config
  @Bean(EGG_INSERTER)
  public Function<EggEntity, ID> insert(
      @Qualifier(EGG_REPO) EggRepo eggRepo) {
    return eggRepo::insert;
  }

  // Test Config
  @Bean(EGG_INSERTER)
  public Function<EggEntity, ID> insertNoOp() {
    return eggEntity -> ImmutableID.of(1); // stub
  }
}
