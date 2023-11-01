package kopo.poly.service.impl;

import kopo.poly.dto.HadoopDTO;
import kopo.poly.service.AbstractHadoopConf;
import kopo.poly.service.IHdfsFileReadService;
import kopo.poly.utill.CmmUtil;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Service;
import sun.java2d.cmm.kcms.CMM;

@Log4j
@Service
public class HdfsFileReadService extends AbstractHadoopConf
        implements IHdfsFileReadService {
    @Override
    public String readHdfsFile(HadoopDTO pDTO) throws Exception {

        log.info(this.getClass().getName() + "readHdfsFile Start !");

        // 하둡 분산 파일 시스템 객체
        FileSystem hdfs = FileSystem.get(this.getHadoopConfiguration());

        // 하둡분산파일시스템에 저장될 파일경로 및 폴더명
        String hadoopFile = CmmUtil.nvl(pDTO.getHadoopUploadPath() + "/" + CmmUtil.nvl(pDTO.getHadoopUploadFileName()));

        Path path = new Path(hadoopFile);

        log.info("HDFS Exists : " + hdfs.exists(path));

        String readLog = "";

        if (hdfs.exists(path)) {
            FSDataInputStream inputStream = hdfs.open(path);
            readLog = inputStream.readUTF();
            inputStream.close();
        }

        log.info(this.getClass().getName() + "readHdfsFile End !");

        return readLog;
    }
}
