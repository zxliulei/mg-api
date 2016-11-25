/**
 * User Service
 * 2016/10/09 ming
 * v0.1
 */
package com.ichunming.mg.core.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ichunming.mg.common.constant.BucketType;
import com.ichunming.mg.core.helper.OssClientWrapper;
import com.ichunming.mg.core.helper.OssConfiguration;

@Service
public class OssService {
	private Logger logger = LoggerFactory.getLogger(OssService.class);
	
	private Map<String, OssClientWrapper> ossClientMap;
	
	@Autowired
	private OssConfiguration ossConfiguration;
	
	/**
	 * init
	 * @return
	 */
	private void initOssClientMap(){
		logger.debug("init client map...");
		ossClientMap = new HashMap<String, OssClientWrapper>();
		
		//add module
		ossClientMap.put(BucketType.PIC.getKey(), new OssClientWrapper(ossConfiguration, ossConfiguration.getBtPicName(), ossConfiguration.getBtPicUrl()));
		ossClientMap.put(BucketType.AUDIO.getKey(), new OssClientWrapper(ossConfiguration, ossConfiguration.getBtAudioName(), ossConfiguration.getBtAudioUrl()));
		ossClientMap.put(BucketType.VIDEO.getKey(), new OssClientWrapper(ossConfiguration, ossConfiguration.getBtVideoName(), ossConfiguration.getBtVideoUrl()));
	}
	
	/**
	 * post
	 * @param bucketKey
	 * @param key
	 * @param is
	 * @return
	 */
	public String post(String bucketKey, String key, InputStream is) {
		// get client
		OssClientWrapper ossClientWrapper = getClient(bucketKey);

		return ossClientWrapper.post(key, is);
	}
	
	/**
	 * post
	 * @param bucketKey
	 * @param key
	 * @param filePath
	 * @return
	 */
	public String post(String bucketKey, String key, String filePath) {
		// get client
		OssClientWrapper ossClientWrapper = getClient(bucketKey);
		
		return ossClientWrapper.post(key, filePath);
	}
	
	/**
	 * delete
	 * @param bucketName
	 * @param key
	 */
	public boolean delete(String bucketKey, String key) {
		// get client
		OssClientWrapper ossClientWrapper = getClient(bucketKey);
		return ossClientWrapper.delete(key);
	}
	
	/**
	 * get client
	 * @param bucketKey
	 * @return
	 */
	private OssClientWrapper getClient(String bucketKey) {
		// check ossClientMap
		if(null == ossClientMap || ossClientMap.isEmpty()) {
			initOssClientMap();
		}
		// check ossClientWrapper
		return ossClientMap.get(bucketKey);
	}
	
}
