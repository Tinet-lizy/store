package monk.zyli.store.search.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import monk.zyli.store.auth.api.ProductServiceApi;
import monk.zyli.store.auth.model.Product;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 商品的service
 *
 * @author lizy
 * @date 2018/07/11
 */
@RestController
public class ProductService implements ProductServiceApi {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Override
    public Integer save(@RequestBody Product product) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();

        IndexRequest indexRequest = new IndexRequest("products");
        String source = objectMapper.writeValueAsString(product);

        indexRequest.source(source);
        bulkRequest.add(indexRequest);
        BulkResponse response = restHighLevelClient.bulk(bulkRequest);
        System.out.println(response);
        return null;
    }
}
