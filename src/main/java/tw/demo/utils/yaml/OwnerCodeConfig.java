package tw.demo.utils.yaml;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ToniR
 * @ClassName: OwnerCodeConstant
 * @date Apr 4, 2019 5:51:02 PM
 * @Description: 省标识
 */
@Service
public class OwnerCodeConfig {

	@SuppressWarnings("unchecked")
	public static final Map<String, Integer> OWNER_CODES = YamlUtil.wrapYamlValue("owner", Map.class);

	/**
	 * @return Integer
	 * @author ToniR
	 * @title value
	 * @description 根据省名称获取省code
	 * @since Apr 10, 2019 11:40:41 AM
	 */
	public static Integer value(String provinceName) {
		Integer owner = OWNER_CODES.get(provinceName);
		if (owner == null) {
//			throw new TraweException("未查到配置省份");
		}
		return owner;
	}

	/**
	 * @author ToniR
	 * @since Jun 13, 2019 4:05:29 PM 
	 * @title getKey
	 * @description 根据省份编号,获取省份信息
	 * @return String
	 */
	public static String getKey(Integer ownerCode) {
		for (Map.Entry<String, Integer> entry : OWNER_CODES.entrySet()) {
			if (entry.getValue().equals(ownerCode)) {
				return entry.getKey();
			}
		}
//		throw new TraweException("未查到配置省份");
		return null;
	}
}
