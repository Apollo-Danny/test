package tw.demo.annotation;

import java.util.regex.Pattern;

/**
 * @ClassName: PatternConfig
 * @date Apr 25, 2019 12:48:00 AM
 * @author ToniR
 * @Description: 正则判断配置
 */
public class PatternConfig {

	/**
	 * 卡号正则
	 */
	public static final Pattern CARD_PATTERN = Pattern.compile("^[0-9]{16}$|^[0-9]{20}$");

	/**
	 * obu正则
	 */
	public static final Pattern OBU_PATTERN = Pattern.compile("^[0-9]*$");

	/**
	 * 快递单号正则
	 */
	public static final Pattern DELIVERY_PATTERN = Pattern.compile("^[a-zA-Z0-9]{8,16}$");

	/**
	 * 手机号正则
	 */
	public static final Pattern MOBILE_PATTERN = Pattern.compile("^[1][3,4,5,6,7,8][0-9]{9}$");

}
