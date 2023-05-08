package com.sathyabank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathyabank.model.DepositWithdraw;
import com.sathyabank.model.NewAccount;
import com.sathyabank.model.SathyaBankDatabase;
import com.sathyabank.model.Transfer;
import com.sathyabank.repo.BankRepo;
@Service
public class BankServiceImp implements BankService {

	@Autowired
	private BankRepo repo;
	@Override
	public void addAccount(NewAccount account) {
		SathyaBankDatabase database=new SathyaBankDatabase();
		database.setAccountNo(account.getAccno());
		database.setName(account.getName());
		database.setPassword(account.getPassword());
		database.setAmount(account.getAmount());
		database.setAddress(account.getAddress());
		database.setMobileNo(account.getMobileno());
		repo.save(database);
		
	}
	@Override
	public SathyaBankDatabase checkBalance(DepositWithdraw account) {
		if(repo.existsById(account.getAccno())) {
		SathyaBankDatabase bankDatabase= repo.findById(account.getAccno()).get();
		if(bankDatabase.getName().equalsIgnoreCase(account.getName()) && bankDatabase.getPassword().equals(account.getPassword())){
			return bankDatabase;
		}
		else {
			return null;
		}
		}
		else {
			return null;
		}
		
	}
	@Override
	public SathyaBankDatabase deposit(DepositWithdraw account) {
		if(repo.existsById(account.getAccno())) {
			SathyaBankDatabase bankDatabase= repo.findById(account.getAccno()).get();
			if(bankDatabase.getName().equalsIgnoreCase(account.getName()) && bankDatabase.getPassword().equals(account.getPassword())){	
		Long accountno=account.getAccno();
		SathyaBankDatabase data=repo.findById(accountno).get();
		double newamount=account.getAmount();
		double oldamount=data.getAmount();
		double afterdeposit=oldamount+newamount;
		data.setAmount(afterdeposit);
		repo.save(data);
		return data;
			}
			else {
				return null;
			}
			}
			else {
				return null;
			}
	}
	@Override
	public SathyaBankDatabase withdraw(DepositWithdraw account) {
		if(repo.existsById(account.getAccno())) {
			SathyaBankDatabase bankDatabase= repo.findById(account.getAccno()).get();
			if(bankDatabase.getName().equalsIgnoreCase(account.getName()) && bankDatabase.getPassword().equals(account.getPassword())){	
		Long accountno=account.getAccno();
		SathyaBankDatabase data=repo.findById(accountno).get();
		double newamount=account.getAmount();
		double oldamount=data.getAmount();
		double afterdeposit=oldamount-newamount;
		data.setAmount(afterdeposit);
		repo.save(data);
		return data;
			}
			else {
				return null;
			}
			}
			else {
				return null;
			}
	}
	@Override
	public double getOldBalance(DepositWithdraw account) {
		if(repo.existsById(account.getAccno())) {
		Long accountno=account.getAccno();
		SathyaBankDatabase data=repo.findById(accountno).get();
		double amount=data.getAmount();
		return amount;
		}
		else {
			return 0.0;
		}
	}
	@Override
	public List<SathyaBankDatabase> transfer(Transfer account) {
		long accno=account.getAccno();
		long targetAccno=account.getTargetAccno();
		double transferAmount=account.getAmount(); 
		if(repo.existsById(accno) && repo.existsById(targetAccno)) {
		SathyaBankDatabase data1=repo.findById(accno).get();
		SathyaBankDatabase data2=repo.findById(targetAccno).get();
		if(data1.getName().equalsIgnoreCase(account.getName()) && data1.getPassword().equals(account.getPassword())) {
		data1.setAmount(data1.getAmount()-transferAmount);
		data2.setAmount(data2.getAmount()+transferAmount);
		repo.save(data1);
		repo.save(data2);
		List<SathyaBankDatabase> databases=new ArrayList<SathyaBankDatabase>();
		databases.add(data1);
		databases.add(data2);
		return databases;
		}else {
			return null;
		}
		}else {
			return null;
		}
	}
	@Override
	public double getOldBalance(Transfer account) {
		if(repo.existsById(account.getAccno())) {
		Long accountno=account.getAccno();
		SathyaBankDatabase data=repo.findById(accountno).get();
		double amount=data.getAmount();
		return amount;
		}else {
			return 0.0;
		}
	}
	@Override
	public boolean closeAccount(DepositWithdraw account) {
		if(repo.existsById(account.getAccno())) {
			SathyaBankDatabase bankDatabase= repo.findById(account.getAccno()).get();
			if(bankDatabase.getName().equalsIgnoreCase(account.getName()) && bankDatabase.getPassword().equals(account.getPassword())){
		repo.deleteById(account.getAccno());
		return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}
