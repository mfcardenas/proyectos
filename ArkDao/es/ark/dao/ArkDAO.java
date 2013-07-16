
package es.ark.dao;

import es.ark.exception.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ArkSoft
 *
 */
@SuppressWarnings("rawtypes")
public interface ArkDAO
{

    public abstract List selectData(String s)
        throws DAOException;

    public abstract List selectDataList(String s, Object obj)
        throws DAOException;

    public abstract Object selectDataObject(String s, Object obj)
        throws DAOException;

    public abstract int selectDataCount(String s)
        throws DAOException;

    public abstract Object insert(String s)
        throws DAOException;

    public abstract Object insert(String s, Object obj)
        throws DAOException;

    public abstract boolean insertarconBatch(String s, ArrayList arraylist)
        throws DAOException;

    public abstract boolean insertarsinBatch(String s, ArrayList arraylist)
        throws DAOException;

    public abstract int update(String s)
        throws DAOException;

    public abstract int update(String s, Object obj)
        throws DAOException;

    public abstract boolean update(String s, Object obj, int i)
        throws DAOException;

    public abstract int delete(String s)
        throws DAOException;

    public abstract int delete(String s, Object obj)
        throws DAOException;

    public abstract boolean delete(String s, Object obj, int i)
        throws DAOException;
}