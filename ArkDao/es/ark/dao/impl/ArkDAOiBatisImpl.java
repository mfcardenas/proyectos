package es.ark.dao.impl;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import es.ark.dao.ArkDAO;
import es.ark.exception.DAOException;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Class iBatis Impl
 * @author ArkSoft
 *
 */
@SuppressWarnings("rawtypes")
public class ArkDAOiBatisImpl implements ArkDAO {

    public ArkDAOiBatisImpl() {
    }

    
	public List selectData(String nameSQLOperation)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:selectData...: Inicio. Operacion: " + nameSQLOperation);
        List resultado = null;
        try
        {
            logger.debug("ArkDAOiBatisImpl:selectData...: Ejecutar sentencia SQL");
            resultado = sqlMapper.queryForList(nameSQLOperation);
        }
        catch(SQLException e)
        {
            resultado = null;
            logger.error("ArkDAOiBatisImpl:selectData...: Inicio. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
            throw new DAOException("Error:SQLException. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
        }
        return resultado;
    }

    public List selectDataList(String nameSQLOperation, Object parameterSQL)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:selectDataList...: Inicio. Operacion: " + nameSQLOperation);
        List resultado = null;
        try
        {
            logger.debug("ArkDAOiBatisImpl:selectDataList...: Ejecutar sentencia SQL");
            resultado = sqlMapper.queryForList(nameSQLOperation, parameterSQL);
        }
        catch(SQLException e)
        {
            resultado = null;
            logger.error("ArkDAOiBatisImpl:selectDataList...: Inicio. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
            throw new DAOException("Error:SQLException. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
        }
        return resultado;
    }

    public Object selectDataObject(String nameSQLOperation, Object parameterSQL)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:selectDataObject...: Inicio. Operacion: " + nameSQLOperation);
        Object resultado = null;
        try
        {
            logger.debug("ArkDAOiBatisImpl:selectDataObject...: Ejecutar sentencia SQL");
            resultado = sqlMapper.queryForObject(nameSQLOperation, parameterSQL);
        }
        catch(SQLException e)
        {
            resultado = null;
            logger.error("ArkDAOiBatisImpl:selectDataObject...: Inicio. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
            throw new DAOException("Error:SQLException. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
        }
        return resultado;
    }

    public int selectDataCount(String nameSQLOperation)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:selectDataCount...: Inicio. Operacion: " + nameSQLOperation);
        int resultado = 0;
        try
        {
            logger.debug("ArkDAOiBatisImpl:selectDataCount...: Ejecutar sentencia SQL");
            resultado = ((Integer)sqlMapper.queryForObject(nameSQLOperation)).intValue();
        }
        catch(SQLException e)
        {
            resultado = 0;
            logger.error("ArkDAOiBatisImpl:selectDataCount...: Inicio. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
            throw new DAOException("Error:SQLException. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
        }
        return resultado;
    }

    public boolean insertarconBatch(String nameSQLOperation, ArrayList lista)
        throws DAOException
    {
        return true;
    }

    public boolean insertarsinBatch(String nameSQLOperation, ArrayList lista)
        throws DAOException
    {
        return true;
    }

    public Object insert(String nameSQLOperation)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:insert...: Inicio. Operacion: " + nameSQLOperation);
        Object resultado = null;
        try
        {
            logger.debug("ArkDAOiBatisImpl:insert...: Ejecutar sentencia SQL");
            resultado = sqlMapper.insert(nameSQLOperation);
        }
        catch(SQLException e)
        {
            resultado = null;
            logger.error("ArkDAOiBatisImpl:insert...: Inicio. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
            throw new DAOException("Error:SQLException. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
        }
        return resultado;
    }

    public Object insert(String nameSQLOperation, Object parameterSQL)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:insert...: Inicio. Operacion: " + nameSQLOperation);
        Object resultado = null;
        try
        {
            logger.debug("ArkDAOiBatisImpl:insert...: Ejecutar sentencia SQL");
            resultado = sqlMapper.insert(nameSQLOperation, parameterSQL);
        }
        catch(SQLException e)
        {
            resultado = null;
            logger.error("ArkDAOiBatisImpl:insert...: Inicio. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
            throw new DAOException("Error:SQLException. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
        }
        return resultado;
    }

    public int update(String nameSQLOperation)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:update...: Inicio. Operacion: " + nameSQLOperation);
        int resultado = 0;
        try
        {
            logger.debug("ArkDAOiBatisImpl:update...: Ejecutar sentencia SQL");
            resultado = sqlMapper.update(nameSQLOperation);
        }
        catch(SQLException e)
        {
            resultado = 0;
            logger.error("ArkDAOiBatisImpl:update...: Inicio. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
            throw new DAOException("Error:SQLException. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
        }
        return resultado;
    }

    public int update(String nameSQLOperation, Object parameterSQL)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:update...: Inicio. Operacion: " + nameSQLOperation);
        int resultado = 0;
        try
        {
            logger.debug("ArkDAOiBatisImpl:update...: Ejecutar sentencia SQL");
            resultado = sqlMapper.update(nameSQLOperation, parameterSQL);
        }
        catch(SQLException e)
        {
            resultado = 0;
            logger.error("ArkDAOiBatisImpl:update...: Inicio. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
            throw new DAOException("Error:SQLException. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
        }
        return resultado;
    }

    public boolean update(String nameSQLOperation, Object parameterSQL, int timeOut)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:update...: Inicio. Operacion: " + nameSQLOperation);
        logger.debug("ArkDAOiBatisImpl:update...: Ejecutar sentencia SQL");
        int resultado = update(nameSQLOperation, parameterSQL);
        return resultado != 0;
    }

    public int delete(String nameSQLOperation)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:delete...: Inicio. Operacion: " + nameSQLOperation);
        int resultado = 0;
        try
        {
            logger.debug("ArkDAOiBatisImpl:delete...: Ejecutar sentencia SQL");
            resultado = sqlMapper.delete(nameSQLOperation);
        }
        catch(SQLException e)
        {
            resultado = 0;
            logger.error("ArkDAOiBatisImpl:delete...: Inicio. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
            throw new DAOException("Error:SQLException. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
        }
        return resultado;
    }

    public int delete(String nameSQLOperation, Object parameterSQL)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:delete...: Inicio. Operacion: " + nameSQLOperation);
        int resultado = 0;
        try
        {
            logger.debug("ArkDAOiBatisImpl:delete...: Ejecutar sentencia SQL");
            resultado = sqlMapper.delete(nameSQLOperation, parameterSQL);
        }
        catch(SQLException e)
        {
            resultado = 0;
            logger.error("ArkDAOiBatisImpl:delete...: Inicio. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
            throw new DAOException("Error:SQLException. ErrorCode:" + e.getErrorCode() + ". SQLState: " + e.getSQLState() + ". Message: " + e.getMessage());
        }
        return resultado;
    }

    public boolean delete(String nameSQLOpeartion, Object parameterSQL, int timeOut)
        throws DAOException
    {
        logger.debug("ArkDAOiBatisImpl:delete...: Inicio. Operacion: " + nameSQLOpeartion);
        logger.debug("ArkDAOiBatisImpl:delete...: Ejecutar sentencia SQL");
        int resultado = delete(nameSQLOpeartion, parameterSQL);
        return resultado != 0;
    }

    private static SqlMapClient sqlMapper;
    static Logger logger;

    static 
    {
        logger = Logger.getLogger(es.ark.dao.impl.ArkDAOiBatisImpl.class);
        try
        {
            logger.debug("ArkDAOiBatisImpl:static...: Inicio. Busqueda del fichero");
            Reader reader = Resources.getResourceAsReader("es/Ark/arq/dao/SqlMapConfig.xml");
            logger.debug("ArkDAOiBatisImpl:static...: Leer los contenidos del fichero");
            sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
            logger.debug("ArkDAOiBatisImpl:static...: Cerrar el elemento reader");
            reader.close();
        }
        catch(IOException e)
        {
            logger.error("ArkDAOiBatisImpl:static...: Error:" + e.getMessage());
            throw new RuntimeException("Ha sucedio un error al instanciar el SQLMapConfig" + e, e);
        }
    }
}