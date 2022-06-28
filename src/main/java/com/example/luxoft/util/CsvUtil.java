package com.example.luxoft.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.example.luxoft.model.NaceDetail;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvUtil {

    public static List<NaceDetail> readAll() throws IOException {

        String fileName = "src/main/resources/source.csv";
        Path myPath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(myPath,
                StandardCharsets.UTF_8)) {

            HeaderColumnNameMappingStrategy<NaceDetail> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(NaceDetail.class);

            CsvToBean<NaceDetail> csvToBean = new CsvToBeanBuilder<NaceDetail>(br)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<NaceDetail> naceDetails = csvToBean.parse();

            return naceDetails;
        }
    }

}
