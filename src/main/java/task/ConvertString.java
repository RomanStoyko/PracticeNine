package task;


import java.util.function.Function;

@FunctionalInterface
public interface ConvertString<T,R>
{
    R convert(T t);

    static boolean isExist(String s){
        Function<String, Boolean> pred = s::equals;
        return !pred.apply(null);
    }
}
