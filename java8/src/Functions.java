import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;

public class Functions {

    public static void main(String[] args) {

        // java 8
        Function<Double,Double> s = Math::sin; //(x)-> "---> "+x;

        // java <8
        Func<Double,Double> s2 = new Func<Double, Double>() {
            @Override
            public Double apply(Double value) {
                return Math.sin(value);
            }
        };

        Func<Double,Double> s3 = Math::sin;

        System.out.println(s.apply(3.14));
        System.out.println(s2.apply(3.14));
        System.out.println(s3.apply(3.14));

    }

}

interface Func<T,R> {
    R apply(T value);
}
