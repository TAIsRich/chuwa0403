# Annotations, a form of metadata, provide data about a program that is not part of the program itself. Annotations have no direct effect on the operation of the code they annotate.
# Annotations can be applied to declarations: declarations of classes, fields, methods, and other program elements. When used on a declaration, each annotation often appears, by convention, on its own line.
# 1. @Entity
## This is a marker annotation which indicates that this class is an entity. This annotation must be placed on the class name.
```
@Entity  
public class XXXXX {  
```
# 2. @Override
## This annotation indicates that the child class method is over-writing its base class method.
```
class ChildClass extends BaseClass {
   @Override 
   public void display() {
      System.out.println("In the child class, test() method");
   }
}
```
# 3. @Author
## This can include elements, which can be named or unnamed, and there are values for those elements.
```
@Author(
   name = "Benjamin Franklin",
   date = "3/27/2003"
)
```
# 4. @ClassPreamble
## This adds additional Documentation. 
```
@ClassPreamble (
    author = "John Doe",
    date = "3/17/2002",
    currentRevision = 6,
    lastModified = "4/12/2004",
    lastModifiedBy = "Jane Doe"
    reviewers = {"Alice", "Bob", "Cindy"} // Note array notation
    )
```
# 5. @SuppressWarnings
## This annotation allows us to say which kinds of warnings to ignore. While warning types can vary by compiler vendor, the two most common are deprecation and unchecked.
```
public class Machine {
    private List versions;

    @SuppressWarnings("unchecked")
    // or
    @SuppressWarnings({"unchecked"})
    public void addVersion(String version) {
        versions.add(version);
    }
}
```
# 6. @Repeatable
## This allows you to repeating annotations in your source code.
```
@Repeatable(Role.List.class)
public @interface Role {
    String value();
    @interface List {
        Role[] value();
    }
}
```
# 7. @NonNull
## This is useful for your IDE to warn you of potentially null pointer errors.
```
public void directPathToA(@Nonnull Integer x){
        x.toString();       
    }
```
# 8. @Readonly
## Use this to specify that a class is read-only.
```
@ReadOnly
public class ReadOnlyEntity {
...
}
```
# 9. @Inherited
## This annotation used to mark an annotation to be inherited to subclasses of the annotated class.
```
@Inherited
public @interface MyAnnotation {// code of the MyAnnotation
}
```
# 10. @Documented
## WE use this annotation to annotate our custom annotations. It is a meta-annotation provided in java.lang.annotation package.
```
import java.lang.annotation.Documented;
@Documented @interface CustomAnnotation { String value(); }
@CustomAnnotation("GFG")
public class GFG {
    public static void main(String[] args)
    {
        System.out.println("This is the main function");
    }
}
```
# 11. @Deprecated
## The annotation conveys to developers that they are discouraged from using the elements that are annotated with the @Deprecated annotation.
```
public class Main {
    @Deprecated(since = "2.1", forRemoval = true)
    public int fibonacci(int n){
        System.out.println("Calculate Fibonacci");
        return 0;
    }
    public static void main(String args[]){
        Main obj = new Main();
        obj.fibonacci(100);
    }
}
```
# 12. @SafeVarargs
## This allows us to declare that a particular compiler warning is a false positive.
```
public class Machine<T> {
    private List<T> versions = new ArrayList<>();
    @SafeVarargs
    public final void safe(T... toAdd) {
        for (T version : toAdd) {
            versions.add(version);
        }
    }
}
```
# 13. @FunctionalInterface
## This is used for an Interface that contains exactly one abstract method is known as functional interface.
```
@FunctionalInterface
public interface ShortToByteFunction {
    byte applyAsByte(short s);

}
```
# 14. @Retention
## @Retention is also a meta-annotation that comes with some retention policies. These retention policies determine at which point an annotation is discarded. There are three types of retention policies: SOURCE, CLASS, and RUNTIME.
```
@Retention(RetentionPolicy.CLASS)
```
# 15. @Target
## It takes ElementType enumeration as its only argument. ElementType enumeration is a constant which specifies the type of the program element declaration (class, interface, constructor, etc.) to which the annotation can be applied.
```
@Target({ ElementType.METHOD, ElementType.TYPE,
          ElementType.ANNOTATION_TYPE,
          ElementType.CONSTRUCTOR })
```
# 16. @Interface
## This is used to declare an annotation.
```
@interface MyAnnotation{}  
```