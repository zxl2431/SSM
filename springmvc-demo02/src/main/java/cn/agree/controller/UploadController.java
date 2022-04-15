package cn.agree.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @RequestMapping(value = "/servlet/image")
    public String servletUpload(HttpServletRequest request, HttpSession session) throws Exception {

        // 获取images的目录路径
        String realPath = session.getServletContext().getRealPath("/images");
        String randName = UUID.randomUUID().toString().replace("-","");

        // 文件上传磁盘处理的工程对象
        // 1G文件 ---> 加载到内存 --->超过10M ---> 将文件切割存放到临时文件夹中
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 文件解析对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        // 解析文件上传信息
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);

        // 循环判断每个表单对象是否是文件上传表单对象
        for (FileItem fileItem : fileItems) {
            // 如果返回true, 表示非文件上传表单, 如果返回false,表示文件上传表单
            boolean bo = fileItem.isFormField();

            if (!bo) {
                // 文件真实名字
                String fieldName = fileItem.getName();
                // 获取扩展名
                String suffix = StringUtils.getFilenameExtension(fieldName);

                // 文件上传
                fileItem.write(new File(realPath+"/"+randName+"."+suffix));
                // 删除临时文件
                fileItem.delete();
            }
        }

        return "add_user";

    }


}
