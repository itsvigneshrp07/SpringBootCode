package com.st.mdm.controllers;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.st.mdm.models.Asset;
import com.st.mdm.repository.AssetRepository;
import com.st.mdm.services.AssetServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/auth")
@RestController
public class AssetController {
	@Autowired
	private AssetRepository repo;
	@Autowired
	private AssetServiceImpl service;

	@PostMapping("/createAsset")
	public ResponseEntity<Asset> createAssetDetails(@RequestBody Asset asset)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {
		return ResponseEntity.ok().body(repo.save(asset));
	}

	@GetMapping("/getAsset/{id}")
	public ResponseEntity<List<Asset>> getAssetDetails(@PathVariable(value = "id") long id)
			throws JSONException, JSONException, JsonMappingException, JsonProcessingException {

		return ResponseEntity.ok().body(service.getAssetDetails(id));
	}

	@GetMapping("/getAsset")
	public List<Asset> getAssetDetails(Asset asset) {
		return repo.findAll();
	}

	@DeleteMapping("/deleteAsset/{id}")
	public HttpStatus deleteAsset(@PathVariable(value = "id") Long id) {
		this.repo.deleteById(id);
		return HttpStatus.OK;
	}

	@PutMapping("/updateAsset/{id}")
	public ResponseEntity<Asset> updateAssetDetails(@PathVariable(value = "id") Long id, @RequestBody Asset asset) {
		asset.setId(id);
		return ResponseEntity.ok().body(this.service.updateAssetDetails(asset));
	}
}
