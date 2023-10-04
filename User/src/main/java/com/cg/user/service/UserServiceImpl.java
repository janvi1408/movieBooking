package com.cg.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.user.dao.UserDAO;
import com.cg.user.dto.Categorydto;
import com.cg.user.exception.InvalidId;
import com.cg.user.pojo.Advertisement;
@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO repo;
	
	@Autowired RestTemplate restTemplate;
	public Categorydto getDetails(int categoryId)throws InvalidId {
		try {
			return restTemplate.getForEntity("http://localhost:2000/admin/category/"+ categoryId, Categorydto.class).getBody();}
			catch(HttpClientErrorException e) {

				throw new  InvalidId("Id not Found in category");

			}
	}
	@Override
	public Advertisement add(Advertisement ad)throws InvalidId {
		getDetails(ad.getCategoryId());
		return repo.save(ad);
	}

	@Override
	public Advertisement update(int aid, String newType)throws InvalidId {
		Advertisement ad =repo.findById(aid).orElseThrow(()->new InvalidId("Id not present"));
		ad.setTypeOfAdvertisement(newType);
		return repo.save(ad);
	}

	@Override
	public String delete(int aid)throws InvalidId {
		Advertisement ad =repo.findById(aid).orElseThrow(()->new InvalidId("Id not present"));
		repo.delete(ad);
		return "SUCCESSFULLY DELETED";
	}

	@Override
		public List<Advertisement> getAllAdvertise(){
			return repo.findAll();
		}
	@Override
	public List<Advertisement> getAds(int categoryId) {
		List<Advertisement> ad = getAllAdvertise();
		List<Advertisement> alladds = new ArrayList<>();
		for(Advertisement i : ad) {
			if(i.getCategoryId()==categoryId) {
				alladds.add(i);

			}
	}
			return alladds;

		}
	

}
