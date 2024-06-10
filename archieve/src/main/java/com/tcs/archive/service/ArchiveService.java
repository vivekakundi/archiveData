package com.tcs.archive.service;

import com.tcs.archive.model.GoaTable;
import com.tcs.archive.model.GoaTempTable;
import com.tcs.archive.repository.GoaReposiotry;
import com.tcs.archive.repository.GoaTempRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveService {
    @Autowired
    private GoaReposiotry goaReposiotry;
    @Autowired
    private GoaTempRepository goaTempRepository;


    public GoaTable saveGoaTable(GoaTable goaTable){
        return goaReposiotry.save(goaTable);
    }
    @Transactional
    public void transferData(){
        List<GoaTable> goaTablesDetails = goaReposiotry.findAll();
        for(GoaTable goaTable:goaTablesDetails){
            GoaTempTable goaTempTable = new GoaTempTable();
            goaTempTable.setForm6Id(goaTable.getForm6Id());
            goaTempTable.setFormSubmissionReferenceNumber(goaTable.getFormSubmissionReferenceNumber());
            goaTempTable.setResidingInIndia(goaTable.getResidingInIndia());
            goaTempTable.setStateCd(goaTable.getStateCd());
            goaTempTable.setDistrictCd(goaTable.getDistrictCd());
            goaTempTable.setAssemblyConstituencyNumber(goaTable.getAssemblyConstituencyNumber());
            goaTempTable.setFirstTimeVoter(goaTable.getFirstTimeVoter());
            goaTempTable.setFirstTimeVoter(goaTable.getFirstTimeVoter());
            goaTempRepository.save(goaTempTable);
        }
    }

}
