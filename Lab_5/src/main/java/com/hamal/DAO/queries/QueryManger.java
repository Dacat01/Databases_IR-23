package com.hamal.DAO.queries;

public class QueryManger {
    private final String className;

    public QueryManger(String className) {
        this.className = className;
    }

                                    //HQL запити
    public String getFindAllQuery() {
        return "FROM " + className;
    }

    public String getFindByIdQuery() {
        return String.format("FROM %s  WHERE id = :id", className);
    }

    public String getDeleteByIdQuery() {
        return String.format("DELETE %s where id = :id", className);
    }
}
