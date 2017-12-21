package chenshuai.bwie.com.splashactivity.net;

/**
 * Created by peng on 2017/12/1.
 */

public interface Api {
    boolean ISONLINE = true;
    String DEV = "http://169.27.23.105";
    public static String ONLINE = "http://120.27.23.105";

    public static String HOST = ISONLINE ? ONLINE : DEV;
    public static String ADD_CARD = HOST + "/product/addCart";
    public static String SELECT_CARD = HOST + "/product/getCarts";
    public static String DEL_CARD = HOST + "/product/deleteCart";
}
