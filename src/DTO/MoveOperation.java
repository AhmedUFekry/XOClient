/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DELL
 */
public class MoveOperation {
   private String operation;
   private MoveDTO mvDto ; 

    public MoveOperation(String operation, MoveDTO mvDto) {
        this.operation = operation;
        this.mvDto = mvDto;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public MoveDTO getMvDto() {
        return mvDto;
    }

    public void setMvDto(MoveDTO mvDto) {
        this.mvDto = mvDto;
    }
   
    
}
