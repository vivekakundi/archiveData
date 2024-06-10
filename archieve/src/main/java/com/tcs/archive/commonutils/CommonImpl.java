package com.tcs.archive.commonutils;

import com.tcs.archive.model.GoaTable;
import com.tcs.archive.model.GoaTempTable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CommonImpl {
    private ModelMapper modelMapper= new ModelMapper();

    public GoaTempTable mapGoaTableToGoaTempTable(GoaTable goaTable){
        GoaTempTable goaTempTable = new GoaTempTable();
        modelMapper.map(goaTable,goaTempTable);
        return goaTempTable;
    }

}
