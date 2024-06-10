package com.tcs.archive.controller;

import com.tcs.archive.model.GoaTable;
import com.tcs.archive.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataTransferController {
    @Autowired
    private ArchiveService archiveService;
    @RequestMapping(value = "/transferData",method = RequestMethod.GET)
    public String transferData(){
        archiveService.transferData();
        return "Data successfully transfer";
    }
    @RequestMapping(value = "/saveGoaDetails",method = RequestMethod.POST)
    public String saveGoaTableDetails(@RequestBody GoaTable goaTable){
        archiveService.saveGoaTable(goaTable);
        return "Details saved successfully in the table";
    }
}
