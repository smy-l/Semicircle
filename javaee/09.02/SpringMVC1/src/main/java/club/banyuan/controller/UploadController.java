package club.banyuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {
    @RequestMapping("/upload")
    public void upload(MultipartFile uploadFile,
                         HttpServletRequest request) throws IOException {
        // 获取文件名以及扩展名
        String originalName = uploadFile.getOriginalFilename();
        String ext = originalName.substring(originalName.lastIndexOf("."));

        // 更新文件名
        String uuid = UUID.randomUUID().toString().replace("-","");
        String fileName = uuid+ext;

        // 获取文件保存地址
        String path = request.getServletContext().getRealPath("uploads");
        System.out.println(path);

        // 保存文件
        uploadFile.transferTo(new File(path,fileName));

    }
}
