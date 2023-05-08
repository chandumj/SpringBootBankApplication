package com.sathyabank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sathyabank.model.DepositWithdraw;
import com.sathyabank.model.NewAccount;
import com.sathyabank.model.SathyaBankDatabase;
import com.sathyabank.model.Transfer;
import com.sathyabank.service.BankServiceImp;


@Controller
public class BankController {
	
	@Autowired
	private BankServiceImp serviceImp;
	
	@RequestMapping("/")
	public String homePage() {
		return "home";
	}
	@RequestMapping("/newaccount")
	public String addAccountPage(ModelMap model) {
		NewAccount account=new NewAccount();
		model.put("account", account);
		return "addaccount";
	}
	@RequestMapping("/addaccount")
	public String registerUser(@ModelAttribute NewAccount account) {
		serviceImp.addAccount(account);
		return "success";
	}
	@RequestMapping("/balance")
	public String checkBalancePage(ModelMap model) {
		NewAccount account=new NewAccount();
		model.put("account", account);
		return "balance";
	}
	@RequestMapping("/checkbalance")
	public String checkBalancePage(@ModelAttribute DepositWithdraw account ,ModelMap model) {
		SathyaBankDatabase database=serviceImp.checkBalance(account);
		if(database!=null){
			model.put("database", database);
			return "viewbalance";
		}else {
			return "fail";
		}
		
	}
	@RequestMapping("/deposit")
	public String depositPage(ModelMap model) {
		DepositWithdraw account=new DepositWithdraw();
		model.put("account", account);
		return "deposit";
	}
	@RequestMapping("/addamount")
	public String addAmount(@ModelAttribute DepositWithdraw account ,ModelMap model) {
		model.put("oldamount", serviceImp.getOldBalance(account));
		SathyaBankDatabase database=serviceImp.deposit(account);
		if(database!=null) {
		model.put("database", database);
		model.put("newamount", account.getAmount());
		return "depositsuccess";
		}
		else {
			return "fail";
		}
	}
		
	@RequestMapping("/withdraw")
	public String withdrawPage(ModelMap model) {
		DepositWithdraw account=new DepositWithdraw();
		model.put("account", account);
		return "withdraw";
	}
	@RequestMapping("/withdrawamount")
	public String withdrawAmount(@ModelAttribute DepositWithdraw account ,ModelMap model) {
		model.put("oldamount", serviceImp.getOldBalance(account));
		SathyaBankDatabase database=serviceImp.deposit(account);
		if(database!=null) {
		model.put("database", database);
		model.put("newamount", account.getAmount());
		return "withdrawsuccess";
		}
		else {
			return "fail";
		}
	}
	@RequestMapping("/transfer")
	public String transferPage(ModelMap model) {
		Transfer account=new Transfer();
		model.put("account", account);
		return "transfer";
	}
	@RequestMapping("/transferamount")
	public String transferAmount(@ModelAttribute Transfer account ,ModelMap model) {
		model.put("oldamount", serviceImp.getOldBalance(account));
		List<SathyaBankDatabase> databases=serviceImp.transfer(account);
		if(databases!=null) {
		model.put("database1", databases.get(0));
		model.put("database2", databases.get(1));
		model.put("newamount", account.getAmount());
		return "transfersuccess";
		}else {
			return "fail";
		}
	}
	@RequestMapping("/close")
	public String CloseAccountPage(ModelMap model) {
		DepositWithdraw account=new DepositWithdraw();
		model.put("account", account);
		return "closeaccount";
	}
	@RequestMapping("/closeaccount")
	public String closeAccount(@ModelAttribute DepositWithdraw account ) {
		if(serviceImp.closeAccount(account)) {
		return "closeaccountsuccess";
		}else {
			return "fail";
		}
	}
	@RequestMapping("/aboutus")
	public String aboutusPage() {
		return "aboutus";
	}
}
