package tw.demo;

import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: Demo02
 * @Date: 2020/7/7
 * @Time: 2:58 PM
 */
@Service("111")
@StoreUserBindHandel("456")
public class Demo02 implements Dee{

//    static {
//        System.out.println("demo02");
//    }

    public static void main(String[] args) {
//        System.out.println(Demo02.class.getName());
//
//
//        IntBuffer allocate = IntBuffer.allocate(4);
//        allocate.put(1);
//        allocate.put(2);
//        allocate.put(3);
//        allocate.put(4);
//
//        allocate.flip();
//        System.out.println(allocate.get());

//        AtomicInteger atomicInteger = new AtomicInteger();
//        System.out.println(atomicInteger);
//        String ss = "1324567891";
//        String aa = "1999999999";


//        List<String> list = Arrays.asList("123", "12344");
////                list.stream().filter(a -> a.length() > 1)
////                        .collect(Collectors.toList()).forEach(System.out::println);
////                list.stream().mapToInt(String::length);
//                list.stream().collect(Collectors.toList());
//        Method[] methods = new Demo02().getClass().getMethods();
//        for (Method method : methods) {
//
//            System.out.println(method);
//        }
//
//        String value = new Demo01().getClass().getAnnotation(StoreUserBindHandel.class).name();
//        System.out.println(value);
//        Integer cc = 1;
//        Integer bb = 2;
//        System.out.println(cc.equals(bb));


//        BigInteger bigInteger = BigInteger.valueOf(Integer.parseInt(ss));
//        BigInteger bigInteger2 = BigInteger.valueOf(Integer.parseInt(aa));
//        BigInteger add = bigInteger.add(bigInteger2);
//        System.out.println(add);


    }

    @Override
    public void aa() {
        System.out.println("demo02");
    }
}
