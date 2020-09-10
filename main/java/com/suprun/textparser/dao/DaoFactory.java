package com.suprun.textparser.dao;

import com.suprun.textparser.dao.impl.TextParsingDaoImpl;

public class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();

    private final TextParsingDao textParsingDao = new TextParsingDaoImpl();

    private DaoFactory() {}

    public TextParsingDao getTextParsingDao() {
        return textParsingDao;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}
