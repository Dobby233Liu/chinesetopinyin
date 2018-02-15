package com.l.chinesetopinyin.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * the code became here: http://blog.csdn.net/hfhwfw/article/details/6030816
 * @author unknown
**/
public class To {
    /**
	* Util to convert String to Pinyin (string).
	* @param inputString
	* @return Pinyin string with no English char lost but the specials.
	**/
	public static String getPinYin(String inputString) {

	HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
	format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
	format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
	format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

	char[] input = inputString.trim().toCharArray();
	StringBuffer output = new StringBuffer("");

	try {
	for (int i = 0; i < input.length; i++) {
	if (Character.toString(input[i]).matches("[\u4E00-\u9FA5]+")) {
	String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
	output.append(temp[0]);
	output.append(" ");
	} else
		output.append(Character.toString(input[i]));
	}
	} catch (BadHanyuPinyinOutputFormatCombination e) {
	e.printStackTrace();
	}
	return output.toString();
	}

	

}
