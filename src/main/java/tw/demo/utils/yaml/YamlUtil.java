package tw.demo.utils.yaml;

import org.springframework.util.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * @description: ymal文件处理
 * @author: baixiaobai
 * @className: YamlUtil
 * @Date: 2019/7/9
 * @Time: 下午5:55
 */
public class YamlUtil {

	private static Map<String, Object> map;

	static {
		Yaml yaml = new Yaml();
		InputStream inStream = YamlUtil.class.getClassLoader().getResourceAsStream("application.yml");
		map = yaml.load(inStream);
	}

	/**
	 * @description: TODO
	 * @methodName:
	 * @return:
	 * @throws
	 * @author:  baixiaobai
	 * @date:  2019/7/9 下午5:54
	 */
	public static <T> T wrapYamlValue(String yamlKey, Class<T> resultType) {
		Map<String, Object> mapWrap = map;
		return getYmalData(mapWrap, yamlKey, resultType);
	}

	/**
	 * @description: TODO
	 * @methodName:
	 * @return:
	 * @throws
	 * @author:  baixiaobai
	 * @date:  2019/7/9 下午5:54
	 */
	@SuppressWarnings("unchecked")
	private static <T> T getYmalData(Map<String, Object> mapWrap, String yamlKey, Class<T> resultType) {
		String[] pushKey = StringUtils.split(yamlKey, ":");
		if (pushKey != null) {
			Map<String, Object> value = (Map<String, Object>) mapWrap.get(pushKey[0]);
			return getYmalData(value, pushKey[1], resultType);
		}
		Object object = mapWrap.get(yamlKey);
		if (StringUtils.isEmpty(object)) {
			return (T) "";
		}
		return (T) object;
	}

}
