package com.company.Models.Expressions;

import com.company.Models.ExceptionFactory;
import com.company.Models.Expression;
import com.company.Models.ProgramState.ProgramState;
import com.company.Utils.MyIDictionary;

public class VariableExpression extends Expression {
    private String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public int eval(ProgramState state) throws Exception {
        MyIDictionary<String, Integer> symTable = state.getSymTable();

        if (!symTable.contains(this.variableName)) {
            throw ExceptionFactory.create("variable", "variable not declared!");
        }

        return symTable.getValue(this.variableName);
    }

    @Override
    public String toString() {
        return variableName;
    }
}
