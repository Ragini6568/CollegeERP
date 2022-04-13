package com.app.service;

import com.app.pojos.Batch;

public interface IBatchService {
Batch addBatch(Batch transientBatch);
String deleteBatch(int id);
}
