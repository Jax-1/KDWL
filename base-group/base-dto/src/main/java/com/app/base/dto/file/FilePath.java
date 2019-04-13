package com.app.base.dto.file;

    import java.io.Serializable;

    import com.baomidou.mybatisplus.annotations.TableField;
    import com.baomidou.mybatisplus.activerecord.Model;
    import com.baomidou.mybatisplus.annotations.TableName;
    import com.app.commom.dto.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : FilePath 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-13
 */
@TableName("t_sys_file_path")
public class FilePath extends IBaseBean {

private static final long serialVersionUID = 1L;

    /**
     * 文件名
     */
    @ApiModelProperty("文件名")
    @TableField("file_name")
        private String fileName;
    /**
     * 文件类型
     */
    @ApiModelProperty("文件类型")
    @TableField("file_type")
        private String fileType;
    /**
     * 服务器文件名(全)
     */
    @ApiModelProperty("服务器文件名(全)")
    @TableField("file_path")
        private String filePath;
    /**
     * 父Id
     */
    @ApiModelProperty("父Id")
        private String pid;
    /**
     * 文件大小
     */
    @ApiModelProperty("文件大小")
    @TableField("file_size")
        private String fileSize;
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    @TableField("create_by")
        private String createBy;
    @TableField("update_by")
        private String updateBy;


    public String getFileName() {
            return fileName;
            }

        public void setFileName(String fileName) {
            this.fileName = fileName;
            }

    public String getFileType() {
            return fileType;
            }

        public void setFileType(String fileType) {
            this.fileType = fileType;
            }

    public String getFilePath() {
            return filePath;
            }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
            }

    public String getPid() {
            return pid;
            }

        public void setPid(String pid) {
            this.pid = pid;
            }

    public String getFileSize() {
            return fileSize;
            }

        public void setFileSize(String fileSize) {
            this.fileSize = fileSize;
            }

    public String getCreateBy() {
            return createBy;
            }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
            }

    public String getUpdateBy() {
            return updateBy;
            }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
            }


@Override
public String toString() {
        return "FilePath{" +
                ", fileName=" + fileName +
                ", fileType=" + fileType +
                ", filePath=" + filePath +
                ", pid=" + pid +
                ", fileSize=" + fileSize +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
        "}";
        }
        }