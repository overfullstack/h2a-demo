package ga.overfullstack;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;

@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@Value.Style(
    typeImmutable = "*",
    typeAbstract = {"*Def"},
    //    builder = "configure",
    //    build = "done",
    depluralize = true,
    allParameters = true,
    add = "",
    visibility = ImplementationVisibility.PUBLIC)
public @interface MyStyle {}
