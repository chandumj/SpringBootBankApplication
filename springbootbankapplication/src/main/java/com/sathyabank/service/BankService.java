package com.sathyabank.service;

import java.util.List;

import com.sathyabank.model.DepositWithdraw;
import com.sathyabank.model.NewAccount;
import com.sathyabank.model.SathyaBankDatabase;
import com.sathyabank.model.Transfer;

public interface BankService {
	public void addAccount(NewAccount account);
	public SathyaBankDatabase checkBalance(DepositWithdraw account);
	public double getOldBalance(DepositWithdraw account);
	public SathyaBankDatabase deposit(DepositWithdraw account);
	public SathyaBankDatabase withdraw(DepositWithdraw account);
	public List<SathyaBankDatabase> transfer(Transfer account);
	public double getOldBalance(Transfer account);
	public boolean closeAccount(DepositWithdraw account);
	
}
