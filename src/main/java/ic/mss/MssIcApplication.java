package ic.mss;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scheduling.annotation.EnableScheduling;

import ic.mss.util.filter.RequestResponseLoggingFilter;

@SpringBootApplication
@MapperScan(value = { "ic.mss.model.dao.mapper" })
@EnableScheduling
public class MssIcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MssIcApplication.class, args);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*Mapper.xml");
		sessionFactory.setMapperLocations(res);

		return sessionFactory.getObject();
	}

	// 필터
	// @Bean
	public FilterRegistrationBean loggingFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();

		registrationBean.setFilter(new RequestResponseLoggingFilter());
		registrationBean.addUrlPatterns("/*");

		registrationBean.setName("로깅 필터 - RequestResponseLoggingFilter)");
		return registrationBean;
	}

}
