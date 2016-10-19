import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface RemoteObject {

    public String value() default "RemoteInterface";
}
