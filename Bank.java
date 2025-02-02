package Project;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class Bank  {
    private String name;
    private List<Account> accounts= new ArrayList<>();;
    private List<ATM> atms = new ArrayList<>();


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void  addAccount(Account account){
        this.accounts.add(account);
    }
    public void removeAccount(Account account){
        this.accounts.remove(account);
    }
    public List<Account> getAccounts() {

        return accounts;
    }
    public int getAccountint(int number) {
        for (Account acc : accounts) {
            if (acc.getNumber() == number) {
                return acc.getNumber();
            }
        }
        return 0;
    }
    public Account getAccount(int number) {
        for (Account acc : accounts) {
            if (acc.getNumber() == number) {
                return acc;
            }
        }
        return null;
    }
    public void addATM(ATM atm){
        atms.add(atm);
    }
    public List<ATM> getAtms() {
        return atms;
    }
    public ATM getATM(int number) {
        for (ATM atm : atms) {
            if(atm.getIdentification_number()==number){
                return atm;
            }
        }
        return null;
    }
    public void removeATM(ATM atmToRemove) {
        Iterator<ATM> iterator = atms.iterator();
        while (iterator.hasNext()) {
            ATM atm = iterator.next();
            if (atm.getIdentification_number() == atmToRemove.getIdentification_number()) {
                iterator.remove();
                break;
            }
        }
    }
}
