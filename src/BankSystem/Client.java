package BankSystem;

import java.util.ArrayList;

public class Client {
  public ArrayList<Account> account;
  public String name;
  public String lastName;
  public String numberPhone;

  public Client(String name, String lastName, String numberPhone) {
    this.name = name;
    this.lastName = lastName;
    this.numberPhone = numberPhone;
    account = new ArrayList<>();
  }

  public Client createAccount(Currency currency, String label, int amount) {
    this.account.add(new Account(currency, label, amount));
    return this;
  }


  public String getPhone() {
    return numberPhone;
  }
}
