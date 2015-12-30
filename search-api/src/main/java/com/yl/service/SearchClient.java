package com.yl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yl.model.Goods;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;

import java.util.List;
import java.util.Map;

public class SearchClient {

    private Client client;

    public SearchClient() {
        client = new TransportClient().addTransportAddress(new InetSocketTransportAddress("10.121.32.134", 9300));
    }
    public void closeClient() {
        client.close();
    }

    public void post(String index, String type, String json) {
        IndexResponse response = client.prepareIndex(index, type)
                .setSource(json)
                .execute()
                .actionGet();
    }

    public void getById(String index, String type, String id) {
        GetResponse response = client.prepareGet(index, type, id)
                .execute()
                .actionGet();
        // response.
    }

    public void deleteById(String index, String type, String id) {
        DeleteResponse response = client.prepareDelete(index, type, id)
                .execute()
                .actionGet();
    }

    public boolean addBulk(String index, String type, List<String> jsons) {
        BulkRequestBuilder bulkRequest = client.prepareBulk();

        for (String json : jsons) {
            bulkRequest.add(client.prepareIndex(index, type).setSource(json));
        }
        BulkResponse bulkResponse = bulkRequest.execute().actionGet();
        if (bulkResponse.hasFailures()) {
            for (BulkItemResponse bulkItemResponse : bulkResponse.getItems()) {
                if (bulkItemResponse.isFailed()) {
                    // bulkItemResponse.get
                }
            }
            return false;
        }
        return true;
    }

    public boolean addBulk(String index, String type, Map<String,String> map) {
        BulkRequestBuilder bulkRequest = client.prepareBulk();

        for (String key : map.keySet()) {
            bulkRequest.add(client.prepareIndex(index, type).setSource(map.get(key)).setId(key));
        }
        BulkResponse bulkResponse = bulkRequest.execute().actionGet();
        if (bulkResponse.hasFailures()) {
            for (BulkItemResponse bulkItemResponse : bulkResponse.getItems()) {
                if (bulkItemResponse.isFailed()) {
                    // bulkItemResponse.get
                }
            }
            return false;
        }
        return true;
    }

    public void search(String index, String type) {
        SearchResponse response = client.prepareSearch(index)
                .setTypes(type)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.queryString("peter").boost(10))
                .setPostFilter(FilterBuilders.rangeFilter("age").from(12).to(18))
                .setFrom(0).setSize(60).setExplain(true)
                .execute()
                .actionGet();
    }

    public String parse(Goods goods) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(goods);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
