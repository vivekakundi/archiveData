package com.tcs.archive.service;

import com.tcs.archive.commonutils.CommonImpl;
import com.tcs.archive.model.GoaTable;
import com.tcs.archive.model.GoaTempTable;
import com.tcs.archive.repository.GoaReposiotry;
import com.tcs.archive.repository.GoaTempRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ArchiveService {
    @Autowired
    private GoaReposiotry goaReposiotry;
    @Autowired
    private GoaTempRepository goaTempRepository;
    @Autowired
    private CommonImpl commonImpl;


    public GoaTable saveGoaTable(GoaTable goaTable){
        return goaReposiotry.save(goaTable);
    }
    @Transactional
    public void transferData(){
        GoaTempTable goaTempTable = new GoaTempTable();
        List<GoaTempTable> listOfGoaTempTable = new ArrayList<>();
        List<GoaTable> goaTablesDetails = goaReposiotry.findAll();
        for(GoaTable goaTable:goaTablesDetails){
            GoaTempTable isExisit =goaTempRepository.findByFormSubmissionReferenceNumber(goaTable.getFormSubmissionReferenceNumber());
            if(isExisit!=null){
                continue;
            }
            listOfGoaTempTable.add(commonImpl.mapGoaTableToGoaTempTable(goaTable));
        }
        if(!CollectionUtils.isEmpty(listOfGoaTempTable)){
            goaTempRepository.saveAll(listOfGoaTempTable);
        }
    }

}
