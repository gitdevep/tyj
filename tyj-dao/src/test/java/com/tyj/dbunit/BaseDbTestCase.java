package com.tyj.dbunit;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = { "classpath:/conf/appContext-test.xml" }, inheritLocations = false)
public abstract class BaseDbTestCase extends BaseBusinessTestCase {
    
    protected SimpleJdbcTemplate simpleJdbcTemplate;
    private DataSource dataSource;
    
    @Override
    protected DataSource getDataSource() {
        return dataSource;
    }
    
    @Override
    protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
        return simpleJdbcTemplate;
    }
    
    @Resource(name = "dataSourceDemo")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }
    
    public String getDbunitDir() {
        return "data";
    }
    
    public String getDbunitFile() {
        return "sample_data_cust.xml";
    }
}
