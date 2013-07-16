package es.ark.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import es.ark.dao.ArkDAO;
import es.ark.exception.DAOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

@SuppressWarnings("rawtypes")
public class ArkDAOImpl extends SqlMapClientDaoSupport implements ArkDAO {

    public ArkDAOImpl(){
    }

    public List selectData(String nameSQLOperation) throws DAOException {
    	try{
    		SqlMapClientTemplate sqlMapClientTemplate;
            logger.debug("ArkDAOImpl:selectData...: Nombre Operacion = " + nameSQLOperation);
            sqlMapClientTemplate = getSqlMapClientTemplate();
            return sqlMapClientTemplate.queryForList(nameSQLOperation);
            	
    	}catch(DataAccessException ex){
    		throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
    	}catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
        
    }

    public List selectDataList(String nameSQLOperation, Object parameterSQL) throws DAOException {
    	try{
    		
    		SqlMapClientTemplate sqlMapClientTemplate;
    		logger.debug("ArkDAOImpl:selectDataList...: Nombre Operacion = " + nameSQLOperation);
    		sqlMapClientTemplate = getSqlMapClientTemplate();
    		return sqlMapClientTemplate.queryForList(nameSQLOperation, parameterSQL);
    	}catch(DataAccessException ex){
    		throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
    	}catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public Object selectDataObject(String nameSQLOperation, Object parameterSQL) throws DAOException {
    	try{
    		SqlMapClientTemplate sqlMapClientTemplate;
            logger.debug("ArkDAOImpl:selectDataObject...: Nombre Operacion = " + nameSQLOperation);
            sqlMapClientTemplate = getSqlMapClientTemplate();
            return sqlMapClientTemplate.queryForObject(nameSQLOperation, parameterSQL);
    	}catch(DataAccessException ex){
    		throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
    	}catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
        
        
    }

    public int selectDataCount(String nameSQLOperation) throws DAOException{
    	try{
    		SqlMapClientTemplate sqlMapClientTemplate;
            logger.debug("ArkDAOImpl:selectDataCount...: Nombre Operacion = " + nameSQLOperation);
            sqlMapClientTemplate = getSqlMapClientTemplate();
            return ((Integer)sqlMapClientTemplate.queryForObject(nameSQLOperation)).intValue();
    	}catch(DataAccessException ex){
    		throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
    	}catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
        

    }

    public boolean insertarconBatch(String nameSQLOperation, ArrayList lista) throws DAOException {
        SqlMapClient misqlMap = null;
        try{
            SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();
            misqlMap = sqlMapClientTemplate.getSqlMapClient();
            misqlMap.startBatch();
            for(int i = 0; i < lista.size(); i++){
                misqlMap.insert(nameSQLOperation, lista.get(i));
            }
            misqlMap.executeBatch();
        }
        catch(SQLException ex){
            throw new DAOException(ex.getMessage());
        }catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
        return true;
    }

    public boolean insertarsinBatch(String nameSQLOperation, ArrayList lista) throws DAOException{
        SqlMapClient misqlMap = null;
        try{
            SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();
            misqlMap = sqlMapClientTemplate.getSqlMapClient();
            for(int i = 0; i < lista.size(); i++)
                misqlMap.insert(nameSQLOperation, lista.get(i));

        }
        catch(SQLException ex){
            throw new DAOException(ex.getMessage());
        }catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
        return true;
    }

    public Object insert(String nameSQLOperation) throws DAOException {
        try{
        	SqlMapClientTemplate sqlMapClientTemplate;
            logger.debug("ArkDAOImpl:insert (1)...: Nombre Operacion = " + nameSQLOperation);
            sqlMapClientTemplate = getSqlMapClientTemplate();
            return sqlMapClientTemplate.insert(nameSQLOperation);
        }catch(DataAccessException ex){
    		throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
    	}catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
        
    }

    public Object insert(String nameSQLOperation, Object parameterSQL) throws DAOException {
    	try{
    		SqlMapClientTemplate sqlMapClientTemplate;
            logger.debug("ArkDAOImpl:insert (2)...: Nombre Operacion = " + nameSQLOperation);
            sqlMapClientTemplate = getSqlMapClientTemplate();
            return sqlMapClientTemplate.insert(nameSQLOperation, parameterSQL);
        }catch(DataAccessException ex){
    		throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
    	}catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public int update(String nameSQLOperation) throws DAOException {
    	try{
    		SqlMapClientTemplate sqlMapClientTemplate;
            logger.debug("ArkDAOImpl:update (1)...: Nombre Operacion = " + nameSQLOperation);
            sqlMapClientTemplate = getSqlMapClientTemplate();
            return sqlMapClientTemplate.update(nameSQLOperation);
        }catch(DataAccessException ex){
    		throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
    	}catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public int update(String nameSQLOperation, Object parameterSQL) throws DAOException {
    	try{
    		SqlMapClientTemplate sqlMapClientTemplate;
            logger.debug("ArkDAOImpl:update (2)...: Nombre Operacion = " + nameSQLOperation);
            sqlMapClientTemplate = getSqlMapClientTemplate();
            return sqlMapClientTemplate.update(nameSQLOperation, parameterSQL);
        }catch(DataAccessException ex){
    		throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
    	}catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public boolean update(String nameSQLOperation, Object parameterSQL, int timeOut) throws DAOException {
        try
        {
            logger.debug("ArkDAOImpl:update (3)...: Nombre Operacion = " + nameSQLOperation);
            SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();
            sqlMapClientTemplate.update(nameSQLOperation, parameterSQL, timeOut);
        }
        catch(DataAccessException ex){
            throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
        }catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
        return true;
    }

    public int delete(String nameSQLOperation) throws DAOException {
    	try{
    		SqlMapClientTemplate sqlMapClientTemplate;
            logger.debug("ArkDAOImpl:delete (1)...: Nombre Operacion = " + nameSQLOperation);
            sqlMapClientTemplate = getSqlMapClientTemplate();
            return sqlMapClientTemplate.delete(nameSQLOperation);
        }catch(DataAccessException ex){
    		throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
    	}catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public int delete(String nameSQLOperation, Object parameterSQL) throws DAOException{
    	try{
    		SqlMapClientTemplate sqlMapClientTemplate;
            logger.debug("ArkDAOImpl:delete (2)...: Nombre Operacion = " + nameSQLOperation);
            sqlMapClientTemplate = getSqlMapClientTemplate();
            return sqlMapClientTemplate.delete(nameSQLOperation, parameterSQL);
        }catch(DataAccessException ex){
    		throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
    	}
    }

    public boolean delete(String nameSQLOperation, Object parameterSQL, int timeOut) throws DAOException{
        try{
            logger.debug("ArkDAOImpl:delete (3)...: Nombre Operacion = " + nameSQLOperation);
            SqlMapClientTemplate sqlMapClientTemplate = getSqlMapClientTemplate();
            sqlMapClientTemplate.delete(nameSQLOperation, parameterSQL, timeOut);
        }catch(DataAccessException ex){
            throw new DAOException(ex.getMessage(), ex.getMostSpecificCause());
        }catch(Exception ex){
            throw new DAOException(ex.getMessage());
        }
        return true;
    }

    static Logger logger;

    static {
        logger = Logger.getLogger(es.ark.dao.impl.ArkDAOImpl.class);
    }
}