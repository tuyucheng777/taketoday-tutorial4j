package cn.tuyucheng.taketoday.spring.data.es.aggregation.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponseInterceptor;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchClients;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "cn.tuyucheng.taketoday.spring.data.es.aggregation.repository")
@ComponentScan(basePackages = "cn.tuyucheng.taketoday.spring.data.es.aggregation")
public class ElasticSearchConfig {

   @Bean
   public RestClient elasticsearchRestClient() {
      return RestClient.builder(HttpHost.create("localhost:9200"))
            .setHttpClientConfigCallback(httpClientBuilder -> {
               httpClientBuilder.addInterceptorLast((HttpResponseInterceptor) (response, _) ->
                     response.addHeader("X-Elastic-Product", "Elasticsearch"));
               return httpClientBuilder;
            })
            .build();
   }

   @Bean
   public ElasticsearchClient elasticsearchClient(RestClient restClient) {
      return ElasticsearchClients.createImperative(restClient);
   }

   @Bean(name = {"elasticsearchOperations", "elasticsearchTemplate"})
   public ElasticsearchOperations elasticsearchOperations(ElasticsearchClient elasticsearchClient) {
      ElasticsearchTemplate template = new ElasticsearchTemplate(elasticsearchClient);
      template.setRefreshPolicy(null);

      return template;
   }
}