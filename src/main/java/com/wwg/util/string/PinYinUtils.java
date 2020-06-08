package com.wwg.util.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 拼音工具类
 * 
 * @author wxm
 */
public class PinYinUtils {

    public static final Logger logger = Logger.getLogger(PinYinUtils.class);

    /**
     * 获取字符串拼音的第一个字母
     * 
     * @param chinese
     * @return
     */
    public static String ToFirstChar(String chinese) {
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray(); // 转为单个字符
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] > 128) {
                try {
                    pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0].charAt(0);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinStr += newChar[i];
            }
        }
        return pinyinStr;
    }

    /**
     * 汉字转为拼音 不考虑多音字处理
     * 
     * @param chinese
     * @return
     */
    public static String ToPinyin1(String chinese) {
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        try {
            for (int i = 0; i < newChar.length; i++) {
//                List<String> strs = new ArrayList<>();
                if (newChar[i] > 128) {
                    if (regEx(String.valueOf(newChar[i]))) {
                        pinyinStr += newChar[i];
                    } else {
                        pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0];
                    }
                } else {
                    pinyinStr += newChar[i];
                }
            }
        } catch (Exception e) {
            logger.error("汉字转拼音异常：" + chinese);
        }
        return pinyinStr;
    }

    /**
     * 汉字转为拼音 考虑多音字处理
     * 
     * @param chinese
     * @return
     */
    public static String ToPinyin2(String chinese) {
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        List<List<String>> list = new ArrayList<>();
        try {
            for (int i = 0; i < newChar.length; i++) {
                List<String> strs = new ArrayList<>();
                if (newChar[i] > 128) {
                    if (regEx(String.valueOf(newChar[i]))) {
                        strs.add(String.valueOf(newChar[i]));
                    } else {
                        int num = PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat).length;
                        for (int j = 0; j < num; j++) {
                            strs.add(PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[j]);
                        }
                    }
                } else {
                    strs.add(String.valueOf(newChar[i]));
                }
                list.add(strs);
            }
        } catch (Exception e) {
            logger.error("汉字转拼音异常：" + chinese);
        }
        pinyinStr = strArray(list).toString();
        return pinyinStr;
    }

    public static boolean regEx(String s) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        return m.find();
    }

    public static Set<String> strArray(List<List<String>> list) {
        if (list == null || list.isEmpty()) {
            return new HashSet<String>();
        }
        Set<String> set = new HashSet<String>();
        for (List<String> item : list) {
            set = splice(item, set);
        }
        return set;
    }

    private static Set<String> splice(List<String> item, Set<String> set) {
        Set<String> result = new HashSet<String>();
        for (String str1 : item) {
            if (set.isEmpty()) {
                result.add(str1);
                continue;
            }
            for (String str2 : set) {
                result.add(str2 + str1);
            }
        }
        return result;
    }

    /**
     * 测试main方法
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(ToFirstChar("汉字转换为拼音").toUpperCase()); // 转为首字母大写
        System.out.println("结果：" + ToPinyin2("解和景都是多音字(小)"));
    }
}
