package com.chinasofti.common.test;

import org.apache.shiro.crypto.hash.SimpleHash;

public class PwdGenerator {

    static String algorithmName  = "md5";
    static String salt2          = "67891";
    static int    hashIterations = 2;
    static int    count          = 0;
    //    static String username       = "admin";
    //    static String hashKey        = "3a0a7f07077035a376f855c12b728d60";
    static String username       = "guoyu";
    static String hashKey        = "165e9ea6df2b0e787f416d65290253f0";

    public static void main(String[] args) {
        exhaustive();
    }

    public static Boolean testGeneratePassword2(String password) {
        SimpleHash hash = new SimpleHash(algorithmName, password, username + salt2, hashIterations);
        if (hash.toHex().equals(hashKey)) {
            return true;
        }
        return false;
    }

    /**
     * 
    * <p>Title: exhaustive </p>
    * <p>Description: 穷举 </p>    参数说明
    * @author lijun
    * @date 2017年12月1日
     */
    public static void exhaustive() {
        //字母数字组合
        /*String a[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
                "z" };
        String b[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
                "z" };
        String c[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
                "z" };
        String d[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
                "z" };
        String e[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
                "z" };
        String f[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
                "z" };*/
        //纯数字
        String a[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
        String b[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
        String c[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
        String d[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
        String e[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
        String f[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
        String g[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
        String h[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
        //纯字母
        /*String a[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        String b[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        String c[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        String d[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        String e[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        String f[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };*/
        //第1层循环，处理1位字符的密码
        for (String ax : a) {
            String key1 = ax;
            if (testGeneratePassword2(key1)) {
                System.out.println("破解成功!!!  " + username + "密码为：" + key1);
                break;
            }
            //每隔1万打印一次
            if (count % 10000 == 0) {
                System.out.println("当前位置" + key1 + "___" + "当前系统时间" + System.currentTimeMillis());
            }
            count = count + 1;
            //第2层循环，处理2位字符的密码
            for (String bx : b) {
                String key2 = ax + bx;
                if (testGeneratePassword2(key2)) {
                    System.out.println("破解成功!!!  " + username + "密码为：" + key2);
                    break;
                }
                //每隔1万打印一次
                if (count % 10000 == 0) {
                    System.out.println("当前位置" + key2 + "___" + "当前系统时间" + System.currentTimeMillis());
                }
                count = count + 1;
                //第3层循环，处理3位字符的密码
                for (String cx : c) {
                    String key3 = ax + bx + cx;
                    if (testGeneratePassword2(key3)) {
                        System.out.println("破解成功!!!  " + username + "密码为：" + key3);
                        break;
                    }
                    //每隔1万打印一次
                    if (count % 10000 == 0) {
                        System.out.println("当前位置" + key3 + "___" + "当前系统时间" + System.currentTimeMillis());
                    }
                    count = count + 1;
                    //第4层循环，处理4位字符的密码
                    for (String dx : d) {
                        String key4 = ax + bx + cx + dx;
                        if (testGeneratePassword2(key3)) {
                            System.out.println("破解成功!!!  " + username + "密码为：" + key4);
                            break;
                        }
                        //每隔1万打印一次
                        if (count % 10000 == 0) {
                            System.out.println("当前位置" + key4 + "___" + "当前系统时间" + System.currentTimeMillis());
                        }
                        count = count + 1;
                        //第5层循环，处理5位字符的密码
                        for (String ex : e) {
                            String key5 = ax + bx + cx + dx + ex;
                            if (testGeneratePassword2(key3)) {
                                System.out.println("破解成功!!!  " + username + "密码为：" + key5);
                                break;
                            }
                            //每隔1万打印一次
                            if (count % 10000 == 0) {
                                System.out.println("当前位置" + key5 + "___" + "当前系统时间" + System.currentTimeMillis());
                            }
                            count = count + 1;
                            //第6层循环，处理6位字符的密码
                            for (String fx : f) {
                                String key6 = ax + bx + cx + dx + ex + fx;
                                if (testGeneratePassword2(key3)) {
                                    System.out.println("破解成功!!!  " + username + "密码为：" + key6);
                                    break;
                                }
                                //每隔1万打印一次
                                if (count % 10000 == 0) {
                                    System.out.println("当前位置" + key6 + "___" + "当前系统时间" + System.currentTimeMillis());
                                }
                                count = count + 1;
                                //第7层循环，处理7位字符的密码
                                for (String gx : g) {
                                    String key7 = ax + bx + cx + dx + ex + fx + gx;
                                    if (testGeneratePassword2(key3)) {
                                        System.out.println("破解成功!!!  " + username + "密码为：" + key7);
                                        break;
                                    }
                                    //每隔1万打印一次
                                    if (count % 10000 == 0) {
                                        System.out.println("当前位置" + key7 + "___" + "当前系统时间" + System.currentTimeMillis());
                                    }
                                    count = count + 1;
                                    //第8层循环，处理8位字符的密码
                                    for (String hx : f) {
                                        String key8 = ax + bx + cx + dx + ex + fx+gx+hx;
                                        if (testGeneratePassword2(key3)) {
                                            System.out.println("破解成功!!!  " + username + "密码为：" + key8);
                                            break;
                                        }
                                        //每隔1万打印一次
                                        if (count % 10000 == 0) {
                                            System.out.println("当前位置" + key8 + "___" + "当前系统时间" + System.currentTimeMillis());
                                        }
                                        count = count + 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
