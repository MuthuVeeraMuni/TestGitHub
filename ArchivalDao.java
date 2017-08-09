package com.arisglobal.aglite.archival.dao;

import java.util.List;

import com.arisglobal.aglite.archival.ImportType;
import com.arisglobal.aglite.dao.NonJpaDao;
import com.arisglobal.aglite.metadata.domain.Entity;
import com.arisglobal.aglite.qbe.DataSet;
import com.arisglobal.aglite.version.Version;

public interface ArchivalDao extends NonJpaDao {
    /**
     * Export all fields of the entity     
     * @param recordId
     * @param entity
     * @param isIgnored
     * @return Entity Dataset - Throws AgliteException is the record is not found
     */
    DataSet exportData(Long recordId, Entity entity, boolean isIgnored);
  

    List<Long> getRecordsInScope(String mainEntity, Long recordId, Entity relatedEntity, String relationName);
    List<Long> getRecordsInScope(Long recordId, Entity relatedEntity, String relationName);
   // String importArchivedData(Map<String, DataSet> dsMap, List<String> processOrder, ImportType importType, boolean logData,List<String> entitiesWhoseOriginalIdsAreRetained,boolean refreshUserTrackingInfo,final String archivalId);
    List<Long> fetchAllRecordIds(String query);
    List<Long> fetchAuditTrailRecordIds(String entityId,String recordIds);
    void deleteEntityRecords(String entityId,List<Long> recIds,Entity entity,Version version);
    com.arisglobal.aglite.pagination.Page<Long> findRecordIdsPageByQuery(int start, int size, String query, String countQuery,List<Object> queryParams);
    
    String importArchivedData(List<DataSet> dsList, ImportType importType, boolean logData,List<String> entitiesWhoseOriginalIdsAreRetained,boolean refreshUserTrackingInfo,final String archivalId);

}
