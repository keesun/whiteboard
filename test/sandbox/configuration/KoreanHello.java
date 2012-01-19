package sandbox.configuration;

/**
 * @author Keesun Baik
 */
public class KoreanHello extends Hello {

    @Override
    public void sayHello() {
        System.out.println("안녕하세요. " + name);
    }
}
