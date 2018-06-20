package Study.annotation;

@MyFirstAnnotation(value = "abc")
public class AnnotationTest {
    public static void main(String[] args) {
        if (AnnotationTest.class.isAnnotationPresent(MyFirstAnnotation.class)) {
            MyFirstAnnotation mf = AnnotationTest.class.getAnnotation(MyFirstAnnotation.class);
            System.out.println(mf.color() + "\t" + mf.value());
            System.out.println(mf.arrayAttr());
            System.out.println(mf.retAnno().value());
            System.out.println(mf.retEnum());
        }
    }
}
