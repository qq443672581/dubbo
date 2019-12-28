package cn.dlj1.world;


import java.util.Arrays;
import java.util.List;

/**
* 一个字符串是否包含 另一个字符串
*
* @auth fivewords(443672581@qq.com)
* @date 2019/9/30 17:36
*/
public class IndexOf {
    static String a = "abccd";
    static String b = "cbc";

    public static void main(String[] args) {
        String[] aArr = a.split("");
        String[] bArr = b.split("");

        boolean has = false;
        for (int i = 0; i <= aArr.length - bArr.length; i++) {
            List<String> list = Arrays.asList(bArr);
            for (int j = 0; j < bArr.length; j++) {
                if(!list.remove(aArr[i + j])){
                    break;
                }
            }
            if(list.size() == 0){
                has  = true;
            }
        }
        System.out.println(has);
    }

    //
}
