package tw.demo.annotation;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @ClassName: ValidateRequiredUtils
 * @date Mar 27, 2019 8:36:56 PM
 * @author ToniR
 * @Description: 字段校验
 */
public class ValidateRequiredUtils {

	/**
	 * 注解在字段上
	 * 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static String validateField(Object obj) throws IllegalArgumentException, IllegalAccessException {
		StringBuffer message = new StringBuffer();
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Object object = field.get(obj);
			if (!field.isAnnotationPresent(ValidateParameter.class)) {
				continue;
			}
			// 判空
			if (object == null || "".equals(String.valueOf(object).trim())) {
				message.append(field.getName() + "不能为空");
				break;
			}
			// 判断长度
			int maxLen = field.getAnnotation(ValidateParameter.class).maxLen();
			if (maxLen != 0 && String.valueOf(object).trim().length() > maxLen) {
				message.append(field.getName() + "不能超过限制长度");
				break;
			}
			int minLen = field.getAnnotation(ValidateParameter.class).minLen();
			if (minLen != 0 && String.valueOf(object).trim().length() < minLen) {
				message.append(field.getName() + "不能小于限制长度");
				break;
			}
			// 判断正则表达式
			String reg = field.getAnnotation(ValidateParameter.class).reg();
			if (!StringUtils.isEmpty(reg) && !EtcBaseUtil.regCheck(reg, String.valueOf(object))) {
				message.append(field.getName() + "不符合规范");
				break;
			}
		}
		return message.toString();
	}

	/**
	 * 注解在字段上
	 * 
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static String validateField(Object obj, Class<?> groupClass)
			throws IllegalArgumentException, IllegalAccessException {
		StringBuffer message = new StringBuffer();
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Object object = field.get(obj);
			if (!field.isAnnotationPresent(ValidateParameter.class)) {
				continue;
			}
			for (Class<?> group : field.getAnnotation(ValidateParameter.class).groups()) {
				if (!group.isAssignableFrom(groupClass)) {
					continue;
				}
				// 判空
				if (object == null || "".equals(String.valueOf(object).trim())) {
					message.append(field.getName() + "不能为空");
					return message.toString();
				}
				// 判断长度
				int maxLen = field.getAnnotation(ValidateParameter.class).maxLen();
				if (maxLen != 0 && String.valueOf(object).trim().length() > maxLen) {
					message.append(field.getName() + "不能超过限制长度");
					return message.toString();
				}
				int minLen = field.getAnnotation(ValidateParameter.class).minLen();
				if (minLen != 0 && String.valueOf(object).trim().length() < minLen) {
					message.append(field.getName() + "不能小于限制长度");
					return message.toString();
				}
				// 判断正则表达式
				String reg = field.getAnnotation(ValidateParameter.class).reg();
				if (!StringUtils.isEmpty(reg) && !EtcBaseUtil.regCheck(reg, String.valueOf(object))) {
					message.append(field.getName() + "不符合规范");
					return message.toString();
				}
			}
		}
		return message.toString();
	}

}
