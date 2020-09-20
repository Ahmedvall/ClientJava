package testClient;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ws.BqServiceProxy;
import ws.Compte;

public class Client {
	
	public static void main(String[] args) throws RemoteException {
		BqServiceProxy proxy = new BqServiceProxy();
		System.out.println(proxy.conversionEuroToDh(130));
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
	
		System.out.println("--------------------------");
		for (Compte c : proxy.listCompte()) {
			Calendar cal = c.getDateCreation().getInstance();
			cal.add(Calendar.DATE, 1);
			System.out.println("Code: "+c.getCode() +" -- Solde: " + c.getSolde()+
					" -- Date: "+ formatDate.format(cal.getTime()));
		}
	}

}
