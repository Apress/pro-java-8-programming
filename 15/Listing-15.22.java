import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Repeatable(CodeModification.class)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface CodeModification {
    public String programmerName();
    public String explanation();
}
