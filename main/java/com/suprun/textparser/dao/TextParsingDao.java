package com.suprun.textparser.dao;

import com.suprun.textparser.entity.TextPart;

public interface TextParsingDao {

    TextPart receiveParsedText() throws DaoException;
}
