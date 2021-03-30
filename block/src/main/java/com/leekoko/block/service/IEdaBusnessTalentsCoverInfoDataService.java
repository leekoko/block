package com.leekoko.block.service;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Map;

public interface IEdaBusnessTalentsCoverInfoDataService {

    @RequestLine("GET /busness-talents/cover-info/getDataByCode?code={code}")
    Map getDataByCode(@Param("code") String code);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestLine("POST /busness-talents/cover-info/delete")
    void delete(EdaBusnessTalentsCoverInfo edaBusnessTalentsCoverInfo);
}
