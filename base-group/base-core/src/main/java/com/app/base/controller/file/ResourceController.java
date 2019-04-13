package com.app.base.controller.file;




import com.app.auth.util.ProcessDTO;
import com.app.base.dto.file.FilePath;
import com.app.base.fdfs.FastDFSClientWrapper;
import com.app.base.service.file.FilePathService;
import com.app.commom.logger.LoggerFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping("file")
@Api(value="/file", description="文件管理 控制器")
public class ResourceController {
    private final Logger logger = LoggerFactory.getLogger(FilePathController.class);

    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;

    @Autowired
    public FilePathService filePathService;

    @RequestMapping("/upload")
    @ResponseBody
    public FilePath uploadFile(@RequestParam("file") MultipartFile file,String parentId) throws IOException {
        byte[] bytes = file.getBytes();
        //文件名（全）
        String originalFileName = file.getOriginalFilename();
        //文件类型
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        //字段名
        String fileName = file.getName();
        //文件大小
        long fileSize = file.getSize();
        FilePath filePath= new FilePath();
        ProcessDTO.setBaseInfo(filePath);
        filePath.setPid(parentId);
        filePath.setFileName(originalFileName);
        filePath.setFileSize(Long.toString(file.getSize()));
        filePath.setFileType(extension);
        try{
            filePath.setFilePath(fastDFSClientWrapper.uploadFile(bytes, fileSize, extension));
        }catch (Exception e){
            logger.error("文件服务器异常！");
        }
        return filePath;
    }

    @RequestMapping("/download/{id}")
    @ApiOperation(value = "/download",notes="文件下载" )
    public void downloadFile(@PathVariable("id") String id,HttpServletResponse response) throws IOException {

        FilePath filePath=filePathService.selectById(id);
        byte[] bytes = fastDFSClientWrapper.downloadFile(filePath.getFilePath());
        // 这里只是为了整合fastdfs，所以写死了文件格式。需要在上传的时候保存文件名。下载的时候使用对应的格式
       // response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("sb.xlsx", "UTF-8"));
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
