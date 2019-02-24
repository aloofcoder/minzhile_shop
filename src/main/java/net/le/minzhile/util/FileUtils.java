package net.le.minzhile.util;

import java.io.*;

/**
 * @Author hanle
 * @Date 2019/1/31 17:12
 * @E-mail hanl1946@163.com
 */
public class FileUtils {

    /**
     * 保存文件
     * @return
     */
    public static String saveFile(String url, String name, String content) {
        String fileUrl = url;
        // 判断是否存在该文件夹
        String nowDate = DateUtils.getNowDate();
        fileUrl = fileUrl + "/" + nowDate;
        File dateDir = new File(fileUrl);
        if (!dateDir.exists()) {
            dateDir.mkdirs();
        }
        OutputStream os = null;
        try {
            fileUrl = fileUrl + "/" + name;
            os = new FileOutputStream(fileUrl);
            BufferedOutputStream buf = new BufferedOutputStream(os);
            buf.write(content.getBytes("UTF-8"));
            buf.flush();
            buf.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileUrl;
    }
}
