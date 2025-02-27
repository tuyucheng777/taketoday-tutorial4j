package cn.tuyucheng.taketoday.books.config;

import cn.tuyucheng.taketoday.books.models.WebsiteUser;
import cn.tuyucheng.taketoday.books.projections.CustomBook;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

   @Override
   public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration,
                                                    CorsRegistry cors) {
      ExposureConfiguration config = repositoryRestConfiguration.getExposureConfiguration();
      config.forDomainType(WebsiteUser.class).withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PATCH));
      repositoryRestConfiguration.getProjectionConfiguration().addProjection(CustomBook.class);
   }
}