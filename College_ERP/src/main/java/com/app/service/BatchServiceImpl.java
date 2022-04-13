package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BatchRepository;
import com.app.pojos.Batch;

@Service
@Transactional
public class BatchServiceImpl implements IBatchService {
	
	@Autowired
	private BatchRepository batchRepo;

	@Override
	public Batch addBatch(Batch transientBatch) {
		// add batch 
		return batchRepo.save(transientBatch);
	}

	@Override
	public String deleteBatch(int id) {
		// delete batch
		batchRepo.deleteById(id);
		return "Batch deleted successfully";
	}

}
