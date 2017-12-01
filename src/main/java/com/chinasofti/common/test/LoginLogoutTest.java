package com.chinasofti.common.test;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.converters.AbstractConverter;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.chinasofti.common.base.Base;

import junit.framework.Assert;

/**
 * 
 * <p>Classname: LoginLogoutTest </p>   
 * <p>Description: TODO;</p>
 * @author lijun
 * @date 2017年11月30日
 */
public class LoginLogoutTest extends Base {

    @Test
    public void testJDBCRealm() {
        BeanUtilsBean.getInstance().getConvertUtils().register(new EnumConverter(), JdbcRealm.SaltStyle.class);
        login("classpath:shiro-jdbc-realm.ini", "slaw", "123");
        Subject subject = getSubject();
        //断言用户已经登录
        Assert.assertEquals(true, subject.isAuthenticated());
        //断言用户具有某个角色权限
        Assert.assertTrue(subject.hasRole("role2"));
        //判断拥有权限：user:view
        Assert.assertTrue(subject.isPermitted("user1:view"));
        //判断未拥有权限：user:update
        Assert.assertFalse(subject.isPermitted("user2:update"));
        //退出
        subject.logout();
    }

    /**
     * 
    * <p>Title: testGeneratePassword </p>
    * <p>Description: 加密算法 </p>    参数说明
    * @author lijun
    * @date 2017年11月30日
     */
    @Test
    public void testGeneratePassword() {
        String algorithmName = "md5";
        String username = "slaw";
        String password = "123";
        String salt1 = username;
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 2;
        SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);
        String encodedPassword = hash.toHex();
        System.out.println(salt2);
        System.out.println(encodedPassword);
    }

    @Test
    public void testGeneratePassword2() {
        String algorithmName = "md5";
        String username = "guoyu";
        String password = "1";
        String salt2 = "67891";
        int hashIterations = 2;
        for (int i = 0; i < 1000000; i++) {
            SimpleHash hash = new SimpleHash(algorithmName, String.valueOf(i), username + salt2, hashIterations);
            if (hash.toHex().equals("165e9ea6df2b0e787f416d65290253f0")) {
                System.out.println("破解成功!!!  " + username + "密码为：" + i);
                //break;
            }
            //每隔1万打印一次
            if (i % 10000 == 0) {
                System.out.println("当前位置" + i + "___" + "当前系统时间" + System.currentTimeMillis());
            }
        }
    }
    
    @Test
    public Boolean testGeneratePassword3(String password) {
        String algorithmName  = "md5";
        String salt2          = "67891";
        int    hashIterations = 2;
        password = "1";
        String username       = "admin";
        String hashKey        = "3a0a7f07077035a376f855c12b728d60";
        SimpleHash hash = new SimpleHash(algorithmName, password, username + salt2, hashIterations);
        if (hash.toHex().equals(hashKey)) {
            return true;
        }
        return false;
    }

    /**
     * 
     * <p>Classname: EnumConverter </p>
     * <p>Description: 猜测：是用来转换JDBC枚举类型的（jdbcRealm.saltStyle=COLUMN）;</p>
     * @author lijun
     * @date 2017年11月30日
     */
    private class EnumConverter extends AbstractConverter {

        @Override
        protected String convertToString(final Object value) throws Throwable {
            return ((Enum) value).name();
        }

        @Override
        protected Object convertToType(final Class type, final Object value) throws Throwable {
            return Enum.valueOf(type, value.toString());
        }

        @Override
        protected Class getDefaultType() {
            return null;
        }
    }
    /**
     * 
    * <p>Title: keyCrack </p>
    * <p>Description: 穷举破解法 </p>    参数说明
    * @author lijun
    * @date 2017年12月1日
     */
    public void keyCrack(){
        
    }
}
