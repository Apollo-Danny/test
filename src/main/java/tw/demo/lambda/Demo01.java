package tw.demo.lambda;

import com.alibaba.fastjson.JSONArray;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: baixiaobai
 * @className: Demo01
 * @Date: 2019/7/11
 * @Time: 下午3:52
 */
public class Demo01 {


    public static void main(String[] args) {


        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers2.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(Collectors.toList());
        System.out.println(pairs.get(0).length);


        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1",123);
//
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.parallelStream().filter( str -> !str.isEmpty()).collect(Collectors.toList());
        System.out.println(JSONArray.toJSON(filtered));
//
//
//        List<String> list = Arrays.asList("1", "2");
//        List<String> collect = list.stream().filter(string -> "2".equals(string)).collect(Collectors.toList());
//        System.out.println(JSONArray.toJSON(collect));
//
//
//        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);
//
//        List<Integer> integers = Arrays.asList(10, 11, 1, 2, 2);
//
//
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        int add = add(integers);
//        System.out.println(add);
//
//        for (Object value : objectObjectHashMap.values()) {
//
//        }


    }


    public static int add (List<Integer> values){
        return values.parallelStream().mapToInt(a -> a).sum();





    }
}
