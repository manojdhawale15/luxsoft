package com.example.luxoft.controller;

import com.example.luxoft.services.NaceDetailsService;
import com.example.luxoft.util.CsvUtil;
import com.example.luxoft.model.NaceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NaceDetailsController {

    private final NaceDetailsService naceDetailsService;

    @Autowired
    NaceDetailsController(NaceDetailsService naceDetailsService){
        this.naceDetailsService = naceDetailsService;
    }

    @GetMapping("/naceDetails/{orderId}")
    NaceDetail getNaceDetails(@PathVariable int orderId) {
        return naceDetailsService.findByOrderId(orderId);
    }

    @PostMapping("/naceDetails")
    NaceDetail createOrSaveNaceDetails(@RequestBody NaceDetail naceDetail) {
        return naceDetailsService.save(naceDetail);
    }

    @PostMapping("/uploadCsv")
    void uploadNaceDetails() throws IOException {
        List<NaceDetail> fileData =  CsvUtil.readAll();
        System.out.println("File data entries "  + fileData.size());
        naceDetailsService.saveAll(fileData);

    }


    @PutMapping("/employees/{orderId}")
    NaceDetail updateEmployee(@RequestBody NaceDetail naceDetail, @PathVariable int orderId) {

         NaceDetail dbNaceDetail = naceDetailsService.findByOrderId(orderId);
        dbNaceDetail.setCode(naceDetail.getCode());
        dbNaceDetail.setDescription(naceDetail.getDescription());
        dbNaceDetail.setLevelId(naceDetail.getLevelId());
        dbNaceDetail.setParent(naceDetail.getParent());
        dbNaceDetail.setRulings(naceDetail.getRulings());
        dbNaceDetail.setReferenceToIsic(naceDetail.getReferenceToIsic());
        dbNaceDetail.setThisItemIncludes(naceDetail.getThisItemIncludes());
        dbNaceDetail.setThisItemAlsoIncludes(naceDetail.getThisItemAlsoIncludes());
        dbNaceDetail.setThisItemExcludes(naceDetail.getThisItemExcludes());
        return naceDetailsService.save(dbNaceDetail);

    }

    @DeleteMapping("/employees/{orderId}")
    void deleteEmployee(@PathVariable int orderId) {
        naceDetailsService.deleteById(orderId);
    }

}
