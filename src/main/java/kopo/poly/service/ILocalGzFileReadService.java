package kopo.poly.service.impl;

import kopo.poly.dto.HadoopDTO;

import java.util.List;

public interface ILocalGzFileReadService {

    /**
     * Gz 파일의 최초 기준 라인수만큼 증가
     * 예 : zcat access_log.gz | head -n 10
     */
    List<String> readLocalGzFileCnt(HadoopDTO pDTO) throws Exception;

    /**
     * Gz 파일의 IP 대역읽기
     * 예 : zcat access_log.gz | grep -E '10/.56/.[0-9]{1,3}\.[0-9]{1,3}'
     */
    List<String> readLocalGzFileIP(HadoopDTO pDTO) throws Exception;
}
